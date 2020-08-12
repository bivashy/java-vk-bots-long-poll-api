package bots.longpoll.sdk.converters.groups;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.groups.GroupsDeleteAddressResponse;
import com.google.gson.JsonObject;

public class GroupsDeleteAddressResponseConverterImpl extends JsonToPojoConverter<GroupsDeleteAddressResponse> {
	@Override
	public GroupsDeleteAddressResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, GroupsDeleteAddressResponse.class);
	}
}
