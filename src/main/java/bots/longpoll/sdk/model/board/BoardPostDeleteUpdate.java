package bots.longpoll.sdk.model.board;

import bots.longpoll.sdk.model.update.UpdateObject;
import com.google.gson.annotations.SerializedName;

public class BoardPostDeleteUpdate extends UpdateObject {
	@SerializedName("topic_owner_id")
	private Integer topicOwnerId;
	@SerializedName("id")
	private Integer id;
	@SerializedName("topic_id")
	private Integer topicId;

	public Integer getTopicOwnerId() {
		return topicOwnerId;
	}

	public BoardPostDeleteUpdate setTopicOwnerId(Integer topicOwnerId) {
		this.topicOwnerId = topicOwnerId;
		return this;
	}

	public Integer getId() {
		return id;
	}

	public BoardPostDeleteUpdate setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public BoardPostDeleteUpdate setTopicId(Integer topicId) {
		this.topicId = topicId;
		return this;
	}
}
