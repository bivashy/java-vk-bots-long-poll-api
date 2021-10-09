package api.longpoll.bots.methods.impl.utils;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>utils.getServerTime</b> method.
 * <p>
 * Returns the current time of the VK server.
 *
 * @see <a href="https://vk.com/dev/utils.getServerTime">https://vk.com/dev/utils.getServerTime</a>
 */
public class GetServerTime extends AuthorizedVkApiMethod<IntegerResponse> {
    public GetServerTime(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("utils.getServerTime");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    @Override
    public GetServerTime addParam(String key, Object value) {
        return (GetServerTime) super.addParam(key, value);
    }
}
