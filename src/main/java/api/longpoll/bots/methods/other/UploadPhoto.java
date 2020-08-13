package api.longpoll.bots.methods.other;

import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.PostMethod;
import api.longpoll.bots.model.response.other.UploadPhotoResult;

import java.io.File;

public class UploadPhoto extends PostMethod<UploadPhotoResult> {
	private static final String PHOTO = "photo";

	private String uploadUrl;

	public File getPhoto() {
		return getFile();
	}

	public UploadPhoto setPhoto(File photo) {
		setFile(photo);
		return this;
	}

	public String getUploadUrl() {
		return uploadUrl;
	}

	public UploadPhoto setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
		return this;
	}

	@Override
	protected String getApi() {
		return uploadUrl;
	}

	@Override
	protected JsonToPojoConverter<UploadPhotoResult> getConverter() {
		return GenericConverterFactory.get(UploadPhotoResult.class);
	}

	@Override
	protected String getType() {
		return PHOTO;
	}
}
