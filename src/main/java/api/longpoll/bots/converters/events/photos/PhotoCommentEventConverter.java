package api.longpoll.bots.converters.events.photos;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.events.photos.PhotoCommentEvent;
import api.longpoll.bots.utils.converters.AttachmentConverterUtil;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonObject;

import java.util.List;

public class PhotoCommentEventConverter extends JsonToPojoConverter<PhotoCommentEvent> {
    @Override
    public PhotoCommentEvent convert(JsonObject jsonObject) {
        PhotoCommentEvent photoCommentUpdate = gson.fromJson(jsonObject, PhotoCommentEvent.class);
        photoCommentUpdate.setAttachments(AttachmentConverterUtil.extractAttachments(jsonObject));
        return photoCommentUpdate;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return List.class.equals(fieldAttributes.getDeclaredClass())
                && "attachments".equals(fieldAttributes.getName());
    }
}
