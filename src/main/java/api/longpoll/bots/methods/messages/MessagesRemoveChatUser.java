package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.CachedConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>messages.removeChatUser</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.removeChatUser">https://vk.com/dev/messages.removeChatUser</a>
 */
public class MessagesRemoveChatUser extends GetMethod<GenericResult<Integer>> {
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

    public MessagesRemoveChatUser(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesRemoveChatUser();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
        return CachedConverterFactory.getConverter(GenericResult.class, Integer.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("chat_id", chatId),
                keyVal("user_id", userId),
                keyVal("member_id", memberId)
        );
    }

    public Integer getChatId() {
        return chatId;
    }

    public MessagesRemoveChatUser setChatId(Integer chatId) {
        this.chatId = chatId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public MessagesRemoveChatUser setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public MessagesRemoveChatUser setMemberId(Integer memberId) {
        this.memberId = memberId;
        return this;
    }
}
