package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsGetLongPollServerResult;

public class GroupsGetLongPollServer extends GetMethod<GroupsGetLongPollServerResult> {
	private static final String GROUP_ID_FIELD = "group_id";

	public GroupsGetLongPollServer(LongPollBot bot) {
		super(bot);
	}

	public GroupsGetLongPollServer setGroupId(int groupId) {
		params.put(GROUP_ID_FIELD, groupId);
		return this;
	}

	@Override
	protected JsonToPojoConverter<GroupsGetLongPollServerResult> getConverter() {
		return GenericConverterFactory.get(GroupsGetLongPollServerResult.class);
	}

	@Override
	protected String getApi() {
		return VkApi.Groups.GET_LONG_POLL_SERVER;
	}
}
