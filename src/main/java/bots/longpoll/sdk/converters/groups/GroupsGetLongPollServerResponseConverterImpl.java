package bots.longpoll.sdk.converters.groups;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.groups.GroupsGetLongPollServerResponse;
import com.google.gson.JsonObject;

public class GroupsGetLongPollServerResponseConverterImpl extends JsonToPojoConverter<GroupsGetLongPollServerResponse> {
	@Override
	public GroupsGetLongPollServerResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, GroupsGetLongPollServerResponse.class);
	}
}
