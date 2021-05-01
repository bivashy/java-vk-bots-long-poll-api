package api.longpoll.bots.methods.messages;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.IntegerResult;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>messages.markAsAnsweredConversation</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.markAsAnsweredConversation">https://vk.com/dev/messages.markAsAnsweredConversation</a>
 */
public class MessagesMarkAsAnsweredConversation extends VkApiGetMethod<IntegerResult> {
    /**
     * Peer Id.
     */
    private Integer peerId;

    /**
     * Answered.
     */
    private Boolean answered;

    /**
     * Group ID.
     */
    private Integer groupId;

    public MessagesMarkAsAnsweredConversation(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesMarkAsAnsweredConversation();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("peer_id", peerId),
                param("answered", answered, true),
                param("group_id", groupId)
        );
    }

    @Override
    protected Class<? extends IntegerResult> getResultType() {
        return IntegerResult.class;
    }

    public MessagesMarkAsAnsweredConversation setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public MessagesMarkAsAnsweredConversation setAnswered(Boolean answered) {
        this.answered = answered;
        return this;
    }

    public MessagesMarkAsAnsweredConversation setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
