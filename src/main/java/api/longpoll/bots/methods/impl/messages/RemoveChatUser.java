package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>messages.removeChatUser</b> method.
 * <p>
 * Allows the current user to leave a chat or, if the current user started the chat, allows the user to remove another user from the chat.
 *
 * @see <a href="https://vk.com/dev/messages.removeChatUser">https://vk.com/dev/messages.removeChatUser</a>
 */
public class RemoveChatUser extends AuthorizedVkApiMethod<IntegerResponse> {
    public RemoveChatUser(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.removeChatUser");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
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
