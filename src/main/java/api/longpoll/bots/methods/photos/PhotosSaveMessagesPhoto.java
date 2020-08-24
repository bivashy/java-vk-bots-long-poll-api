package api.longpoll.bots.methods.photos;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.response.photos.PhotosSaveMessagesPhotoResult;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class PhotosSaveMessagesPhoto extends GetMethod<PhotosSaveMessagesPhotoResult> {
	private String photo;
	private Integer server;
	private String hash;

	public PhotosSaveMessagesPhoto(LongPollBot bot) {
		super(bot);
	}

	@Override
	protected String getApi() {
		return VkApi.getInstance().photosSaveMessagesPhoto();
	}

	@Override
	protected JsonToPojoConverter<PhotosSaveMessagesPhotoResult> getConverter() {
		return GenericConverterFactory.get(PhotosSaveMessagesPhotoResult.class);
	}

	@Override
	protected Stream<Connection.KeyVal> getKeyValStream() {
		return Stream.of(
				keyVal("photo", photo),
				keyVal("server", server),
				keyVal("hash", hash)
		);
	}

	public String getPhoto() {
		return photo;
	}

	public PhotosSaveMessagesPhoto setPhoto(String photo) {
		this.photo = photo;
		return this;
	}

	public Integer getServer() {
		return server;
	}

	public PhotosSaveMessagesPhoto setServer(Integer server) {
		this.server = server;
		return this;
	}

	public String getHash() {
		return hash;
	}

	public PhotosSaveMessagesPhoto setHash(String hash) {
		this.hash = hash;
		return this;
	}
}
