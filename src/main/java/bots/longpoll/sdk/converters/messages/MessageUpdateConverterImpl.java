package bots.longpoll.sdk.converters.messages;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.messages.Message;
import bots.longpoll.sdk.model.messages.MessageUpdate;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonObject;

public class MessageUpdateConverterImpl extends JsonToPojoConverter<MessageUpdate> {
	private static final String MESSAGE_FIELD = "message";
	private static final String CLIENT_INFO_FIELD = "client_info";

	@Override
	public MessageUpdate convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, MessageUpdate.class)
				.setMessage(new MessageConverterImpl().convert(jsonObject.getAsJsonObject(MESSAGE_FIELD)));
	}

	@Override
	protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
		return MessageUpdate.class.equals(fieldAttributes.getDeclaringClass())
				&& Message.class.equals(fieldAttributes.getDeclaredClass())
				&& MESSAGE_FIELD.equals(fieldAttributes.getName());
	}
}
