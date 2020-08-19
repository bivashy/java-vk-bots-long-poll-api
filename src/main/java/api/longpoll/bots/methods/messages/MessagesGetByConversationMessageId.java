package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.response.other.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

public class MessagesGetByConversationMessageId extends GetMethod<GenericResult<VkList<Message>>> {
    private Integer peerId;
    private List<Integer> conversationMessageIds;
    private Boolean extended;
    private List<String> fields;
    private Integer groupId;

    public MessagesGetByConversationMessageId(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.Messages.GET_BY_CONVERSATION_MESSAGE_ID;
    }

    @Override
    protected JsonToPojoConverter<GenericResult<VkList<Message>>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<VkList<Message>>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
              keyVal("peer_id", peerId),
                keyVal("conversation_message_ids", conversationMessageIds),
                keyVal("extended", extended, true),
                keyVal("fields", fields),
                keyVal("group_id", groupId)
        );
    }

    public Integer getPeerId() {
        return peerId;
    }

    public MessagesGetByConversationMessageId setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public List<Integer> getConversationMessageIds() {
        return conversationMessageIds;
    }

    public MessagesGetByConversationMessageId setConversationMessageIds(List<Integer> conversationMessageIds) {
        this.conversationMessageIds = conversationMessageIds;
        return this;
    }

    public Boolean getExtended() {
        return extended;
    }

    public MessagesGetByConversationMessageId setExtended(Boolean extended) {
        this.extended = extended;
        return this;
    }

    public List<String> getFields() {
        return fields;
    }

    public MessagesGetByConversationMessageId setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesGetByConversationMessageId setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
