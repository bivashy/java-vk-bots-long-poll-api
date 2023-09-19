package api.longpoll.bots;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.exceptions.VkResponseException;
import api.longpoll.bots.methods.impl.events.GetUpdates;
import com.google.gson.JsonObject;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Abstract bot to handle VK events.
 */
public abstract class LongPollBot extends VkBot {
    /**
     * Default session time.
     *
     * @see LongPollBot#sessionDuration
     */
    private static final long DEFAULT_SESSION_DURATION = 9;

    /**
     * Server URL.
     */
    private String server;

    /**
     * Session key.
     */
    private String key;

    /**
     * Latest received event.
     */
    private int ts;

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
                GetUpdates.ResponseBody updates = getUpdates().execute();
                ts = updates.getTs();
                handle(updates.getEvents());
            } catch (VkResponseException e) {
                if (!e.getMessage().contains("failed")) {
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

        JsonObject longPollServer = vk.other.execute()
                .setCode("return API.groups.getLongPollServer({\"group_id\":API.groups.getById()@.id[0]});")
                .execute()
                .getResponse()
                .getAsJsonObject();

        server = longPollServer.get("server").getAsString();
        key = longPollServer.get("key").getAsString();
        ts = longPollServer.get("ts").getAsInt();
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

    /**
     * Produces new {@link GetUpdates} instance based on {@link LongPollBot#server}, {@link LongPollBot#key} and {@link LongPollBot#ts}.
     *
     * @return {@link GetUpdates} instance.
     */
    private GetUpdates getUpdates() {
        return new GetUpdates(server)
                .setKey(key)
                .setTs(ts);
    }
}
