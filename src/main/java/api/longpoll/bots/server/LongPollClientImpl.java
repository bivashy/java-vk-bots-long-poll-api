package api.longpoll.bots.server;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.exceptions.BotsLongPollAPIException;
import api.longpoll.bots.exceptions.BotsLongPollException;
import api.longpoll.bots.methods.events.GetUpdates;
import api.longpoll.bots.methods.groups.GroupsGetLongPollServer;
import api.longpoll.bots.model.events.VkEvent;
import api.longpoll.bots.model.response.events.GetUpdatesResult;
import api.longpoll.bots.model.response.groups.GroupsGetLongPollServerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Client to get Vk Long Poll updates.
 */
public class LongPollClientImpl implements LongPollClient {
    /**
     * Logger object.
     */
    private static final Logger log = LoggerFactory.getLogger(LongPollClientImpl.class);

    /**
     * Number of attempts to get VK events.
     */
    private static final int ATTEMPTS = 10;

    /**
     * VK API request to get Long Poll server details.
     */
    private GroupsGetLongPollServer groupsGetLongPollServer;

    /**
     * VK API request to get VK events.
     */
    private GetUpdates getUpdates;

    public LongPollClientImpl(LongPollBot bot) {
        groupsGetLongPollServer = new GroupsGetLongPollServer(bot.getAccessToken()).setGroupId(bot.getGroupId());
    }

    @Override
    public List<VkEvent> getEvents() throws BotsLongPollException {
        if (getUpdates == null) {
            getUpdates = new GetUpdates();
            init();
        }

        for (int attempt = 0; attempt < ATTEMPTS; attempt++) {
            log.debug("Getting events from VK Long Poll Server. Attempt: {}.", attempt + 1);
            try {
                GetUpdatesResult getUpdatesResult = getUpdates.execute();
                getUpdates.setTs(getUpdatesResult.getTs());
                return getUpdatesResult.getEvents();
            } catch (BotsLongPollAPIException e) {
                tryHandle(e);
            }
        }

        throw new BotsLongPollException("Failed to get events from Long Poll server. Number of attempts: " + ATTEMPTS);
    }

    private void init() throws BotsLongPollException {
        GroupsGetLongPollServerResult.Response response = groupsGetLongPollServer.execute().getResponse();
        getUpdates.setServer(response.getServer())
                .setKey(response.getKey())
                .setTs(response.getTs());
    }

    private void tryHandle(BotsLongPollAPIException e) throws BotsLongPollException {
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
