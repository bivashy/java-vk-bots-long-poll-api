package api.longpoll.bots.methods.docs;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.docs.DocsGetUploadServerResult;

public class DocsGetMessagesUploadServer extends GetMethod<DocsGetUploadServerResult> {
	private static final String TYPE = "type";
	private static final String PEER_ID = "peer_id";

	public DocsGetMessagesUploadServer setType(String type) {
		params.put(TYPE, type);
		return this;
	}

	public DocsGetMessagesUploadServer setPeerId(int peerId) {
		params.put(PEER_ID, peerId);
		return this;
	}

	public DocsGetMessagesUploadServer(LongPollBot bot) {
		super(bot);
	}

	@Override
	protected String getApi() {
		return VkApi.Docs.GET_MESSAGES_UPLOAD_SERVER;
	}

	@Override
	protected JsonToPojoConverter<DocsGetUploadServerResult> getConverter() {
		return GenericConverterFactory.get(DocsGetUploadServerResult.class);
	}
}
