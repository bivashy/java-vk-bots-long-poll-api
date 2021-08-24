package api.longpoll.bots.methods;

import org.jsoup.Connection;

import java.util.List;

/**
 * Executes generic GET HTTP request to VK API.
 *
 * @param <Response> VK API response type.
 * @see VkApiMethod
 */
public abstract class VkApiGetMethod<Response> extends VkApiMethod<Response> {
    /**
     * Group bot access token.
     */
    protected String accessToken;

    public VkApiGetMethod(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    protected List<Connection.KeyVal> collectParams() {
        List<Connection.KeyVal> requestParams = super.collectParams();

        requestParams.add(keyVal("access_token", accessToken));
        requestParams.add(keyVal("v", VkApiProperties.get("api.version")));

        return requestParams;
    }

    @Override
    protected Connection.Method getMethod() {
        return Connection.Method.GET;
    }
}
