package bots.longpoll.sdk.converters.messages;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.messages.MessageUploadPhotoResponse;
import com.google.gson.JsonObject;

public class MessageUploadPhotoResponseConverterImpl extends JsonToPojoConverter<MessageUploadPhotoResponse> {
	@Override
	public MessageUploadPhotoResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, MessageUploadPhotoResponse.class);
	}
}
