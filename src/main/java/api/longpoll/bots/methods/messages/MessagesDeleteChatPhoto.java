package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.messages.MessagesDeleteChatPhotoResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class MessagesDeleteChatPhoto extends GetMethod<MessagesDeleteChatPhotoResult> {
    private Integer chatId;
    private Integer groupId;

    public MessagesDeleteChatPhoto(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesDeleteChatPhoto();
    }

    @Override
    protected JsonToPojoConverter<MessagesDeleteChatPhotoResult> getConverter() {
        return GenericConverterFactory.get(MessagesDeleteChatPhotoResult.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("chat_id", chatId),
                keyVal("group_id", groupId)
        );
    }

    public Integer getChatId() {
        return chatId;
    }

    public MessagesDeleteChatPhoto setChatId(Integer chatId) {
        this.chatId = chatId;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesDeleteChatPhoto setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
