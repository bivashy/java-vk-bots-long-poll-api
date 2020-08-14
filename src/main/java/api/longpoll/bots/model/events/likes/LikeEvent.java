package api.longpoll.bots.model.events.likes;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>like_add</b> event objects.
 */
public class LikeEvent implements EventObject {
	/**
	 * User ID.
	 */
	@SerializedName("liker_id")
	private Integer likerId;

	/**
	 * What was liked. Possible values:
	 * <ul>
	 *     <li>video</li>
	 *     <li>photo</li>
	 *     <li>comment</li>
	 *     <li>note</li>
	 *     <li>topic_comment</li>
	 *     <li>photo_comment</li>
	 *     <li>video_comment</li>
	 *     <li>market</li>
	 *     <li>market_comment</li>
	 * </ul>
	 */
	@SerializedName("object_type")
	private String objectType;

	/**
	 * Liked object owner ID.
	 */
	@SerializedName("object_owner_id")
	private Integer objectOwnerId;

	/**
	 * Liked object ID.
	 */
	@SerializedName("object_id")
	private Integer objectId;

	/**
	 * Parent object ID.
	 */
	@SerializedName("thread_reply_id")
	private Integer threadReplyId;

	/**
	 * Post ID.
	 */
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
