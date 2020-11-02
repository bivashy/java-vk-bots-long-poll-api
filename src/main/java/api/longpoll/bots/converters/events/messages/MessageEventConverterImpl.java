package api.longpoll.bots.converters.events.messages;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.basic.MessageConverterImpl;
import api.longpoll.bots.model.events.messages.MessageNewEvent;
import api.longpoll.bots.model.objects.basic.Message;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonObject;

public class MessageEventConverterImpl extends JsonToPojoConverter<MessageNewEvent> {
    private static final String MESSAGE_FIELD = "message";

    @Override
    public MessageNewEvent convert(JsonObject jsonObject) {
        MessageNewEvent messageNewEvent = gson.fromJson(jsonObject, MessageNewEvent.class);
        messageNewEvent.setMessage(new MessageConverterImpl().convert(jsonObject.getAsJsonObject(MESSAGE_FIELD)));
        return messageNewEvent;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return MessageNewEvent.class.equals(fieldAttributes.getDeclaringClass())
                && Message.class.equals(fieldAttributes.getDeclaredClass())
                && MESSAGE_FIELD.equals(fieldAttributes.getName());
    }
}
