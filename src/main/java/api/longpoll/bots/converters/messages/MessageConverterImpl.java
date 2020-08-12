package api.longpoll.bots.converters.messages;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.attachments.AttachmentConverterImpl;
import api.longpoll.bots.model.attachment.Attachment;
import api.longpoll.bots.model.objects.basic.Message;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class MessageConverterImpl extends JsonToPojoConverter<Message> {
	private static final String ID_FIELD = "id";
	private static final String DATE_FIELD = "date";
	private static final String PEER_ID_FIELD = "peer_id";
	private static final String FROM_ID_FIELD = "from_id";
	private static final String TEXT_FIELD = "text";
	private static final String RANDOM_ID_FIELD = "random_id";
	private static final String ATTACHMENTS_FIELD = "attachments";
	private static final String IMPORTANT_FIELD = "important";
	private static final String GEO_FIELD = "geo";
	private static final String PAYLOAD_FIELD = "payload";
	private static final String FWD_MESSAGES_FIELD = "fwd_messages";
	private static final String ACTION_FIELD = "action";

	private AttachmentConverterImpl attachmentConverter = new AttachmentConverterImpl();

	@Override
	public Message convert(JsonObject jsonObject) {
		Message message = gson.fromJson(jsonObject, Message.class);

		JsonArray jsonAttachments = jsonObject.getAsJsonArray(ATTACHMENTS_FIELD);
		List<Attachment> attachments = new ArrayList<>(jsonAttachments.size());
		jsonAttachments.forEach(jsonAttachment -> attachments.add(attachmentConverter.convert(jsonAttachment.getAsJsonObject())));

		return message.setAttachments(attachments);
	}

	@Override
	protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
		return Message.class.equals(fieldAttributes.getDeclaringClass())
				&& List.class.equals(fieldAttributes.getDeclaredClass())
				&& ATTACHMENTS_FIELD.equals(fieldAttributes.getName());
	}
}
