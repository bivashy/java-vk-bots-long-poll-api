package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.other.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class MessagesRemoveChatUser extends GetMethod<GenericResult<Integer>> {
    private Integer chatId;
    private Integer userId;
    private Integer memberId;

    public MessagesRemoveChatUser(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.Messages.REMOVE_CHAT_USER;
    }

    @Override
    protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<Integer>>(){}.getType());
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
