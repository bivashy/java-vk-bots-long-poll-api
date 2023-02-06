package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.additional.PinnedMessage;
import api.longpoll.bots.model.response.GenericResponseBody;

/**
 * Implements <b>messages.pin</b> method.
 * <p>
 * Pin the message
 *
 * @see <a href="https://vk.com/dev/messages.pin">https://vk.com/dev/messages.pin</a>
 */
public class Pin extends VkMethod<Pin.ResponseBody> {
    public Pin(String accessToken) {
        super(property("messages.pin"), accessToken);
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    public Pin setPeerId(int peerId) {
        return addParam("peer_id", peerId);
    }

    public Pin setConversationMessageId(int conversationMessageId) {
        return addParam("conversation_message_id", conversationMessageId);
    }

    @Override
    public Pin addParam(String key, Object value) {
        return (Pin) super.addParam(key, value);
    }

    /**
     * Response to <b>messages.pin</b> request.
     */
    public static class ResponseBody extends GenericResponseBody<PinnedMessage> {
    }
}
