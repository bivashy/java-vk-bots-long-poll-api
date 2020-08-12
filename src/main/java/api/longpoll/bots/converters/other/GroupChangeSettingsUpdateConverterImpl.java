package api.longpoll.bots.converters.other;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.other.GroupChangeSettingsEvent;
import com.google.gson.JsonObject;

public class GroupChangeSettingsUpdateConverterImpl extends JsonToPojoConverter<GroupChangeSettingsEvent> {
	@Override
	public GroupChangeSettingsEvent convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, GroupChangeSettingsEvent.class);
	}
}
