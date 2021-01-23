package api.longpoll.bots.converters.events.video;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.events.video.VideoCommentEvent;
import api.longpoll.bots.utils.converters.AttachmentConverterUtil;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonObject;

import java.util.List;

public class VideoCommentEventConverter extends JsonToPojoConverter<VideoCommentEvent> {
    @Override
    public VideoCommentEvent convert(JsonObject jsonObject) {
        VideoCommentEvent videoCommentEvent = gson.fromJson(jsonObject, VideoCommentEvent.class);
        videoCommentEvent.setAttachments(AttachmentConverterUtil.extractAttachments(jsonObject));
        return videoCommentEvent;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return List.class.equals(fieldAttributes.getDeclaredClass())
                && "attachments".equals(fieldAttributes.getName());
    }
}
