package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.groups.GroupsDeleteAddressResponse;

public class GroupsDeleteAddress extends GetMethod<GroupsDeleteAddressResponse> {
	private static final String GROUP_ID = "group_id";
	private static final String ADDRESS_ID = "address_id";

	public GroupsDeleteAddress setGroupId(int groupId) {
		params.put(GROUP_ID, groupId);
		return this;
	}

	public int getGroupId() {
		return (int) params.get(GROUP_ID);
	}

	public GroupsDeleteAddress setAddressId(int addressid) {
		params.put(ADDRESS_ID, addressid);
		return this;
	}

	public int getAddressId() {
		return (int) params.get(ADDRESS_ID);
	}

	public GroupsDeleteAddress(LongPollBot bot) {
		super(bot);
	}

	@Override
	protected String getApi() {
		return VkApi.Groups.DELETE_ADDRESS;
	}

	@Override
	protected JsonToPojoConverter<GroupsDeleteAddressResponse> getConverter() {
		return GenericConverterFactory.get(GroupsDeleteAddressResponse.class);
	}
}
