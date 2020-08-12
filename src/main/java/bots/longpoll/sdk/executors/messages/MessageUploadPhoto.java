package bots.longpoll.sdk.executors.messages;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.converters.messages.MessageUploadPhotoResponseConverterImpl;
import bots.longpoll.sdk.executors.PostExecutor;
import bots.longpoll.sdk.model.messages.MessageUploadPhotoResponse;

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
