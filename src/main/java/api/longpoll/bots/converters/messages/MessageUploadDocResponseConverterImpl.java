package api.longpoll.bots.converters.messages;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.messages.MessageUploadDocResponse;
import com.google.gson.JsonObject;

public class MessageUploadDocResponseConverterImpl extends JsonToPojoConverter<MessageUploadDocResponse> {
	@Override
	public MessageUploadDocResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, MessageUploadDocResponse.class);
	}
}
