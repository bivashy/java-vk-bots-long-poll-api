package bots.longpoll.sdk.converters.messages;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.messages.MessagesSendResponse;
import com.google.gson.JsonObject;

public class MessagesSendResponseConverterImpl extends JsonToPojoConverter<MessagesSendResponse> {
	@Override
	public MessagesSendResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, MessagesSendResponse.class);
	}
}
