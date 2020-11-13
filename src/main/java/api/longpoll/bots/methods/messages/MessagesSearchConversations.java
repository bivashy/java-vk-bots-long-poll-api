package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.basic.Conversation;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.ExtendedVkList;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>messages.searchConversations</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.searchConversations">https://vk.com/dev/messages.searchConversations</a>
 */
public class MessagesSearchConversations extends GetMethod<GenericResult<ExtendedVkList<Conversation>>> {
    /**
     * Search query string.
     */
    private String q;

    /**
     * Maximum number of results.
     */
    private Integer count;

    /**
     * <b>true</b> – return additional fields.
     */
    private Boolean extended;

    /**
     * List of additional fields for users and communities.
     */
    private List<String> fields;

    /**
     * Group ID.
     */
    private Integer groupId;

    public MessagesSearchConversations(LongPollBot bot) {
        super(bot);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesSearchConversations();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected JsonToPojoConverter<GenericResult<ExtendedVkList<Conversation>>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<ExtendedVkList<Conversation>>>(){}.getType());
    }

    /**
     * {@inheritDoc}
     */
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
