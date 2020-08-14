package api.longpoll.bots.converters.basic;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.media.AttachmentConverterImpl;
import api.longpoll.bots.model.objects.media.Attachment;
import api.longpoll.bots.model.objects.basic.Message;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class MessageConverterImpl extends JsonToPojoConverter<Message> {
	private static final String ATTACHMENTS_FIELD = "attachments";
	private AttachmentConverterImpl attachmentConverter = new AttachmentConverterImpl();

	@Override
	public Message convert(JsonObject jsonObject) {
		Message message = gson.fromJson(jsonObject, Message.class);

		if (jsonObject.has(ATTACHMENTS_FIELD)) {
			JsonArray jsonAttachments = jsonObject.getAsJsonArray(ATTACHMENTS_FIELD);
			List<Attachment> attachments = new ArrayList<>(jsonAttachments.size());
			jsonAttachments.forEach(jsonAttachment -> attachments.add(attachmentConverter.convert(jsonAttachment.getAsJsonObject())));
			message.setAttachments(attachments);
		}

		return message;
	}

	@Override
	protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
		return Message.class.equals(fieldAttributes.getDeclaringClass())
				&& List.class.equals(fieldAttributes.getDeclaredClass())
				&& ATTACHMENTS_FIELD.equals(fieldAttributes.getName());
	}
}
