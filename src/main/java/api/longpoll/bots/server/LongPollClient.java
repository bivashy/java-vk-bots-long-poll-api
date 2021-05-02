package api.longpoll.bots.server;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.exceptions.BotsLongPollAPIException;
import api.longpoll.bots.exceptions.BotsLongPollException;
import api.longpoll.bots.methods.events.GetUpdates;
import api.longpoll.bots.methods.groups.GroupsGetLongPollServer;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.response.events.GetUpdatesResult;
import api.longpoll.bots.model.response.groups.GroupsGetLongPollServerResult;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LongPollClient implements Client {
    private static final Logger log = LoggerFactory.getLogger(LongPollClient.class);
    private static final int ATTEMPTS = 10;

    private static final Gson GSON = new Gson();
    private GroupsGetLongPollServer groupsGetLongPollServer;
    private GetUpdates getUpdates;

    public LongPollClient(LongPollBot bot) {
        groupsGetLongPollServer = new GroupsGetLongPollServer(bot.getAccessToken()).setGroupId(bot.getGroupId());
        getUpdates = new GetUpdates();
    }

    @Override
    public List<Event> getUpdates() throws BotsLongPollAPIException, BotsLongPollException {
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

    public void init() throws BotsLongPollAPIException, BotsLongPollException {
        GroupsGetLongPollServerResult.Response response = groupsGetLongPollServer.execute().getResponse();
        getUpdates.setServer(response.getServer())
                .setKey(response.getKey())
                .setTs(response.getTs());
    }

    protected void tryHandle(BotsLongPollAPIException e) throws BotsLongPollException, BotsLongPollAPIException {
        log.warn("Failed to get events from VK Long Poll Server.", e);
        JsonObject jsonObject = e.getJsonError();

        if (!jsonObject.has("failed")) {
            throw e;
        }

        int code = jsonObject.get("failed").getAsInt();
        switch (code) {
            case 1:
                getUpdates.setTs(jsonObject.get("ts").getAsInt());
                break;
            case 2:
            case 3:
                init();
                break;
        }
    }
}
