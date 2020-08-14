package api.longpoll.bots.model.photos;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

public class PhotoCommentDeleteEvent implements EventObject {
	@SerializedName("owner_id")
	private Integer ownerId;
	@SerializedName("id")
	private Integer id;
	@SerializedName("deleter_id")
	private Integer deleterId;
	@SerializedName("photo_id")
	private Integer photoId;
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
