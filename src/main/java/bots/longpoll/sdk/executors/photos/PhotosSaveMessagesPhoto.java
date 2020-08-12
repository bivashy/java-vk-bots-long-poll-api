package bots.longpoll.sdk.executors.photos;

import bots.longpoll.sdk.LongPollBot;
import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.converters.photo.PhotosSaveMessagesPhotoResponseConverterImpl;
import bots.longpoll.sdk.executors.GetExecutor;
import bots.longpoll.sdk.executors.VkApi;
import bots.longpoll.sdk.model.photos.PhotosSaveMessagesPhotoResponse;

public class PhotosSaveMessagesPhoto extends GetExecutor<PhotosSaveMessagesPhotoResponse> {
	private static final String PHOTO = "photo";
	private static final String SERVER = "server";
	private static final String HASH = "hash";

	public PhotosSaveMessagesPhoto(LongPollBot bot) {
		super(bot);
	}

	public PhotosSaveMessagesPhoto setPhoto(String photo) {
		params.put(PHOTO, photo);
		return this;
	}

	public String getPhoto(String photo) {
		return (String) params.get(PHOTO);
	}

	public PhotosSaveMessagesPhoto setServer(int server) {
		params.put(SERVER, server);
		return this;
	}

	public int getServer(int server) {
		return (int) params.get(SERVER);
	}

	public PhotosSaveMessagesPhoto setHash(String hash) {
		params.put(HASH, hash);
		return this;
	}

	public String getHash(String hash) {
		return (String) params.get(HASH);
	}

	@Override
	protected String getApi() {
		return VkApi.Photos.SAVE_MESSAGES_PHOTO;
	}

	@Override
	protected JsonToPojoConverter<PhotosSaveMessagesPhotoResponse> getConverter() {
		return new PhotosSaveMessagesPhotoResponseConverterImpl();
	}
}
