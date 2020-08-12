package bots.longpoll.sdk.converters.users;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.users.GroupLeaveUpdate;
import com.google.gson.JsonObject;

public class GroupLeaveUpdateConverterImpl extends JsonToPojoConverter<GroupLeaveUpdate> {
	@Override
	public GroupLeaveUpdate convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, GroupLeaveUpdate.class);
	}
}
