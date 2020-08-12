package api.longpoll.bots.converters.groups;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.groups.GroupsAddAddressResponse;
import com.google.gson.JsonObject;

public class GroupsAddAddressResponseConverterImpl extends JsonToPojoConverter<GroupsAddAddressResponse> {
	@Override
	public GroupsAddAddressResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, GroupsAddAddressResponse.class);
	}
}
