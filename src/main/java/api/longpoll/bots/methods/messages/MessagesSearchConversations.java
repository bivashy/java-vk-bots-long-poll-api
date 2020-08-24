package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.messages.MessagesSearchConversationsResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

public class MessagesSearchConversations extends GetMethod<MessagesSearchConversationsResult> {
    private String q;
    private Integer count;
    private Boolean extended;
    private List<String> fields;
    private Integer groupId;

    public MessagesSearchConversations(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesSearchConversations();
    }

    @Override
    protected JsonToPojoConverter<MessagesSearchConversationsResult> getConverter() {
        return GenericConverterFactory.get(MessagesSearchConversationsResult.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("q", q),
                keyVal("count", count),
                keyVal("extended", extended, true),
                keyVal("fields", fields),
                keyVal("group_id", groupId)
        );
    }

    public String getQ() {
        return q;
    }

    public MessagesSearchConversations setQ(String q) {
        this.q = q;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public MessagesSearchConversations setCount(Integer count) {
        this.count = count;
        return this;
    }

    public Boolean getExtended() {
        return extended;
    }

    public MessagesSearchConversations setExtended(Boolean extended) {
        this.extended = extended;
        return this;
    }

    public List<String> getFields() {
        return fields;
    }

    public MessagesSearchConversations setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesSearchConversations setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
