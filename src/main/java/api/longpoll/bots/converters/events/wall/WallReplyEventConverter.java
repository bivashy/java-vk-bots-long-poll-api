package api.longpoll.bots.converters.events.wall;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.events.wall.comments.WallReplyEvent;
import api.longpoll.bots.utils.converters.AttachmentConverterUtil;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonObject;

import java.util.List;

public class WallReplyEventConverter extends JsonToPojoConverter<WallReplyEvent> {
    @Override
    public WallReplyEvent convert(JsonObject jsonObject) {
        WallReplyEvent wallReplyEvent = gson.fromJson(jsonObject, WallReplyEvent.class);
        wallReplyEvent.setAttachments(AttachmentConverterUtil.extractAttachments(jsonObject));
        return wallReplyEvent;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return List.class.equals(fieldAttributes.getDeclaredClass())
                && "attachments".equals(fieldAttributes.getName());
    }
}
