package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponseBody;
import api.longpoll.bots.utils.VkMethods;

/**
 * Implements <b>messages.restore</b> method.
 * <p>
 * Restores a deleted message.
 *
 * @see <a href="https://vk.com/dev/messages.restore">https://vk.com/dev/messages.restore</a>
 */
public class Restore extends VkMethod<IntegerResponseBody> {
    public Restore(String accessToken) {
        super(VkMethods.get("messages.restore"), accessToken);
    }

    @Override
    protected Class<IntegerResponseBody> getResponseClass() {
        return IntegerResponseBody.class;
    }

    public Restore setMessageId(int messageId) {
        return addParam("message_id", messageId);
    }

    public Restore setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public Restore addParam(String key, Object value) {
        return (Restore) super.addParam(key, value);
    }
}
