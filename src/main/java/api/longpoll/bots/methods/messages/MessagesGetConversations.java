package api.longpoll.bots.methods.messages;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.messages.MessagesGetConversationsResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>messages.getConversations</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.getConversations">https://vk.com/dev/messages.getConversations</a>
 */
public class MessagesGetConversations extends VkApiGetMethod<MessagesGetConversationsResult> {
    /**
     * Offset needed to return a specific subset of conversations.
     */
    private Integer offset;

    /**
     * Number of conversations to return.
     */
    private Integer count;

    /**
     * Types of conversations to return.
     */
    private String filter;

    /**
     * Return additional fields for users and communities.
     */
    private Boolean extended;

    /**
     * ID of the message from what to return conversations.
     */
    private Integer startMessageId;

    /**
     * List of additional fields for users and communities.
     */
    private List<String> fields;

    /**
     * Group ID.
     */
    private Integer groupId;

    public MessagesGetConversations(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesGetConversations();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("offset", offset),
                param("count", count),
                param("filter", filter),
                param("extended", extended, true),
                param("start_message_id", startMessageId),
                param("fields", fields),
                param("group_id", groupId)
        );
    }

    @Override
    protected Class<? extends MessagesGetConversationsResult> getResultType() {
        return MessagesGetConversationsResult.class;
    }

    public MessagesGetConversations setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public MessagesGetConversations setCount(Integer count) {
        this.count = count;
        return this;
    }

    public MessagesGetConversations setFilter(String filter) {
        this.filter = filter;
        return this;
    }

    public MessagesGetConversations setExtended(Boolean extended) {
        this.extended = extended;
        return this;
    }

    public MessagesGetConversations setStartMessageId(Integer startMessageId) {
        this.startMessageId = startMessageId;
        return this;
    }

    public MessagesGetConversations setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public MessagesGetConversations setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
