package api.longpoll.bots.converters.groups;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.groups.GroupsDeleteAddressResponse;
import com.google.gson.JsonObject;

public class GroupsDeleteAddressResponseConverterImpl extends JsonToPojoConverter<GroupsDeleteAddressResponse> {
	@Override
	public GroupsDeleteAddressResponse convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, GroupsDeleteAddressResponse.class);
	}
}
