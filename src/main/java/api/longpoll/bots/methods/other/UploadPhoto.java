package api.longpoll.bots.methods.other;

import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.PostMethod;
import api.longpoll.bots.model.response.other.UploadPhotoResult;
import org.jsoup.Connection;

import java.io.File;
import java.util.stream.Stream;

public class UploadPhoto extends PostMethod<UploadPhotoResult> {
	private String uploadUrl;

	@Override
	protected String getApi() {
		return uploadUrl;
	}

	@Override
	protected JsonToPojoConverter<UploadPhotoResult> getConverter() {
		return GenericConverterFactory.get(UploadPhotoResult.class);
	}

	@Override
	protected Stream<Connection.KeyVal> getKeyValStream() {
		return Stream.of();
	}

	@Override
	protected String getType() {
		return "photo";
	}

	public String getUploadUrl() {
		return uploadUrl;
	}

	public UploadPhoto setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
		return this;
	}

	public UploadPhoto setPhoto(File photo) {
		setFile(photo);
		return this;
	}

	public File getPhoto() {
		return getFile();
	}
}
