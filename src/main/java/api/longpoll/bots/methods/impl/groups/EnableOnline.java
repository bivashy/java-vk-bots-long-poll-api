package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponseBody;

/**
 * Implements <b>groups.enableOnline</b> method.
 * <p>
 * Enables "online" status in the community.
 *
 * @see <a href="https://vk.com/dev/groups.enableOnline">https://vk.com/dev/groups.enableOnline</a>
 */
public class EnableOnline extends VkMethod<IntegerResponseBody> {
    public EnableOnline(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUri() {
        return VK_METHODS.getProperty("groups.enableOnline");
    }

    @Override
    protected Class<IntegerResponseBody> getResponseType() {
        return IntegerResponseBody.class;
    }

    public EnableOnline setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public EnableOnline addParam(String key, Object value) {
        return (EnableOnline) super.addParam(key, value);
    }
}
