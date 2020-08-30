package api.longpoll.bots.converters.events.video;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.media.AttachmentConverterImpl;
import api.longpoll.bots.model.objects.media.Attachment;
import api.longpoll.bots.model.events.video.VideoCommentEvent;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class VideoCommentEventConverterImpl extends JsonToPojoConverter<VideoCommentEvent> {
    private static final String ATTACHMENTS_FIELD = "attachments";
    private AttachmentConverterImpl attachmentConverter = new AttachmentConverterImpl();

    @Override
    public VideoCommentEvent convert(JsonObject jsonObject) {
        VideoCommentEvent videoCommentUpdate = gson.fromJson(jsonObject, VideoCommentEvent.class);

        if (jsonObject.has(ATTACHMENTS_FIELD)) {
            JsonArray jsonAttachments = jsonObject.getAsJsonArray(ATTACHMENTS_FIELD);
            List<Attachment> attachments = new ArrayList<>(jsonAttachments.size());
            jsonAttachments.forEach(jsonAttachment -> attachments.add(attachmentConverter.convert(jsonAttachment.getAsJsonObject())));
            videoCommentUpdate.setAttachments(attachments);
        }
        return videoCommentUpdate;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return List.class.equals(fieldAttributes.getDeclaredClass())
                && ATTACHMENTS_FIELD.equals(fieldAttributes.getName());
    }
}
