package bots.longpoll.sdk.model.messages;

import com.google.gson.annotations.SerializedName;

public class MessageUploadDocResponse {
	@SerializedName("file")
	private String file;

	public String getFile() {
		return file;
	}

	public MessageUploadDocResponse setFile(String file) {
		this.file = file;
		return this;
	}
}
