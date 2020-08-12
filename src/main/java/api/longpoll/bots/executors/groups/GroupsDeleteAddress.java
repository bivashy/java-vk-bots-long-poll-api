package api.longpoll.bots.executors.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.groups.GroupsDeleteAddressResponse;
import api.longpoll.bots.converters.groups.GroupsDeleteAddressResponseConverterImpl;
import api.longpoll.bots.executors.GetExecutor;
import api.longpoll.bots.executors.VkApi;

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
