package bots.longpoll.sdk.converters.users;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.users.UserBlockUpdate;
import com.google.gson.JsonObject;

public class UserBlockUpdateConverterImpl extends JsonToPojoConverter<UserBlockUpdate> {
	@Override
	public UserBlockUpdate convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, UserBlockUpdate.class);
	}
}
