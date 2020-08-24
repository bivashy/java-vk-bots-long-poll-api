package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsGetLongPollServerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class GroupsGetLongPollServer extends GetMethod<GroupsGetLongPollServerResult> {
	private Integer groupId;

	public GroupsGetLongPollServer(LongPollBot bot) {
		super(bot);
	}

	@Override
	protected JsonToPojoConverter<GroupsGetLongPollServerResult> getConverter() {
		return GenericConverterFactory.get(GroupsGetLongPollServerResult.class);
	}

	@Override
	protected Stream<Connection.KeyVal> getKeyValStream() {
		return Stream.of(keyVal("group_id", groupId));
	}

	@Override
	protected String getApi() {
		return VkApi.getInstance().groupsGetLongPollServer();
	}

	public Integer getGroupId() {
		return groupId;
	}

	public GroupsGetLongPollServer setGroupId(Integer groupId) {
		this.groupId = groupId;
		return this;
	}
}
