package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponseBody;
import api.longpoll.bots.utils.VkMethods;

/**
 * Implements <b>groups.disableOnline</b> method.
 * <p>
 * Disables "online" status in the community.
 *
 * @see <a href="https://vk.com/dev/groups.disableOnline">https://vk.com/dev/groups.disableOnline</a>
 */
public class DisableOnline extends VkMethod<IntegerResponseBody> {
    public DisableOnline(String accessToken) {
        super(VkMethods.get("groups.disableOnline"), accessToken);
    }

    @Override
    protected Class<IntegerResponseBody> getResponseClass() {
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
