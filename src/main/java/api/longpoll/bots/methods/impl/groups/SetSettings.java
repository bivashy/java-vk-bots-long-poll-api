package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponseBody;

/**
 * Implements <b>groups.setSettings</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.setSettings">https://vk.com/dev/groups.setSettings</a>
 */
public class SetSettings extends VkMethod<IntegerResponseBody> {

    public SetSettings(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUri() {
        return VK_METHODS.getProperty("groups.setSettings");
    }

    @Override
    protected Class<IntegerResponseBody> getResponseType() {
        return IntegerResponseBody.class;
    }

    public SetSettings setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public SetSettings setMessages(boolean messages) {
        return addParam("messages", messages ? 1 : 0);
    }

    public SetSettings setBotsCapabilities(boolean botsCapabilities) {
        return addParam("bots_capabilities", botsCapabilities ? 1 : 0);
    }

    public SetSettings setBotsAddToChat(boolean botsAddToChat) {
        return addParam("bots_add_to_chat", botsAddToChat ? 1 : 0);
    }

    @Override
    public SetSettings addParam(String key, Object value) {
        return (SetSettings) super.addParam(key, value);
    }
}
