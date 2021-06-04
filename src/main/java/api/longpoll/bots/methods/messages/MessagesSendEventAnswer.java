package api.longpoll.bots.methods.messages;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.additional.Button;
import api.longpoll.bots.model.response.IntegerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Sends an event with an action that will occur when the callback button is clicked.
 *
 * @see <a href="https://vk.com/dev/messages.sendMessageEventAnswer">https://vk.com/dev/messages.sendMessageEventAnswer</a>
 */
public class MessagesSendEventAnswer extends VkApiGetMethod<IntegerResult> {
    /**
     * A random string that is returned in the <b>message_event</b> event.
     */
    private String eventId;

    /**
     * User ID.
     */
    private Integer userId;

    /**
     * Dialog ID.
     */
    private Integer peerId;

    /**
     * An object of the action that should occur after clicking the button.
     */
    private Button.EventData eventData;

    public MessagesSendEventAnswer(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesSendMessageEventAnswer();
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(
                keyVal("event_id", eventId),
                keyVal("user_id", userId),
                keyVal("peer_id", peerId),
                keyVal("event_data", eventData)
        );
    }

    @Override
    protected Class<? extends IntegerResult> getResultType() {
        return IntegerResult.class;
    }

    public MessagesSendEventAnswer setEventId(String eventId) {
        this.eventId = eventId;
        return this;
    }

    public MessagesSendEventAnswer setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public MessagesSendEventAnswer setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public MessagesSendEventAnswer setEventData(Button.EventData eventData) {
        this.eventData = eventData;
        return this;
    }
}
