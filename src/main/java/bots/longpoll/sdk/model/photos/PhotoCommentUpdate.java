package bots.longpoll.sdk.model.photos;

import bots.longpoll.sdk.model.wall.reply.WallReply;
import com.google.gson.annotations.SerializedName;

public class PhotoCommentUpdate extends WallReply {
	@SerializedName("photo_id")
	private Integer photoId;
	@SerializedName("photo_owner_id")
	private Integer photoOwnerId;

	public Integer getPhotoId() {
		return photoId;
	}

	public PhotoCommentUpdate setPhotoId(Integer photoId) {
		this.photoId = photoId;
		return this;
	}

	public Integer getPhotoOwnerId() {
		return photoOwnerId;
	}

	public PhotoCommentUpdate setPhotoOwnerId(Integer photoOwnerId) {
		this.photoOwnerId = photoOwnerId;
		return this;
	}
}
