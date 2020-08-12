package api.longpoll.bots.converters.users;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.users.UserUnblockEvent;
import com.google.gson.JsonObject;

public class UserUnblockUpdateConverterImpl extends JsonToPojoConverter<UserUnblockEvent> {
	@Override
	public UserUnblockEvent convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, UserUnblockEvent.class);
	}
}
