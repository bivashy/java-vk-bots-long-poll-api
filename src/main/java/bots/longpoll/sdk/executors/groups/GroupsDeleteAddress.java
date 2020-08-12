package bots.longpoll.sdk.executors.groups;

import bots.longpoll.sdk.LongPollBot;
import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.converters.groups.GroupsDeleteAddressResponseConverterImpl;
import bots.longpoll.sdk.executors.GetExecutor;
import bots.longpoll.sdk.executors.VkApi;
import bots.longpoll.sdk.model.groups.GroupsDeleteAddressResponse;

public class GroupsDeleteAddress extends GetExecutor<GroupsDeleteAddressResponse> {
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
		return new GroupsDeleteAddressResponseConverterImpl();
	}
}
