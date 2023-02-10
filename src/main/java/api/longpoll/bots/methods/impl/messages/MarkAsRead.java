package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponseBody;
import api.longpoll.bots.utils.VkMethods;

/**
 * Implements <b>messages.markAsRead</b> method.
 * <p>
 * Marks messages as read.
 *
 * @see <a href="https://vk.com/dev/messages.markAsRead">https://vk.com/dev/messages.markAsRead</a>
 */
public class MarkAsRead extends VkMethod<IntegerResponseBody> {
    public MarkAsRead(String accessToken) {
        super(VkMethods.get("messages.markAsRead"), accessToken);
    }

    @Override
    protected Class<IntegerResponseBody> getResponseClass() {
        return IntegerResponseBody.class;
    }

    public MarkAsRead setPeerId(int peerId) {
        return addParam("peer_id", peerId);
    }

    public MarkAsRead setStartMessageId(int startMessageId) {
        return addParam("start_message_id", startMessageId);
    }

    public MarkAsRead setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public MarkAsRead setMarkConversationAsRead(boolean markConversationAsRead) {
        return addParam("mark_conversation_as_read", markConversationAsRead ? 1 : 0);
    }

    @Override
    public MarkAsRead addParam(String key, Object value) {
        return (MarkAsRead) super.addParam(key, value);
    }
}
