package api.longpoll.bots.model.messages;

import com.google.gson.annotations.SerializedName;

public class MessagesDeleteChatPhotoResponse {
	@SerializedName("messageId")
	private Integer messageId;
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
