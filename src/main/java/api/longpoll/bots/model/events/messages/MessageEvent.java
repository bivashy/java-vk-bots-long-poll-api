package api.longpoll.bots.model.events.messages;

import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.objects.additional.ClientInfo;
import api.longpoll.bots.model.objects.basic.Message;
import com.google.gson.annotations.SerializedName;

/**
 * Event object that comes when the <i>message_new</i> or <i>message_reply</i> event fires.
 */
public class MessageEvent extends EventObject {
	/**
	 * Message object.
	 */
	@SerializedName("messages")
	private Message message;

	/**
	 * Information about features available to the user.
	 */
	@SerializedName("client_info")
	private ClientInfo clientInfo;

	/**
	 * Gets message.
	 *
	 * @return message object.
	 */
	public Message getMessage() {
		return message;
	}

	/**
	 * Sets message.
	 *
	 * @param message message object.
	 * @return this MessageEvent.
	 */
	public MessageEvent setMessage(Message message) {
		this.message = message;
		return this;
	}

	/**
	 * Gets available user features.
	 *
	 * @return available user features.
	 */
	public ClientInfo getClientInfo() {
		return clientInfo;
	}

	/**
	 * Sets available user features.
	 *
	 * @param clientInfo available user features.
	 * @return this MessageEvent.
	 */
	public MessageEvent setClientInfo(ClientInfo clientInfo) {
		this.clientInfo = clientInfo;
		return this;
	}


}
