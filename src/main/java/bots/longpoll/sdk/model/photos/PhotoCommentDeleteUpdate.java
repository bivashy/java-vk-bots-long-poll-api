package bots.longpoll.sdk.model.photos;

import bots.longpoll.sdk.model.update.UpdateObject;
import com.google.gson.annotations.SerializedName;

public class PhotoCommentDeleteUpdate extends UpdateObject {
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

	public PhotoCommentDeleteUpdate setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public Integer getId() {
		return id;
	}

	public PhotoCommentDeleteUpdate setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getDeleterId() {
		return deleterId;
	}

	public PhotoCommentDeleteUpdate setDeleterId(Integer deleterId) {
		this.deleterId = deleterId;
		return this;
	}

	public Integer getPhotoId() {
		return photoId;
	}

	public PhotoCommentDeleteUpdate setPhotoId(Integer photoId) {
		this.photoId = photoId;
		return this;
	}

	public Integer getUserId() {
		return userId;
	}

	public PhotoCommentDeleteUpdate setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}
}
