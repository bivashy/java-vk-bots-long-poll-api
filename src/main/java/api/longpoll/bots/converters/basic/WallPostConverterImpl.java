package api.longpoll.bots.converters.basic;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.media.AttachmentConverterImpl;
import api.longpoll.bots.model.objects.media.Attachment;
import api.longpoll.bots.model.wall.post.WallPost;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class WallPostConverterImpl extends JsonToPojoConverter<WallPost> {
	private static final String ATTACHMENTS_FIELD = "attachments";
	private AttachmentConverterImpl attachmentConverter = new AttachmentConverterImpl();

	@Override
	public WallPost convert(JsonObject jsonObject) {
		WallPost wallPost = gson.fromJson(jsonObject, WallPost.class);

		if (jsonObject.has(ATTACHMENTS_FIELD)) {
			JsonArray jsonAttachments = jsonObject.getAsJsonArray(ATTACHMENTS_FIELD);
			List<Attachment> attachments = new ArrayList<>(jsonAttachments.size());
			jsonAttachments.forEach(jsonAttachment -> attachments.add(attachmentConverter.convert(jsonAttachment.getAsJsonObject())));
			wallPost.setAttachments(attachments);
		}

		return wallPost;
	}

	@Override
	protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
		return List.class.equals(fieldAttributes.getDeclaredClass())
				&& ATTACHMENTS_FIELD.equals(fieldAttributes.getName());
	}
}
