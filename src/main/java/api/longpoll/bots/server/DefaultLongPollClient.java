package api.longpoll.bots.server;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.exceptions.VkApiResponseException;
import api.longpoll.bots.methods.impl.events.GetUpdates;
import api.longpoll.bots.methods.impl.groups.GetLongPollServer;
import api.longpoll.bots.model.events.VkEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Default client to get VK Long Poll updates.
 */
public class DefaultLongPollClient implements LongPollClient {
    /**
     * Logger object.
     */
    private static final Logger log = LoggerFactory.getLogger(DefaultLongPollClient.class);

    /**
     * Number of attempts to get VK events.
     */
    private static final int ATTEMPTS = 10;

    /**
     * VK API request to get Long Poll server details.
     */
    private GetLongPollServer getLongPollServer;

    /**
     * VK API request to get VK events.
     */
    private GetUpdates getUpdates;

    public DefaultLongPollClient(LongPollBot bot) {
        getLongPollServer = new GetLongPollServer(bot.getAccessToken()).setGroupId(bot.getGroupId());
    }

    @Override
    public List<VkEvent> getEvents() throws VkApiException {
        if (getUpdates == null) {
            getUpdates = new GetUpdates();
            init();
        }

        for (int attempt = 0; attempt < ATTEMPTS; attempt++) {
            log.debug("Getting events from VK Long Poll Server. Attempt: {}.", attempt + 1);
            try {
                GetUpdates.Response response = getUpdates.execute();
                getUpdates.setTs(response.getTs());
                return response.getEvents();
            } catch (VkApiResponseException e) {
                tryHandle(e);
            }
        }

        throw new VkApiException("Failed to get events from Long Poll server. Number of attempts: " + ATTEMPTS);
    }

    private void init() throws VkApiException {
        GetLongPollServer.Response.ResponseObject response = getLongPollServer.execute().getResponseObject();
        getUpdates.setServer(response.getServer())
                .setKey(response.getKey())
                .setTs(response.getTs());
    }

    private void tryHandle(VkApiResponseException e) throws VkApiException {
        log.warn("Failed to get events from VK Long Poll Server.", e);

        Map<String, String> params = toParams(e.getMessage());
        if (!params.containsKey("failed") || !params.containsKey("ts")) {
            throw e;
        }

        switch (Integer.parseInt(params.get("failed"))) {
            case 1:
                getUpdates.setTs(Integer.parseInt(params.get("ts")));
                break;
            case 2:
            case 3:
                init();
                break;
        }
    }

    private Map<String, String> toParams(String json) {
        String[] keyVal = json.trim()
                .substring(1, json.length() - 1)
                .replaceAll("[\\s\\n]", "")
                .split(":");

        HashMap<String, String> params = new HashMap<>();
        for (int i = 0; i < keyVal.length; i++) {
            params.put(keyVal[i], keyVal[++i]);
        }

        return params;
    }
}
