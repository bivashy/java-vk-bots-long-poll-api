package api.longpoll.bots;

import api.longpoll.bots.config.VkBotsConfig;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(LongPollBot.class);
    private boolean polling = true;
    private final GetLongPollServer getLongPollServer = VkBotsConfig.getInstance().getGetLongPollServerFactory().get(getAccessToken());
    private final GetUpdates getUpdates = VkBotsConfig.getInstance().getGetUpdates();

    public void startPolling() throws VkApiException {
        resetGetUpdates();
        while (polling) {
            try {
                GetUpdates.Response updates = getUpdates.execute();
                getUpdates.setTs(updates.getTs());
                handle(updates.getEvents());
            } catch (VkApiResponseException e) {
                LOGGER.warn("Failed to get events from VK Long Poll Server.", e);
                resetGetUpdates();
            }
        }
    }

    public void stopPolling() {
        polling = false;
    }

    private void resetGetUpdates() throws VkApiException {
        GetLongPollServer.Response longPollServer = getLongPollServer.setGroupId(getGroupId()).execute();
        getUpdates
                .setServer(longPollServer.getResponseObject().getServer())
                .setKey(longPollServer.getResponseObject().getKey())
                .setTs(longPollServer.getResponseObject().getTs());
    }
}
