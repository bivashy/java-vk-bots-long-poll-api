package bots.longpoll.sdk.executors.photos;

import bots.longpoll.sdk.LongPollBot;
import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.converters.photo.PhotosGetMessagesUploadServerResponseConverterImpl;
import bots.longpoll.sdk.executors.GetExecutor;
import bots.longpoll.sdk.executors.VkApi;
import bots.longpoll.sdk.model.photos.PhotosGetMessagesUploadServerResponse;

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
