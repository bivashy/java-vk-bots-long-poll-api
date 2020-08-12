package api.longpoll.bots.converters.groups;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.groups.GroupsGetLongPollServerResponse;
import com.google.gson.JsonObject;

public class GroupsGetLongPollServerResponseConverterImpl extends JsonToPojoConverter<GroupsGetLongPollServerResponse> {
	@Override
	public GroupsGetLongPollServerResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, GroupsGetLongPollServerResponse.class);
	}
}
