package api.longpoll.bots.model.events.photos;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>photo_comment_delete</b> event objects.
 */
public class PhotoCommentDeleteEvent implements EventObject {
	/**
	 * Photo owner ID.
	 */
	@SerializedName("owner_id")
	private Integer ownerId;

	/**
	 * Comment ID.
	 */
	@SerializedName("id")
	private Integer id;

	/**
	 * ID of the user who deleted a comment.
	 */
	@SerializedName("deleter_id")
	private Integer deleterId;

	/**
	 * Photo ID.
	 */
	@SerializedName("photo_id")
	private Integer photoId;

	/**
	 * Comment author ID.
	 */
	@SerializedName("user_id")
	private Integer userId;

	public Integer getOwnerId() {
		return ownerId;
	}

	public PhotoCommentDeleteEvent setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public Integer getId() {
		return id;
	}

	public PhotoCommentDeleteEvent setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getDeleterId() {
		return deleterId;
	}

	public PhotoCommentDeleteEvent setDeleterId(Integer deleterId) {
		this.deleterId = deleterId;
		return this;
	}

	public Integer getPhotoId() {
		return photoId;
	}

	public PhotoCommentDeleteEvent setPhotoId(Integer photoId) {
		this.photoId = photoId;
		return this;
	}

	public Integer getUserId() {
		return userId;
	}

	public PhotoCommentDeleteEvent setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}
}
