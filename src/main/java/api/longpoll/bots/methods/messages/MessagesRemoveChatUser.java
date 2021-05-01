package api.longpoll.bots.methods.messages;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.IntegerResult;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>messages.removeChatUser</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.removeChatUser">https://vk.com/dev/messages.removeChatUser</a>
 */
public class MessagesRemoveChatUser extends VkApiGetMethod<IntegerResult> {
    /**
     * Chat ID.
     */
    private Integer chatId;

    /**
     * ID of the user to be removed from the chat.
     */
    private Integer userId;

    /**
     * ID of the member to be removed. For communities: -group_id.
     */
    private Integer memberId;

    public MessagesRemoveChatUser(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesRemoveChatUser();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("chat_id", chatId),
                param("user_id", userId),
                param("member_id", memberId)
        );
    }

    @Override
    protected Class<? extends IntegerResult> getResultType() {
        return IntegerResult.class;
    }

    public MessagesRemoveChatUser setChatId(Integer chatId) {
        this.chatId = chatId;
        return this;
    }

    public MessagesRemoveChatUser setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public MessagesRemoveChatUser setMemberId(Integer memberId) {
        this.memberId = memberId;
        return this;
    }
}
