package bots.longpoll.sdk.model.messages;

import bots.longpoll.sdk.model.update.UpdateObject;
import com.google.gson.annotations.SerializedName;

public class MessageUpdate extends UpdateObject {
	@SerializedName("messages")
	private Message message;
	@SerializedName("client_info")
	private ClientInfo clientInfo;

	public Message getMessage() {
		return message;
	}

	public MessageUpdate setMessage(Message message) {
		this.message = message;
		return this;
	}

	public ClientInfo getClientInfo() {
		return clientInfo;
	}

	public MessageUpdate setClientInfo(ClientInfo clientInfo) {
		this.clientInfo = clientInfo;
		return this;
	}
}
