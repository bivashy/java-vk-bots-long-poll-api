package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetExecutor;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.groups.GroupsGetLongPollServerResponse;

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
		return GenericConverterFactory.get(GroupsGetLongPollServerResponse.class);
	}

	@Override
	protected String getApi() {
		return VkApi.Groups.GET_LONG_POLL_SERVER;
	}
}
