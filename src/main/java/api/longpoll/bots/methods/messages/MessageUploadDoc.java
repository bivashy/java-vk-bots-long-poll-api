package api.longpoll.bots.methods.messages;

import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.PostExecutor;
import api.longpoll.bots.model.messages.MessageUploadDocResponse;

import java.io.File;

public class MessageUploadDoc extends PostExecutor<MessageUploadDocResponse> {
	private static final String FILE = "file";

	private String uploadUrl;

	public String getUploadUrl() {
		return uploadUrl;
	}

	public MessageUploadDoc setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
		return this;
	}

	public File getDoc() {
		return getFile();
	}

	public MessageUploadDoc setDoc(File doc) {
		setFile(doc);
		return this;
	}

	@Override
	protected String getApi() {
		return uploadUrl;
	}

	@Override
	protected JsonToPojoConverter<MessageUploadDocResponse> getConverter() {
		return GenericConverterFactory.get(MessageUploadDocResponse.class);
	}

	@Override
	protected String getType() {
		return FILE;
	}
}
