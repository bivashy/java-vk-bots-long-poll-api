package bots.longpoll.sdk.converters.users;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.users.UserUnblockUpdate;
import com.google.gson.JsonObject;

public class UserUnblockUpdateConverterImpl extends JsonToPojoConverter<UserUnblockUpdate> {
	@Override
	public UserUnblockUpdate convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, UserUnblockUpdate.class);
	}
}
