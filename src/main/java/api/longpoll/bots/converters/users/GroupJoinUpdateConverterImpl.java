package api.longpoll.bots.converters.users;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.users.GroupJoinEvent;
import com.google.gson.JsonObject;

public class GroupJoinUpdateConverterImpl extends JsonToPojoConverter<GroupJoinEvent> {
	@Override
	public GroupJoinEvent convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, GroupJoinEvent.class);
	}
}
