package api.longpoll.bots.model.events.wall.comments;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

public class WallReplyDeleteEvent implements EventObject {
	@SerializedName("owner_id")
	private Integer ownerId;
	@SerializedName("id")
	private Integer id;
	@SerializedName("deleter_id")
	private Integer deleterId;
	@SerializedName("post_id")
	private Integer postId;

	public Integer getOwnerId() {
		return ownerId;
	}

	public WallReplyDeleteEvent setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public Integer getId() {
		return id;
	}

	public WallReplyDeleteEvent setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getDeleterId() {
		return deleterId;
	}

	public WallReplyDeleteEvent setDeleterId(Integer deleterId) {
		this.deleterId = deleterId;
		return this;
	}

	public Integer getPostId() {
		return postId;
	}

	public WallReplyDeleteEvent setPostId(Integer postId) {
		this.postId = postId;
		return this;
	}
}
