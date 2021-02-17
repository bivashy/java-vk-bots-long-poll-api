package api.longpoll.bots.converters.basic;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.utils.converters.AttachmentConverterUtil;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonObject;

import java.util.List;

public class MessageConverter extends JsonToPojoConverter<Message> {
    @Override
    public Message convert(JsonObject jsonObject) {
        Message message = gson.fromJson(jsonObject, Message.class);
        message.setAttachments(AttachmentConverterUtil.extractAttachments(jsonObject));
        return message;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return Message.class.equals(fieldAttributes.getDeclaringClass())
                && List.class.equals(fieldAttributes.getDeclaredClass())
                && "attachments".equals(fieldAttributes.getName());
    }
}
