package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponseBody;

/**
 * Implements <b>messages.removeChatUser</b> method.
 * <p>
 * Allows the current user to leave a chat or, if the current user started the chat, allows the user to remove another user from the chat.
 *
 * @see <a href="https://vk.com/dev/messages.removeChatUser">https://vk.com/dev/messages.removeChatUser</a>
 */
public class RemoveChatUser extends VkMethod<IntegerResponseBody> {
    public RemoveChatUser(String accessToken) {
        super(property("messages.removeChatUser"), accessToken);
    }

    @Override
    protected Class<IntegerResponseBody> getResponseClass() {
        return IntegerResponseBody.class;
    }

    public RemoveChatUser setChatId(int chatId) {
        return addParam("chat_id", chatId);
    }

    public RemoveChatUser setUserId(int userId) {
        return addParam("user_id", userId);
    }

    public RemoveChatUser setMemberId(int memberId) {
        return addParam("member_id", memberId);
    }

    @Override
    public RemoveChatUser addParam(String key, Object value) {
        return (RemoveChatUser) super.addParam(key, value);
    }
}
