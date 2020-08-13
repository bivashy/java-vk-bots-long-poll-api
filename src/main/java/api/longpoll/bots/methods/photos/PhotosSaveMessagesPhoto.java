package api.longpoll.bots.methods.photos;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.response.photos.PhotosSaveMessagesPhotoResult;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;

public class PhotosSaveMessagesPhoto extends GetMethod<PhotosSaveMessagesPhotoResult> {
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
	protected JsonToPojoConverter<PhotosSaveMessagesPhotoResult> getConverter() {
		return GenericConverterFactory.get(PhotosSaveMessagesPhotoResult.class);
	}
}
