package api.longpoll.bots.methods.messages;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.messages.MessagesDeleteConversationResult;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>messages.deleteConversation</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.deleteConversation">https://vk.com/dev/messages.deleteConversation</a>
 */
public class MessagesDeleteConversation extends VkApiGetMethod<MessagesDeleteConversationResult> {
    /**
     * User ID.
     */
    private String userId;

    /**
     * Destination ID.
     */
    private Integer peerId;

    /**
     * Community ID.
     */
    private Integer groupId;

    public MessagesDeleteConversation(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesDeleteConversation();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("user_id", userId),
                param("peer_id", peerId),
                param("group_id", groupId)
        );
    }

    @Override
    protected Class<? extends MessagesDeleteConversationResult> getResultType() {
        return MessagesDeleteConversationResult.class;
    }

    public MessagesDeleteConversation setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public MessagesDeleteConversation setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public MessagesDeleteConversation setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
