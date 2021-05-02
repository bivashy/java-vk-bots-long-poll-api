package api.longpoll.bots.methods.messages;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.messages.MessagesGetByIdResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>messages.getByConversationMessageId</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.getByConversationMessageId">https://vk.com/dev/messages.getByConversationMessageId</a>
 */
public class MessagesGetByConversationMessageId extends VkApiGetMethod<MessagesGetByIdResult> {
    /**
     * Peer Id.
     */
    private Integer peerId;

    /**
     * Conversation Message IDs.
     */
    private List<Integer> conversationMessageIds;

    /**
     * Extended.
     */
    private Boolean extended;

    /**
     * Additional fields.
     */
    private List<String> fields;

    /**
     * Community ID.
     */
    private Integer groupId;

    public MessagesGetByConversationMessageId(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesGetByConversationMessageId();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("peer_id", peerId),
                param("conversation_message_ids", conversationMessageIds),
                param("extended", extended, true),
                param("fields", fields),
                param("group_id", groupId)
        );
    }

    @Override
    protected Class<? extends MessagesGetByIdResult> getResultType() {
        return MessagesGetByIdResult.class;
    }

    public MessagesGetByConversationMessageId setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public MessagesGetByConversationMessageId setConversationMessageIds(List<Integer> conversationMessageIds) {
        this.conversationMessageIds = conversationMessageIds;
        return this;
    }

    public MessagesGetByConversationMessageId setExtended(Boolean extended) {
        this.extended = extended;
        return this;
    }

    public MessagesGetByConversationMessageId setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public MessagesGetByConversationMessageId setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
