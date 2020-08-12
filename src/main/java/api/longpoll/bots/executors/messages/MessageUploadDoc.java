package api.longpoll.bots.executors.messages;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.messages.MessageUploadDocResponseConverterImpl;
import api.longpoll.bots.model.messages.MessageUploadDocResponse;
import api.longpoll.bots.executors.PostExecutor;

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
		return new MessageUploadDocResponseConverterImpl();
	}

	@Override
	protected String getType() {
		return FILE;
	}
}
