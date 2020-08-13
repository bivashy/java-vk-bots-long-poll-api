package api.longpoll.bots.model.response.messages;

import com.google.gson.annotations.SerializedName;

public class MessagesSendResult {
	@SerializedName("response")
	private Object response;

	public Object getResponse() {
		return response;
	}

	public MessagesSendResult setResponse(Object response) {
		this.response = response;
		return this;
	}
}
