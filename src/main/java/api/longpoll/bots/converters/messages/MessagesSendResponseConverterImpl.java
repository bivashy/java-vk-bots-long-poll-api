package api.longpoll.bots.converters.messages;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.messages.MessagesSendResponse;
import com.google.gson.JsonObject;

public class MessagesSendResponseConverterImpl extends JsonToPojoConverter<MessagesSendResponse> {
	@Override
	public MessagesSendResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, MessagesSendResponse.class);
	}
}
