package api.longpoll.bots.methods.messages;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.messages.MessagesGetConversationsResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>messages.getConversationsById</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.getConversationsById">https://vk.com/dev/messages.getConversationsById</a>
 */
public class MessagesGetConversationsById extends VkApiGetMethod<MessagesGetConversationsResult> {
    /**
     * List of destination IDs.
     */
    private List<Integer> peerIds;

    /**
     * <b>true</b> – return additional information about users and communities in users and communities fields.
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

    public MessagesGetConversationsById(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesGetConversationsById();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("peer_ids", peerIds),
                param("extended", extended, true),
                param("fields", fields),
                param("group_id", groupId)
        );
    }

    @Override
    protected Class<? extends MessagesGetConversationsResult> getResultType() {
        return MessagesGetConversationsResult.class;
    }

    public MessagesGetConversationsById setPeerIds(List<Integer> peerIds) {
        this.peerIds = peerIds;
        return this;
    }

    public MessagesGetConversationsById setExtended(Boolean extended) {
        this.extended = extended;
        return this;
    }

    public MessagesGetConversationsById setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public MessagesGetConversationsById setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
