package api.longpoll.bots.converters.events.messages;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.basic.MessageConverter;
import api.longpoll.bots.model.events.messages.MessageNewEvent;
import api.longpoll.bots.model.objects.basic.Message;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonObject;

public class MessageNewEventConverter extends JsonToPojoConverter<MessageNewEvent> {
    private static final JsonToPojoConverter<Message> MESSAGE_CONVERTER = new MessageConverter();

    @Override
    public MessageNewEvent convert(JsonObject jsonObject) {
        MessageNewEvent messageNewEvent = gson.fromJson(jsonObject, MessageNewEvent.class);
        messageNewEvent.setMessage(MESSAGE_CONVERTER.convert(jsonObject.getAsJsonObject("message")));
        return messageNewEvent;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return MessageNewEvent.class.equals(fieldAttributes.getDeclaringClass())
                && Message.class.equals(fieldAttributes.getDeclaredClass())
                && "message".equals(fieldAttributes.getName());
    }
}
