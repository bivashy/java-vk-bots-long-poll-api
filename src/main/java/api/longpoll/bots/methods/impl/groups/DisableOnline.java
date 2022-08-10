package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponseBody;

/**
 * Implements <b>groups.disableOnline</b> method.
 * <p>
 * Disables "online" status in the community.
 *
 * @see <a href="https://vk.com/dev/groups.disableOnline">https://vk.com/dev/groups.disableOnline</a>
 */
public class DisableOnline extends VkMethod<IntegerResponseBody> {
    public DisableOnline(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUri() {
        return property("groups.disableOnline");
    }

    @Override
    protected Class<IntegerResponseBody> getResponseType() {
        return IntegerResponseBody.class;
    }

    public DisableOnline setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public DisableOnline addParam(String key, Object value) {
        return (DisableOnline) super.addParam(key, value);
    }
}
