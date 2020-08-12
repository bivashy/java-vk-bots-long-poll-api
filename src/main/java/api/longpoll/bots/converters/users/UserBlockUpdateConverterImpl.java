package api.longpoll.bots.converters.users;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.users.UserBlockEvent;
import com.google.gson.JsonObject;

public class UserBlockUpdateConverterImpl extends JsonToPojoConverter<UserBlockEvent> {
	@Override
	public UserBlockEvent convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, UserBlockEvent.class);
	}
}
