package api.longpoll.bots.model.events.boards;

import api.longpoll.bots.model.objects.basic.TopicComment;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>new comment in a board</b>, <b>editing a board comment</b> and <b>restoring a board comment</b> event objects.
 */
public class BoardPostEvent extends TopicComment {
	/**
	 * Topic ID.
	 */
	@SerializedName("topic_id")
	private Integer topicId;

	/**
	 * Topic owner ID.
	 */
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
