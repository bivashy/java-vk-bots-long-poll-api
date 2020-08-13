package api.longpoll.bots.methods.groups;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.groups.GroupsAddCallbackServerResult;

public class GroupsAddCallbackServer extends GetMethod<GroupsAddCallbackServerResult> {
	private static final String GROUP_ID = "group_id";
	private static final String URL = "url";
	private static final String TITLE = "title";
	private static final String SECRET_KEY = "secret_key";

	public GroupsAddCallbackServer setGroupId(int groupId) {
		params.put(GROUP_ID, groupId);
		return this;
	}


	public GroupsAddCallbackServer setUrl(String url) {
		params.put(URL, url);
		return this;
	}


	public GroupsAddCallbackServer setTitle(String title) {
		params.put(TITLE, title);
		return this;
	}


	public GroupsAddCallbackServer setSecretKey(String secretKey) {
		params.put(SECRET_KEY, secretKey);
		return this;
	}

	public GroupsAddCallbackServer(LongPollBot bot) {
		super(bot);
	}

	@Override
	protected String getApi() {
		return VkApi.Groups.ADD_CALLBACK_SERVER;
	}

	@Override
	protected JsonToPojoConverter<GroupsAddCallbackServerResult> getConverter() {
		return GenericConverterFactory.get(GroupsAddCallbackServerResult.class);
	}
}
