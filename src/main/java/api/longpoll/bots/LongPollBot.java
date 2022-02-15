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
    private final GetLongPollServer getLongPollServer = new GetLongPollServer(getAccessToken());

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
        if (groupId == null) {
            groupId = vk.groups.getById()
                    .execute()
                    .getResponseObject()
                    .get(0)
                    .getId();
        }

        resetGetUpdates();
        while (polling) {
            try {
                GetUpdates.Response updates = getUpdates.execute();
                getUpdates.setTs(updates.getTs());
                handle(updates.getEvents());
            } catch (VkApiHttpException e) {
                LOGGER.warn("Failed to get events from VK Long Poll Server.", e);
                resetGetUpdates();
            } catch (VkApiResponseException e) {
                LOGGER.warn("Failed to get events from VK Long Poll Server.", e);
                if (!e.getError().has("failed")) {
                    throw e;
                }
                resetGetUpdates();
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
     * Initialises {@link LongPollBot#getUpdates} object.
     *
     * @throws VkApiException if errors occur.
     */
    private void resetGetUpdates() throws VkApiException {
        GetLongPollServer.Response longPollServer = getLongPollServer();
        getUpdates.setServer(getLongPollServer().getResponseObject().getServer())
                .setKey(longPollServer.getResponseObject().getKey())
                .setTs(longPollServer.getResponseObject().getTs());
    }

    /**
     * Gets Long Poll server.
     *
     * @return Long Poll server.
     * @throws VkApiException if errors occur.
     */
    private GetLongPollServer.Response getLongPollServer() throws VkApiException {
        return getLongPollServer.setGroupId(groupId).execute();
    }
}
