package api.longpoll.bots.executors.messages;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.messages.MessageUploadPhotoResponse;
import api.longpoll.bots.converters.messages.MessageUploadPhotoResponseConverterImpl;
import api.longpoll.bots.executors.PostExecutor;

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
		return new MessageUploadPhotoResponseConverterImpl();
	}

	@Override
	protected String getType() {
		return PHOTO;
	}
}
