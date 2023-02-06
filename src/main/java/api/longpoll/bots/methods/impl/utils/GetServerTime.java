package api.longpoll.bots.methods.impl.utils;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponseBody;

/**
 * Implements <b>utils.getServerTime</b> method.
 * <p>
 * Returns the current time of the VK server.
 *
 * @see <a href="https://vk.com/dev/utils.getServerTime">https://vk.com/dev/utils.getServerTime</a>
 */
public class GetServerTime extends VkMethod<IntegerResponseBody> {
    public GetServerTime(String accessToken) {
        super(property("utils.getServerTime"), accessToken);
    }

    @Override
    protected Class<IntegerResponseBody> getResponseClass() {
        return IntegerResponseBody.class;
    }

    @Override
    public GetServerTime addParam(String key, Object value) {
        return (GetServerTime) super.addParam(key, value);
    }
}
