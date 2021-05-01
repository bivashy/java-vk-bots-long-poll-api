package api.longpoll.bots.methods.events;

import api.longpoll.bots.methods.VkApiMethod;
import api.longpoll.bots.model.response.events.GetUpdatesResult;
import kong.unirest.HttpRequest;
import kong.unirest.Unirest;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Gets update events from VK server.
 */
public class GetUpdates extends VkApiMethod<GetUpdatesResult> {
    /**
     * Server URL.
     */
    private String server;

    /**
     * Key.
     */
    private String key;

    /**
     * Timestamp.
     */
    private Integer ts;

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("act", "a_check"),
                param("wait", "25"),
                param("key", key),
                param("ts", ts)
        );
    }

    @Override
    protected Class<? extends GetUpdatesResult> getResultType() {
        return GetUpdatesResult.class;
    }

    @Override
    protected String getApi() {
        return server;
    }

    @Override
    protected HttpRequest<?> httpRequest() {
        return Unirest.get(getApi());
    }

    public GetUpdates setServer(String server) {
        this.server = server;
        return this;
    }

    public GetUpdates setKey(String key) {
        this.key = key;
        return this;
    }

    public GetUpdates setTs(Integer ts) {
        this.ts = ts;
        return this;
    }
}
