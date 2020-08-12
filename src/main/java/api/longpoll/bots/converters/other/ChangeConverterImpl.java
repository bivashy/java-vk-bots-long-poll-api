package api.longpoll.bots.converters.other;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.other.Change;
import com.google.gson.JsonObject;

public class ChangeConverterImpl extends JsonToPojoConverter<Change> {
	@Override
	public Change convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, Change.class);
	}
}
