package api.longpoll.bots.model.messages;

import api.longpoll.bots.model.objects.basic.Message;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MessageGetByIdResponse {
	@SerializedName("count")
	private Integer count;
	@SerializedName("items")
	private List<Message> messages;

	public Integer getCount() {
		return count;
	}

	public MessageGetByIdResponse setCount(Integer count) {
		this.count = count;
		return this;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public MessageGetByIdResponse setMessages(List<Message> messages) {
		this.messages = messages;
		return this;
	}
}
