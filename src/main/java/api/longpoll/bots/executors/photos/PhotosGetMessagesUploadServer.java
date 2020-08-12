package api.longpoll.bots.executors.photos;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.photo.PhotosGetMessagesUploadServerResponseConverterImpl;
import api.longpoll.bots.model.photos.PhotosGetMessagesUploadServerResponse;
import api.longpoll.bots.executors.GetExecutor;
import api.longpoll.bots.executors.VkApi;

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
		return new PhotosGetMessagesUploadServerResponseConverterImpl();
	}
}
