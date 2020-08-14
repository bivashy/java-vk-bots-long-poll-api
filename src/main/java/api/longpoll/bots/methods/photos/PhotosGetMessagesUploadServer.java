package api.longpoll.bots.methods.photos;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.photos.PhotosGetMessagesUploadServerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class PhotosGetMessagesUploadServer extends GetMethod<PhotosGetMessagesUploadServerResult> {
	private Integer peerId;

	public PhotosGetMessagesUploadServer(LongPollBot bot) {
		super(bot);
	}

	@Override
	protected String getApi() {
		return VkApi.Photos.GET_MESSAGE_UPLOAD_SERVER;
	}

	@Override
	protected JsonToPojoConverter<PhotosGetMessagesUploadServerResult> getConverter() {
		return GenericConverterFactory.get(PhotosGetMessagesUploadServerResult.class);
	}

	@Override
	protected Stream<Connection.KeyVal> getKeyValStream() {
		return Stream.of(keyVal("peer_id", peerId));
	}

	public Integer getPeerId() {
		return peerId;
	}

	public PhotosGetMessagesUploadServer setPeerId(Integer peerId) {
		this.peerId = peerId;
		return this;
	}
}
