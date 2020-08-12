package bots.longpoll.sdk.converters.photo;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.converters.attachments.AttachmentConverterImpl;
import bots.longpoll.sdk.model.attachment.Attachment;
import bots.longpoll.sdk.model.wall.reply.WallReply;
import bots.longpoll.sdk.model.photos.PhotoCommentUpdate;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class PhotoCommentUpdateConverterImpl extends JsonToPojoConverter<PhotoCommentUpdate> {
	private static final String ATTACHMENTS_FIELD = "attachments";
	private AttachmentConverterImpl attachmentConverter = new AttachmentConverterImpl();

	@Override
	public PhotoCommentUpdate convert(JsonObject jsonObject) {
		PhotoCommentUpdate photoCommentUpdate = gson.fromJson(jsonObject, PhotoCommentUpdate.class);

		if (jsonObject.has(ATTACHMENTS_FIELD)) {
			JsonArray jsonAttachments = jsonObject.getAsJsonArray(ATTACHMENTS_FIELD);
			List<Attachment> attachments = new ArrayList<>(jsonAttachments.size());
			jsonAttachments.forEach(jsonAttachment -> attachments.add(attachmentConverter.convert(jsonAttachment.getAsJsonObject())));
			photoCommentUpdate.setAttachments(attachments);
		}
		return photoCommentUpdate;
	}

	@Override
	protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
		return fieldAttributes.getDeclaringClass().isAssignableFrom(WallReply.class)
				&& List.class.equals(fieldAttributes.getDeclaredClass())
				&& ATTACHMENTS_FIELD.equals(fieldAttributes.getName());
	}
}
