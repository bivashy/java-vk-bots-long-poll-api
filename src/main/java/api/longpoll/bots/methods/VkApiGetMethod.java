package api.longpoll.bots.methods;

import kong.unirest.HttpRequest;
import kong.unirest.Unirest;

import java.util.Map;

/**
 * Executes generic GET HTTP request to VK API.
 *
 * @param <Response> VK API response type.
 * @see VkApiMethod
 */
public abstract class VkApiGetMethod<Response> extends VkApiMethod<Response> {
    /**
     * Access token of group bot. Used as URL parameter of VK API request.
     * Its value is {@link VkApiGetMethod#accessToken}.
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

    public VkApiGetMethod(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    protected Map<String, Object> getData() {
        Map<String, Object> requestParams = super.getData();

        requestParams.put(ACCESS_TOKEN, accessToken);
        requestParams.put(VERSION, VkApi.getInstance().apiVersion());

        return requestParams;
    }

    @Override
    protected HttpRequest<?> httpRequest() {
        return Unirest.get(getApi());
    }
}
