package bots.longpoll.sdk.model.messages;

import com.google.gson.annotations.SerializedName;

public class MessagesSendResponse {
	@SerializedName("response")
	private Object response;

	public Object getResponse() {
		return response;
	}

	public MessagesSendResponse setResponse(Object response) {
		this.response = response;
		return this;
	}
}
