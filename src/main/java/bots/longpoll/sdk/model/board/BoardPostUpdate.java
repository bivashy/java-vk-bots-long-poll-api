package bots.longpoll.sdk.model.board;

import com.google.gson.annotations.SerializedName;

public class BoardPostUpdate extends TopicComment {
	@SerializedName("topic_id")
	private Integer topicId;
	@SerializedName("topic_owner_id")
	private Integer topicOwnerId;

	public Integer getTopicId() {
		return topicId;
	}

	public BoardPostUpdate setTopicId(Integer topicId) {
		this.topicId = topicId;
		return this;
	}

	public Integer getTopicOwnerId() {
		return topicOwnerId;
	}

	public BoardPostUpdate setTopicOwnerId(Integer topicOwnerId) {
		this.topicOwnerId = topicOwnerId;
		return this;
	}
}
