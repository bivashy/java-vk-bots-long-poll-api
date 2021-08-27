package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.objects.additional.PinnedMessage;
import api.longpoll.bots.model.response.GenericResponse;

/**
 * Implements <b>messages.pin</b> method.
 * <p>
 * Pin the message
 *
 * @see <a href="https://vk.com/dev/messages.pin">https://vk.com/dev/messages.pin</a>
 */
public class Pin extends AuthorizedVkApiMethod<Pin.Response> {
    public Pin(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.pin");
    }

    @Override
    protected Class<Response> getResultType() {
        return Response.class;
    }

    public Pin setPeerId(int peerId) {
        addParam("peer_id", peerId);
        return this;
    }

    public Pin setConversationMessageId(int conversationMessageId) {
        addParam("conversation_message_id", conversationMessageId);
        return this;
    }

    /**
     * Response to <b>messages.pin</b> request.
     */
    public static class Response extends GenericResponse<PinnedMessage> {
    }
}
