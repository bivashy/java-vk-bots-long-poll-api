package bots.longpoll.sdk.converters.video;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.converters.attachments.AttachmentConverterImpl;
import bots.longpoll.sdk.model.attachment.Attachment;
import bots.longpoll.sdk.model.video.VideoCommentUpdate;
import bots.longpoll.sdk.model.wall.reply.WallReply;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class VideoCommentUpdateConverterImpl extends JsonToPojoConverter<VideoCommentUpdate> {
	private static final String ATTACHMENTS_FIELD = "attachments";
	private AttachmentConverterImpl attachmentConverter = new AttachmentConverterImpl();

	@Override
	public VideoCommentUpdate convert(JsonObject jsonObject) {
		VideoCommentUpdate videoCommentUpdate = gson.fromJson(jsonObject, VideoCommentUpdate.class);

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
