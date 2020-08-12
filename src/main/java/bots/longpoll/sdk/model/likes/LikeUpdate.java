package bots.longpoll.sdk.model.likes;

import bots.longpoll.sdk.model.update.UpdateObject;
import com.google.gson.annotations.SerializedName;

public class LikeUpdate extends UpdateObject {
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

	public LikeUpdate setLikerId(Integer likerId) {
		this.likerId = likerId;
		return this;
	}

	public String getObjectType() {
		return objectType;
	}

	public LikeUpdate setObjectType(String objectType) {
		this.objectType = objectType;
		return this;
	}

	public Integer getObjectOwnerId() {
		return objectOwnerId;
	}

	public LikeUpdate setObjectOwnerId(Integer objectOwnerId) {
		this.objectOwnerId = objectOwnerId;
		return this;
	}

	public Integer getObjectId() {
		return objectId;
	}

	public LikeUpdate setObjectId(Integer objectId) {
		this.objectId = objectId;
		return this;
	}

	public Integer getThreadReplyId() {
		return threadReplyId;
	}

	public LikeUpdate setThreadReplyId(Integer threadReplyId) {
		this.threadReplyId = threadReplyId;
		return this;
	}

	public Integer getPostId() {
		return postId;
	}

	public LikeUpdate setPostId(Integer postId) {
		this.postId = postId;
		return this;
	}
}
