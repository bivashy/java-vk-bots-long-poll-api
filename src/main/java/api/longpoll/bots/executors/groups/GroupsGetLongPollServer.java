package api.longpoll.bots.executors.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.groups.GroupsGetLongPollServerResponseConverterImpl;
import api.longpoll.bots.model.groups.GroupsGetLongPollServerResponse;
import api.longpoll.bots.executors.GetExecutor;
import api.longpoll.bots.executors.VkApi;

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
