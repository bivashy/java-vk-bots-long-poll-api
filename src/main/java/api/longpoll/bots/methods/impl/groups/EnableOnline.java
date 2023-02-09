package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponseBody;
import api.longpoll.bots.utils.VkMethods;

/**
 * Implements <b>groups.enableOnline</b> method.
 * <p>
 * Enables "online" status in the community.
 *
 * @see <a href="https://vk.com/dev/groups.enableOnline">https://vk.com/dev/groups.enableOnline</a>
 */
public class EnableOnline extends VkMethod<IntegerResponseBody> {
    public EnableOnline(String accessToken) {
        super(VkMethods.get("groups.enableOnline"), accessToken);
    }

    @Override
    protected Class<IntegerResponseBody> getResponseClass() {
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
