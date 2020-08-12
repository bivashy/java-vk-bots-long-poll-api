package bots.longpoll.sdk.executors.docs;

import bots.longpoll.sdk.LongPollBot;
import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.converters.doc.DocsGetWallUploadServerResponseConverterImpl;
import bots.longpoll.sdk.executors.GetExecutor;
import bots.longpoll.sdk.executors.VkApi;
import bots.longpoll.sdk.model.document.DocsGetWallUploadServerResponse;

public class DocsGetWallUploadServer extends GetExecutor<DocsGetWallUploadServerResponse> {
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
	protected JsonToPojoConverter<DocsGetWallUploadServerResponse> getConverter() {
		return new DocsGetWallUploadServerResponseConverterImpl();
	}
}
