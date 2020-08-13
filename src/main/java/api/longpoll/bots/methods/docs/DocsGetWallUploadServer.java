package api.longpoll.bots.methods.docs;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.docs.DocsGetUploadServerResult;

public class DocsGetWallUploadServer extends GetMethod<DocsGetUploadServerResult> {
	private static final String GROUP_ID = "group_id";

	public DocsGetWallUploadServer setGroupId(int groupId) {
		params.put(GROUP_ID, groupId);
		return this;
	}

	public int getGroupId() {
		return (int) params.get(GROUP_ID);
	}

	public DocsGetWallUploadServer(LongPollBot bot) {
		super(bot);
	}

	@Override
	protected String getApi() {
		return VkApi.Docs.GET_WALL_UPLOAD_SERVER;
	}

	@Override
	protected JsonToPojoConverter<DocsGetUploadServerResult> getConverter() {
		return GenericConverterFactory.get(DocsGetUploadServerResult.class);
	}
}
