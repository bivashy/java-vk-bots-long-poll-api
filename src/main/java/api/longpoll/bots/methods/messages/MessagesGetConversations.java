package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.messages.MessagesGetConversationsResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

public class MessagesGetConversations extends GetMethod<MessagesGetConversationsResult> {
    private Integer offset;
    private Integer count;
    private String filter;
    private Boolean extended;
    private Integer startMessageId;
    private List<String> fields;
    private Integer groupId;

    public MessagesGetConversations(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.Messages.GET_CONVERSATIONS;
    }

    @Override
    protected JsonToPojoConverter<MessagesGetConversationsResult> getConverter() {
        return GenericConverterFactory.get(MessagesGetConversationsResult.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("offset", offset),
                keyVal("count", count),
                keyVal("filter", filter),
                keyVal("extended", extended, true),
                keyVal("start_message_id", startMessageId),
                keyVal("fields", fields),
                keyVal("group_id", groupId)
        );
    }

    public Integer getOffset() {
        return offset;
    }

    public MessagesGetConversations setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public MessagesGetConversations setCount(Integer count) {
        this.count = count;
        return this;
    }

    public String getFilter() {
        return filter;
    }

    public MessagesGetConversations setFilter(String filter) {
        this.filter = filter;
        return this;
    }

    public Boolean getExtended() {
        return extended;
    }

    public MessagesGetConversations setExtended(Boolean extended) {
        this.extended = extended;
        return this;
    }

    public Integer getStartMessageId() {
        return startMessageId;
    }

    public MessagesGetConversations setStartMessageId(Integer startMessageId) {
        this.startMessageId = startMessageId;
        return this;
    }

    public List<String> getFields() {
        return fields;
    }

    public MessagesGetConversations setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesGetConversations setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
