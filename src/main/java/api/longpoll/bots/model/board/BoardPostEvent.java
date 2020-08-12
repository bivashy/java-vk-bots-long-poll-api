package api.longpoll.bots.model.board;

import com.google.gson.annotations.SerializedName;

public class BoardPostEvent extends TopicComment {
	@SerializedName("topic_id")
	private Integer topicId;
	@SerializedName("topic_owner_id")
	private Integer topicOwnerId;

	public Integer getTopicId() {
		return topicId;
	}

	public BoardPostEvent setTopicId(Integer topicId) {
		this.topicId = topicId;
		return this;
	}

	public Integer getTopicOwnerId() {
		return topicOwnerId;
	}

	public BoardPostEvent setTopicOwnerId(Integer topicOwnerId) {
		this.topicOwnerId = topicOwnerId;
		return this;
	}
}
