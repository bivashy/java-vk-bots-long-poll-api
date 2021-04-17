package api.longpoll.bots.methods.messages;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.JsonToPojoConverterFactory;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.additional.Button;
import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Sends an event with an action that will occur when the callback button is clicked.
 *
 * @see <a href="https://vk.com/dev/messages.sendMessageEventAnswer">https://vk.com/dev/messages.sendMessageEventAnswer</a>
 */
public class MessagesSendEventAnswer extends GetMethod<GenericResult<Integer>> {
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
    protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
        return JsonToPojoConverterFactory.get(new TypeToken<GenericResult<Integer>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("event_id", eventId),
                keyVal("user_id", userId),
                keyVal("peer_id", peerId),
                keyVal("event_data", eventData)
        );
    }

    public String getEventId() {
        return eventId;
    }

    public MessagesSendEventAnswer setEventId(String eventId) {
        this.eventId = eventId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public MessagesSendEventAnswer setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getPeerId() {
        return peerId;
    }

    public MessagesSendEventAnswer setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public Button.EventData getEventData() {
        return eventData;
    }

    public MessagesSendEventAnswer setEventData(Button.EventData eventData) {
        this.eventData = eventData;
        return this;
    }
}
