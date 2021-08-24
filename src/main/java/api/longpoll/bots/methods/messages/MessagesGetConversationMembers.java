package api.longpoll.bots.methods.messages;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.messages.MessagesGetConversationMembersResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>messages.getConversationMembers</b> method.
 *
 * Returns a list of IDs of users participating in a conversation.
 *
 * @see <a href="https://vk.com/dev/messages.getConversationMembers">https://vk.com/dev/messages.getConversationMembers</a>
 */
public class MessagesGetConversationMembers extends VkApiGetMethod<MessagesGetConversationMembersResult> {
    /**
     * Destination ID.
     */
    private Integer peerId;

    /**
     * List of additional fields for users and communities.
     */
    private List<String> fields;

    /**
     * Group ID.
     */
    private Integer groupId;

    public MessagesGetConversationMembers(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApiProperties.get("messages.getConversationMembers");
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(
                keyVal("peer_id", peerId),
                keyVal("fields", fields),
                keyVal("group_id", groupId)
        );
    }

    @Override
    protected Class<? extends MessagesGetConversationMembersResult> getResultType() {
        return MessagesGetConversationMembersResult.class;
    }

    public MessagesGetConversationMembers setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public MessagesGetConversationMembers setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public MessagesGetConversationMembers setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
