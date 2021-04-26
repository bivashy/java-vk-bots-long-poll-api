package api.longpoll.bots.methods;

import org.jsoup.Connection;

import java.util.List;

/**
 * Executes generic GET HTTP request to VK API.
 *
 * @param <Response> VK API response type.
 * @see Method
 */
public abstract class GetMethod<Response> extends Method<Response> {
    /**
     * Access token of group bot. Used as URL parameter of VK API request.
     * Its value is {@link GetMethod#accessToken}.
     * Required for almost all GET HTTP requests to VK API.
     */
    private static final String ACCESS_TOKEN = "access_token";
    /**
     * Version of VK API. Used as URL parameter of VK API request.
     * Its value is taken from {@link VkApi#apiVersion()}.
     * Required for almost all GET HTTP requests to VK API.
     */
    private static final String VERSION = "v";

    /**
     * Group bot access token.
     */
    protected String accessToken;

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
