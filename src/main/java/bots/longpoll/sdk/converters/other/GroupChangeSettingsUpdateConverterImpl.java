package bots.longpoll.sdk.converters.other;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.other.GroupChangeSettingsUpdate;
import com.google.gson.JsonObject;

public class GroupChangeSettingsUpdateConverterImpl extends JsonToPojoConverter<GroupChangeSettingsUpdate> {
	@Override
	public GroupChangeSettingsUpdate convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, GroupChangeSettingsUpdate.class);
	}
}
