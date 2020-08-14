package api.longpoll.bots.model.likes;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

public class LikeEvent implements EventObject {
	@SerializedName("liker_id")
	private Integer likerId;
	@SerializedName("object_type")
	private String objectType;
	@SerializedName("object_owner_id")
	private Integer objectOwnerId;
	@SerializedName("object_id")
	private Integer objectId;
	@SerializedName("thread_reply_id")
	private Integer threadReplyId;
	@SerializedName("post_id")
	private Integer postId;

	public Integer getLikerId() {
		return likerId;
	}

	public LikeEvent setLikerId(Integer likerId) {
		this.likerId = likerId;
		return this;
	}

	public String getObjectType() {
		return objectType;
	}

	public LikeEvent setObjectType(String objectType) {
		this.objectType = objectType;
		return this;
	}

	public Integer getObjectOwnerId() {
		return objectOwnerId;
	}

	public LikeEvent setObjectOwnerId(Integer objectOwnerId) {
		this.objectOwnerId = objectOwnerId;
		return this;
	}

	public Integer getObjectId() {
		return objectId;
	}

	public LikeEvent setObjectId(Integer objectId) {
		this.objectId = objectId;
		return this;
	}

	public Integer getThreadReplyId() {
		return threadReplyId;
	}

	public LikeEvent setThreadReplyId(Integer threadReplyId) {
		this.threadReplyId = threadReplyId;
		return this;
	}

	public Integer getPostId() {
		return postId;
	}

	public LikeEvent setPostId(Integer postId) {
		this.postId = postId;
		return this;
	}
}
