package api.longpoll.bots.converters.messages;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.messages.MessageUploadPhotoResponse;
import com.google.gson.JsonObject;

public class MessageUploadPhotoResponseConverterImpl extends JsonToPojoConverter<MessageUploadPhotoResponse> {
	@Override
	public MessageUploadPhotoResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, MessageUploadPhotoResponse.class);
	}
}
