package api.longpoll.bots.executors.docs;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.doc.DocsGetWallUploadServerResponseConverterImpl;
import api.longpoll.bots.model.document.DocsGetWallUploadServerResponse;
import api.longpoll.bots.executors.GetExecutor;
import api.longpoll.bots.executors.VkApi;

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
