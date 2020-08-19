package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.messages.MessagesGetConversationsByIdResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

public class MessagesGetConversationsById extends GetMethod<MessagesGetConversationsByIdResult> {
    private List<Integer> peerIds;
    private Boolean extended;
    private List<String> fields;
    private Integer groupId;

    public MessagesGetConversationsById(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.Messages.GET_CONVERSATIONS_BY_ID;
    }

    @Override
    protected JsonToPojoConverter<MessagesGetConversationsByIdResult> getConverter() {
        return GenericConverterFactory.get(MessagesGetConversationsByIdResult.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("peer_ids", peerIds),
                keyVal("extended", extended, true),
                keyVal("fields", fields),
                keyVal("group_id", groupId)
        );
    }

    public List<Integer> getPeerIds() {
        return peerIds;
    }

    public MessagesGetConversationsById setPeerIds(List<Integer> peerIds) {
        this.peerIds = peerIds;
        return this;
    }

    public Boolean getExtended() {
        return extended;
    }

    public MessagesGetConversationsById setExtended(Boolean extended) {
        this.extended = extended;
        return this;
    }

    public List<String> getFields() {
        return fields;
    }

    public MessagesGetConversationsById setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesGetConversationsById setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
