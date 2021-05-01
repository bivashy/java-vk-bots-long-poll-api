package api.longpoll.bots.methods.messages;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.messages.MessagesGetConversationsResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>messages.searchConversations</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.searchConversations">https://vk.com/dev/messages.searchConversations</a>
 */
public class MessagesSearchConversations extends VkApiGetMethod<MessagesGetConversationsResult> {
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

    public MessagesSearchConversations(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesSearchConversations();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("q", q),
                param("count", count),
                param("extended", extended, true),
                param("fields", fields),
                param("group_id", groupId)
        );
    }

    @Override
    protected Class<? extends MessagesGetConversationsResult> getResultType() {
        return MessagesGetConversationsResult.class;
    }

    public MessagesSearchConversations setQ(String q) {
        this.q = q;
        return this;
    }

    public MessagesSearchConversations setCount(Integer count) {
        this.count = count;
        return this;
    }

    public MessagesSearchConversations setExtended(Boolean extended) {
        this.extended = extended;
        return this;
    }

    public MessagesSearchConversations setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public MessagesSearchConversations setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
