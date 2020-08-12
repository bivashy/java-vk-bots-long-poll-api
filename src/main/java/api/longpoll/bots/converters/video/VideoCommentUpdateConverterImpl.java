package api.longpoll.bots.converters.video;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.attachments.AttachmentConverterImpl;
import api.longpoll.bots.model.video.VideoCommentEvent;
import api.longpoll.bots.model.wall.reply.WallReply;
import api.longpoll.bots.model.attachment.Attachment;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class VideoCommentUpdateConverterImpl extends JsonToPojoConverter<VideoCommentEvent> {
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
		return fieldAttributes.getDeclaringClass().isAssignableFrom(WallReply.class)
				&& List.class.equals(fieldAttributes.getDeclaredClass())
				&& ATTACHMENTS_FIELD.equals(fieldAttributes.getName());
	}
}
