package bots.longpoll.sdk.converters.messages;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.messages.MessageUploadDocResponse;
import com.google.gson.JsonObject;

public class MessageUploadDocResponseConverterImpl extends JsonToPojoConverter<MessageUploadDocResponse> {
	@Override
	public MessageUploadDocResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, MessageUploadDocResponse.class);
	}
}
