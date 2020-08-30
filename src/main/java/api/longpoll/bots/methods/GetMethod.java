package api.longpoll.bots.methods;

import api.longpoll.bots.LongPollBot;
import org.jsoup.Connection;

import java.util.List;

/**
 * Implements VK API GET method.
 *
 * @param <Response> response type.
 */
public abstract class GetMethod<Response> extends Method<Response> {
    private static final String ACCESS_TOKEN = "access_token";
    private static final String VERSION = "v";
    private static final String VERSION_NUMBER = "5.110";

    /**
     * Long Poll bot.
     */
    protected LongPollBot bot;

    public GetMethod(LongPollBot bot) {
        this.bot = bot;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<Connection.KeyVal> getData() {
        List<Connection.KeyVal> requestParams = super.getData();

        requestParams.add(keyVal(ACCESS_TOKEN, bot.getAccessToken()));
        requestParams.add(keyVal(VERSION, VERSION_NUMBER));

        return requestParams;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Connection.Method getMethod() {
        return Connection.Method.GET;
    }
}
