package bots.longpoll.sdk.executors.messages;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.converters.messages.MessageUploadDocResponseConverterImpl;
import bots.longpoll.sdk.executors.PostExecutor;
import bots.longpoll.sdk.model.messages.MessageUploadDocResponse;

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
