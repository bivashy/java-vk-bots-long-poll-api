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

public class MessagesMarkAsImportantConversation extends GetMethod<GenericResult<Integer>> {
    private Integer peerId;
    private Boolean answered;
    private Integer groupId;

    public MessagesMarkAsImportantConversation(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.Messages.MARK_AS_IMPORTANT_CONVERSATION;
    }

    @Override
    protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<Integer>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("peer_id", peerId),
                keyVal("answered", answered, true),
                keyVal("group_id", groupId)
        );
    }

    public Integer getPeerId() {
        return peerId;
    }

    public MessagesMarkAsImportantConversation setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public Boolean getAnswered() {
        return answered;
    }

    public MessagesMarkAsImportantConversation setAnswered(Boolean answered) {
        this.answered = answered;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesMarkAsImportantConversation setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
