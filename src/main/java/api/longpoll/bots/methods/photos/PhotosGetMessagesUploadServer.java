package api.longpoll.bots.methods.photos;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetExecutor;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.photos.PhotosGetMessagesUploadServerResponse;

public class PhotosGetMessagesUploadServer extends GetExecutor<PhotosGetMessagesUploadServerResponse> {
	private static final String PEER_ID = "peer_id";

	public PhotosGetMessagesUploadServer setPeerId(int peerId) {
		params.put(PEER_ID, peerId);
		return this;
	}

	public int getPeerId(int peerId) {
		return (int) params.get(PEER_ID);
	}

	public PhotosGetMessagesUploadServer(LongPollBot bot) {
		super(bot);
	}

	@Override
	protected String getApi() {
		return VkApi.Photos.GET_MESSAGE_UPLOAD_SERVER;
	}

	@Override
	protected JsonToPojoConverter<PhotosGetMessagesUploadServerResponse> getConverter() {
		return GenericConverterFactory.get(PhotosGetMessagesUploadServerResponse.class);
	}
}
