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
    protected String accessToken;

    /**
     * Long Poll bot.
     */
    protected LongPollBot bot;

    public GetMethod(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    protected List<Connection.KeyVal> getData() {
        List<Connection.KeyVal> requestParams = super.getData();

        requestParams.add(keyVal(ACCESS_TOKEN, accessToken));
        requestParams.add(keyVal(VERSION, VkApi.getInstance().apiVersion()));

        return requestParams;
    }

    @Override
    protected Connection.Method getMethod() {
        return Connection.Method.GET;
    }
}
