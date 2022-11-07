package api.longpoll.bots;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.exceptions.VkApiHttpException;
import api.longpoll.bots.exceptions.VkApiResponseException;
import api.longpoll.bots.methods.impl.events.GetUpdates;
import api.longpoll.bots.methods.impl.groups.GetLongPollServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Abstract bot to handle VK events.
 */
public abstract class LongPollBot extends VkBot {
    /**
     * {@link Logger} object.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LongPollBot.class);

    /**
     * Default session time.
     *
     * @see LongPollBot#sessionDuration
     */
    private static final long DEFAULT_SESSION_DURATION = 9;

    /**
     * Group ID.
     */
    private Integer groupId;

    /**
     * Gets VK long poll server.
     */
    private GetLongPollServer getLongPollServer;

    /**
     * Gets VK updates.
     */
    private final GetUpdates getUpdates = new GetUpdates();

    /**
     * Whether infinite loop should be continued.
     */
    private boolean polling = true;

    /**
     * Last time when {@link LongPollBot#initialize()} was called.
     */
    private LocalDateTime initializedAt;

    /**
     * Long Poll session duration (in hours).
     * When time is expired, {@link LongPollBot#initialize()} method is called.
     */
    private long sessionDuration = DEFAULT_SESSION_DURATION;

    /**
     * Begins listening to VK updates.
     *
     * @throws VkApiException if errors occur.
     */
    public void startPolling() throws VkApiException {
        initialize();
        while (polling) {
            try {
                if (isSessionExpired()) {
                    initialize();
                }
                GetUpdates.ResponseBody updates = getUpdates.execute();
                getUpdates.setTs(updates.getTs());
                handle(updates.getEvents());
            } catch (VkApiHttpException | VkApiResponseException e) {
                LOGGER.warn("Failed to get events from VK Long Poll Server.", e);
                if (e instanceof VkApiResponseException && !e.getMessage().contains("failed")) {
                    throw e;
                }
                initialize();
            }
        }
    }

    /**
     * Stops listening to VK updates.
     */
    public void stopPolling() {
        polling = false;
    }

    /**
     * Initializes {@link LongPollBot}.
     *
     * @throws VkApiException if errors occur.
     */
    public void initialize() throws VkApiException {
        initializedAt = LocalDateTime.now();

        if (groupId == null) {
            groupId = vk.other.execute()
                    .setCode("return API.groups.getById()@.id[0];")
                    .execute()
                    .getResponse()
                    .getAsInt();
        }

        if (getLongPollServer == null) {
            getLongPollServer = new GetLongPollServer(getAccessToken());
        }

        GetLongPollServer.ResponseBody longPollServer = getLongPollServer.setGroupId(groupId).execute();
        getUpdates.setServer(longPollServer.getResponse().getServer())
                .setKey(longPollServer.getResponse().getKey())
                .setTs(longPollServer.getResponse().getTs());
    }

    /**
     * Sets session duration (in hours).
     *
     * @param sessionDuration session duration (in hours).
     */
    public void setSessionDuration(long sessionDuration) {
        this.sessionDuration = sessionDuration;
    }

    /**
     * Checks whether Long Poll session is expired.
     *
     * @return {@code true} if Long Poll session is expired, {@code false} otherwise.
     */
    private boolean isSessionExpired() {
        return ChronoUnit.HOURS.between(initializedAt, LocalDateTime.now()) >= sessionDuration;
    }
}
