package api.longpoll.bots.converters.response.messages;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.response.messages.MessagesSendResult;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class MessagesSendResultConverterIpml extends JsonToPojoConverter<MessagesSendResult> {
	private static final String RESPONSE_FIELD = "response";

	@Override
	public MessagesSendResult convert(JsonObject jsonObject) {
		MessagesSendResult messagesSendResult = gson.fromJson(jsonObject, MessagesSendResult.class);
		JsonElement element = jsonObject.get(RESPONSE_FIELD);
		Object response = element.isJsonPrimitive()
				? element.getAsInt()
				: gson.fromJson(element, new TypeToken<List<MessagesSendResult.Response>>() {}.getType());
		messagesSendResult.setResponse(response);
		return messagesSendResult;
	}

	@Override
	protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
		return Object.class.equals(fieldAttributes.getDeclaredClass());
	}
}
