package api.longpoll.bots.methods.messages;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.JsonToPojoConverterFactory;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.additional.PinnedMessage;
import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>messages.pin</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.pin">https://vk.com/dev/messages.pin</a>
 */
public class MessagesPin extends GetMethod<GenericResult<PinnedMessage>> {
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
    protected JsonToPojoConverter<GenericResult<PinnedMessage>> getConverter() {
        return JsonToPojoConverterFactory.get(new TypeToken<GenericResult<PinnedMessage>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("peer_id", peerId),
                keyVal("conversation_message_id", conversationMessageId)
        );
    }

    public Integer getPeerId() {
        return peerId;
    }

    public MessagesPin setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public Integer getConversationMessageId() {
        return conversationMessageId;
    }

    public MessagesPin setConversationMessageId(Integer conversationMessageId) {
        this.conversationMessageId = conversationMessageId;
        return this;
    }
}
