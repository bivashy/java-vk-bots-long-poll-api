package api.longpoll.bots.model.events.boards;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>board_post_delete</b> event objects.
 */
public class BoardPostDeleteEvent implements EventObject {
	/**
	 * Topic owner ID.
	 */
	@SerializedName("topic_owner_id")
	private Integer topicOwnerId;

	// TODO: 14.08.2020 find out javadoc
	@SerializedName("id")
	private Integer id;

	/**
	 * Topic ID.
	 */
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
