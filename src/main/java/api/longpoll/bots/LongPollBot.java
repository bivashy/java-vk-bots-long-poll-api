package api.longpoll.bots;

import api.longpoll.bots.exceptions.VkApiException;
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
        propagateGroupId();
        resetGetUpdates();
        while (polling) {
            try {
                GetUpdates.Response updates = getUpdates.execute();
                getUpdates.setTs(updates.getTs());
                handle(updates.getEvents());
            } catch (VkApiException e) {
                // W/A to avoid 504 Errors
                if (!(e instanceof VkApiResponseException) && !e.getMessage().contains("HTTP response code: 504")) {
                    throw e;
                }
                LOGGER.warn("Failed to get events from VK Long Poll Server.", e);
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
        GetLongPollServer.Response longPollServer = getLongPollServer.setGroupId(getGroupId()).execute();
        getUpdates.setServer(longPollServer.getResponseObject().getServer())
                .setKey(longPollServer.getResponseObject().getKey())
                .setTs(longPollServer.getResponseObject().getTs());
    }

    private void propagateGroupId() throws VkApiException {
        if (getGroupId() == null) {
            setGroupId(vk.groups.getById()
                    .execute()
                    .getResponseObject()
                    .get(0)
                    .getId()
            );
        }
    }
}
