package api.longpoll.bots.methods.messages;

import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.PostExecutor;
import api.longpoll.bots.model.messages.MessageUploadPhotoResponse;

import java.io.File;

public class MessageUploadPhoto extends PostExecutor<MessageUploadPhotoResponse> {
	private static final String PHOTO = "photo";

	private String uploadUrl;

	public File getPhoto() {
		return getFile();
	}

	public MessageUploadPhoto setPhoto(File photo) {
		setFile(photo);
		return this;
	}

	public String getUploadUrl() {
		return uploadUrl;
	}

	public MessageUploadPhoto setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
		return this;
	}

	@Override
	protected String getApi() {
		return uploadUrl;
	}

	@Override
	protected JsonToPojoConverter<MessageUploadPhotoResponse> getConverter() {
		return GenericConverterFactory.get(MessageUploadPhotoResponse.class);
	}

	@Override
	protected String getType() {
		return PHOTO;
	}
}
