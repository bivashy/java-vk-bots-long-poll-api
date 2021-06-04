package api.longpoll.bots.methods.events;

import api.longpoll.bots.methods.VkApiMethod;
import api.longpoll.bots.model.response.events.GetUpdatesResult;
import org.jsoup.Connection;

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
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(
                keyVal("act", "a_check"),
                keyVal("wait", "25"),
                keyVal("key", key),
                keyVal("ts", ts)
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
    protected Connection.Method getMethod() {
        return Connection.Method.GET;
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
