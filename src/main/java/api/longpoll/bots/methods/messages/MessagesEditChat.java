package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.other.IntegerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class MessagesEditChat extends GetMethod<IntegerResult> {
    private Integer chatId;
    private String title;

    public MessagesEditChat(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.Messages.EDIT_CHAT;
    }

    @Override
    protected JsonToPojoConverter<IntegerResult> getConverter() {
        return GenericConverterFactory.get(IntegerResult.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("chat_id", chatId),
                keyVal("title", title)
        );
    }

    public Integer getChatId() {
        return chatId;
    }

    public MessagesEditChat setChatId(Integer chatId) {
        this.chatId = chatId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MessagesEditChat setTitle(String title) {
        this.title = title;
        return this;
    }
}
