package bots.longpoll.sdk.converters.other;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.other.AppPayload;
import com.google.gson.JsonObject;

public class AppPayloadConverterImpl extends JsonToPojoConverter<AppPayload> {
	@Override
	public AppPayload convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, AppPayload.class);
	}
}
