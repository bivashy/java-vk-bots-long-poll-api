package api.longpoll.bots.client;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.json.GsonConverter;
import api.longpoll.bots.converters.json.JsonConverter;
import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.exceptions.VkApiResponseException;
import api.longpoll.bots.methods.impl.events.GetUpdates;
import api.longpoll.bots.methods.impl.groups.GetLongPollServer;
import api.longpoll.bots.model.events.VkEvent;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Default client to get VK  Long Poll updates.
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

    /**
     * JSON converter.
     */
    private JsonConverter jsonConverter;

    public DefaultLongPollClient(LongPollBot bot) {
        this(bot, new GsonConverter());
    }

    public DefaultLongPollClient(LongPollBot bot, JsonConverter jsonConverter) {
        this.getLongPollServer = new GetLongPollServer(bot.getAccessToken()).setGroupId(bot.getGroupId());
        this.jsonConverter = jsonConverter;
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

        JsonObject jsonObject = jsonConverter.convert(e.getMessage(), JsonObject.class);

        if (jsonObject == null || !jsonObject.has("failed")) {
            throw e;
        }

        switch (jsonObject.get("failed").getAsInt()) {
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
