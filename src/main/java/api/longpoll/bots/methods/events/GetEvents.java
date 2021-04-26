package api.longpoll.bots.methods.events;

import api.longpoll.bots.methods.Method;
import api.longpoll.bots.model.response.events.GetEventsResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Gets update events from VK server.
 */
public class GetEvents extends Method<GetEventsResult> {
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
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("act", "a_check"),
                keyVal("wait", "25"),
                keyVal("key", key),
                keyVal("ts", ts)
        );
    }

    @Override
    protected Class<? extends GetEventsResult> getResultType() {
        return GetEventsResult.class;
    }

    @Override
    protected String getApi() {
        return server;
    }

    @Override
    protected Connection.Method getMethod() {
        return Connection.Method.GET;
    }

    public String getServer() {
        return server;
    }

    public GetEvents setServer(String server) {
        this.server = server;
        return this;
    }

    public String getKey() {
        return key;
    }

    public GetEvents setKey(String key) {
        this.key = key;
        return this;
    }

    public Integer getTs() {
        return ts;
    }

    public GetEvents setTs(Integer ts) {
        this.ts = ts;
        return this;
    }
}
