package api.longpoll.bots.methods.other;

import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.PostMethod;
import api.longpoll.bots.model.response.other.UploadDocResult;

import java.io.File;

public class UploadDoc extends PostMethod<UploadDocResult> {
	private static final String FILE = "file";

	private String uploadUrl;

	public UploadDoc setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
		return this;
	}

	public UploadDoc setDoc(File doc) {
		setFile(doc);
		return this;
	}

	@Override
	protected String getApi() {
		return uploadUrl;
	}

	@Override
	protected JsonToPojoConverter<UploadDocResult> getConverter() {
		return GenericConverterFactory.get(UploadDocResult.class);
	}

	@Override
	protected String getType() {
		return FILE;
	}
}
