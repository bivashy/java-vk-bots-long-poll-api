package bots.longpoll.sdk.executors.groups;

import bots.longpoll.sdk.LongPollBot;
import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.converters.groups.GroupsGetLongPollServerResponseConverterImpl;
import bots.longpoll.sdk.executors.GetExecutor;
import bots.longpoll.sdk.executors.VkApi;
import bots.longpoll.sdk.model.groups.GroupsGetLongPollServerResponse;

public class GroupsGetLongPollServer extends GetExecutor<GroupsGetLongPollServerResponse> {
	private static final String GROUP_ID_FIELD = "group_id";

	public GroupsGetLongPollServer(LongPollBot bot) {
		super(bot);
	}

	public int getGroupId() {
		return (int) params.get(GROUP_ID_FIELD);
	}

	public GroupsGetLongPollServer setGroupId(int groupId) {
		params.put(GROUP_ID_FIELD, groupId);
		return this;
	}

	@Override
	protected JsonToPojoConverter<GroupsGetLongPollServerResponse> getConverter() {
		return new GroupsGetLongPollServerResponseConverterImpl();
	}

	@Override
	protected String getApi() {
		return VkApi.Groups.GET_LONG_POLL_SERVER;
	}
}
