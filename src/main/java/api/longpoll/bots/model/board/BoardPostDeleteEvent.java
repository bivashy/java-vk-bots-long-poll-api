package api.longpoll.bots.model.board;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

public class BoardPostDeleteEvent extends EventObject {
	@SerializedName("topic_owner_id")
	private Integer topicOwnerId;
	@SerializedName("id")
	private Integer id;
	@SerializedName("topic_id")
	private Integer topicId;

	public Integer getTopicOwnerId() {
		return topicOwnerId;
	}

	public BoardPostDeleteEvent setTopicOwnerId(Integer topicOwnerId) {
		this.topicOwnerId = topicOwnerId;
		return this;
	}

	public Integer getId() {
		return id;
	}

	public BoardPostDeleteEvent setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public BoardPostDeleteEvent setTopicId(Integer topicId) {
		this.topicId = topicId;
		return this;
	}
}
