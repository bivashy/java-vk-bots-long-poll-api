package api.longpoll.bots.executors.docs;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.doc.DocsGetMessagesUploadServerResponseConverterImpl;
import api.longpoll.bots.model.document.DocsGetMessagesUploadServerResponse;
import api.longpoll.bots.executors.GetExecutor;
import api.longpoll.bots.executors.VkApi;

public class DocsGetMessagesUploadServer extends GetExecutor<DocsGetMessagesUploadServerResponse> {
	private static final String TYPE = "type";
	private static final String PEER_ID = "peer_id";

	public DocsGetMessagesUploadServer setType(String type) {
		params.put(TYPE, type);
		return this;
	}

	public String getType(String type) {
		return (String) params.get(TYPE);
	}

	public DocsGetMessagesUploadServer setPeerId(int peerId) {
		params.put(PEER_ID, peerId);
		return this;
	}

	public int getPeerId(int peerId) {
		return (int) params.get(PEER_ID);
	}

	public DocsGetMessagesUploadServer(LongPollBot bot) {
		super(bot);
	}

	@Override
	protected String getApi() {
		return VkApi.Docs.GET_MESSAGES_UPLOAD_SERVER;
	}

	@Override
	protected JsonToPojoConverter<DocsGetMessagesUploadServerResponse> getConverter() {
		return new DocsGetMessagesUploadServerResponseConverterImpl();
	}
}
