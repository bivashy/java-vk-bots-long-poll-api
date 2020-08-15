package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.model.objects.basic.Message;
import com.google.gson.annotations.SerializedName;

import java.util.List;

// TODO: 15.08.2020 remove

/**
 * Response to messages.getById request.
 */
public class MessageGetByIdResponse {
	/**
	 * The total number of messages.
	 */
	@SerializedName("count")
	private Integer count;

	/**
	 * List messages.
	 */
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
