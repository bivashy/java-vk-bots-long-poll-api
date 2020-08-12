package bots.longpoll.sdk.converters.other;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.other.Change;
import com.google.gson.JsonObject;

public class ChangeConverterImpl extends JsonToPojoConverter<Change> {
	@Override
	public Change convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, Change.class);
	}
}
