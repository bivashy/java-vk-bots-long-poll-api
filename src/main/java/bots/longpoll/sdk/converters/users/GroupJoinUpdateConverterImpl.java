package bots.longpoll.sdk.converters.users;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.users.GroupJoinUpdate;
import com.google.gson.JsonObject;

public class GroupJoinUpdateConverterImpl extends JsonToPojoConverter<GroupJoinUpdate> {
	@Override
	public GroupJoinUpdate convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, GroupJoinUpdate.class);
	}
}
