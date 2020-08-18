package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.messages.MessagesGetConversationMembersResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

public class MessagesGetConversationMembers extends GetMethod<MessagesGetConversationMembersResult> {
    private Integer peerId;
    private List<String> fields;
    private Integer groupId;

    public MessagesGetConversationMembers(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.Messages.GET_CONVERSATION_MEMBERS;
    }

    @Override
    protected JsonToPojoConverter<MessagesGetConversationMembersResult> getConverter() {
        return GenericConverterFactory.get(MessagesGetConversationMembersResult.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("peer_id", peerId),
                keyVal("fields", fields),
                keyVal("group_id", groupId)
        );
    }

    public Integer getPeerId() {
        return peerId;
    }

    public MessagesGetConversationMembers setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public List<String> getFields() {
        return fields;
    }

    public MessagesGetConversationMembers setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesGetConversationMembers setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
