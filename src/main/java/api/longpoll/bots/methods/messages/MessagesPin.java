package api.longpoll.bots.methods.messages;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.messages.MessagesPinResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>messages.pin</b> method.
 *
 * Pin the message
 *
 * @see <a href="https://vk.com/dev/messages.pin">https://vk.com/dev/messages.pin</a>
 */
public class MessagesPin extends VkApiGetMethod<MessagesPinResult> {
    /**
     * Peer ID.
     */
    private Integer peerId;

    /**
     * Id of the group chat message that needs to be pinned.
     */
    private Integer conversationMessageId;

    public MessagesPin(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesPin();
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("peer_id", peerId),
                keyVal("conversation_message_id", conversationMessageId)
        );
    }

    @Override
    protected Class<? extends MessagesPinResult> getResultType() {
        return MessagesPinResult.class;
    }

    public MessagesPin setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public MessagesPin setConversationMessageId(Integer conversationMessageId) {
        this.conversationMessageId = conversationMessageId;
        return this;
    }
}
