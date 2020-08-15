package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.model.objects.basic.Chat;
import com.google.gson.annotations.SerializedName;

/**
 * Response to messages.deleteChatPhoto request.
 */
public class MessagesDeleteChatPhotoResponse {
	/**
	 * ID of the system message sent.
	 */
	@SerializedName("messageId")
	private Integer messageId;

	/**
	 * Chat object.
	 */
	@SerializedName("chat")
	private Chat chat;

	public Integer getMessageId() {
		return messageId;
	}

	public MessagesDeleteChatPhotoResponse setMessageId(Integer messageId) {
		this.messageId = messageId;
		return this;
	}

	public Chat getChat() {
		return chat;
	}

	public MessagesDeleteChatPhotoResponse setChat(Chat chat) {
		this.chat = chat;
		return this;
	}
}
