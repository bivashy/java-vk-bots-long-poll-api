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

public class MessagesRestore extends GetMethod<GenericResult<Integer>> {
    private Integer messageId;
    private Integer groupId;

    public MessagesRestore(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesRestore();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<Integer>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("message_id", messageId),
                keyVal("group_id", groupId)
        );
    }

    public Integer getMessageId() {
        return messageId;
    }

    public MessagesRestore setMessageId(Integer messageId) {
        this.messageId = messageId;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesRestore setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
