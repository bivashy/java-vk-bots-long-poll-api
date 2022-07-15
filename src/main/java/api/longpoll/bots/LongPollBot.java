package api.longpoll.bots;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.exceptions.VkApiHttpException;
import api.longpoll.bots.exceptions.VkApiResponseException;
import api.longpoll.bots.methods.impl.events.GetUpdates;
import api.longpoll.bots.methods.impl.groups.GetLongPollServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract bot to handle VK events.
 */
public abstract class LongPollBot extends VkBot {
    /**
     * {@link Logger} object.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LongPollBot.class);

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
     * Begins listening to VK updates.
     *
     * @throws VkApiException if errors occur.
     */
    public void startPolling() throws VkApiException {
        initialize();
        while (polling) {
            try {
                GetUpdates.Response updates = getUpdates.execute();
                getUpdates.setTs(updates.getTs());
                handle(updates.getEvents());
            }  catch (VkApiHttpException | VkApiResponseException e) {
                LOGGER.warn("Failed to get events from VK Long Poll Server.", e);
                if (e instanceof VkApiResponseException && !((VkApiResponseException) e).getError().has("failed")) {
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
    private void initialize() throws VkApiException {
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
}
