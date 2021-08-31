package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.objects.additional.buttons.actions.EventData;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Sends an event with an action that will occur when the callback button is clicked.
 *
 * @see <a href="https://vk.com/dev/messages.sendMessageEventAnswer">https://vk.com/dev/messages.sendMessageEventAnswer</a>
 */
public class SendEventAnswer extends AuthorizedVkApiMethod<IntegerResponse> {
    public SendEventAnswer(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.sendMessageEventAnswer");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public SendEventAnswer setEventId(String eventId) {
        addParam("event_id", eventId);
        return this;
    }

    public SendEventAnswer setUserId(int userId) {
        addParam("user_id", userId);
        return this;
    }

    public SendEventAnswer setPeerId(int peerId) {
        addParam("peer_id", peerId);
        return this;
    }

    public SendEventAnswer setEventData(EventData eventData) {
        addParam("event_data", eventData);
        return this;
    }
}
