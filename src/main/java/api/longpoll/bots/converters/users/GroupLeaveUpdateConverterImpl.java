package api.longpoll.bots.converters.users;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.users.GroupLeaveEvent;
import com.google.gson.JsonObject;

public class GroupLeaveUpdateConverterImpl extends JsonToPojoConverter<GroupLeaveEvent> {
	@Override
	public GroupLeaveEvent convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, GroupLeaveEvent.class);
	}
}
