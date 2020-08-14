package api.longpoll.bots.methods.other;

import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.PostMethod;
import api.longpoll.bots.model.response.other.UploadDocResult;
import org.jsoup.Connection;

import java.io.File;
import java.util.stream.Stream;

public class UploadDoc extends PostMethod<UploadDocResult> {
	private String uploadUrl;

	@Override
	protected String getApi() {
		return uploadUrl;
	}

	@Override
	protected JsonToPojoConverter<UploadDocResult> getConverter() {
		return GenericConverterFactory.get(UploadDocResult.class);
	}

	@Override
	protected Stream<Connection.KeyVal> getKeyValStream() {
		return Stream.of();
	}

	@Override
	protected String getType() {
		return "file";
	}

	public String getUploadUrl() {
		return uploadUrl;
	}

	public UploadDoc setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
		return this;
	}

	public UploadDoc setDoc(File doc) {
		setFile(doc);
		return this;
	}

	public File getDoc() {
		return getFile();
	}
}
