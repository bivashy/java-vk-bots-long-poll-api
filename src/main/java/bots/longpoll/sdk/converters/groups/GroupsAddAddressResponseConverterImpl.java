package bots.longpoll.sdk.converters.groups;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.groups.GroupsAddAddressResponse;
import com.google.gson.JsonObject;

public class GroupsAddAddressResponseConverterImpl extends JsonToPojoConverter<GroupsAddAddressResponse> {
	@Override
	public GroupsAddAddressResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, GroupsAddAddressResponse.class);
	}
}
