package api.longpoll.bots.model.photos;

import api.longpoll.bots.model.wall.reply.WallComment;
import com.google.gson.annotations.SerializedName;

public class PhotoCommentEvent extends WallComment {
	@SerializedName("photo_id")
	private Integer photoId;
	@SerializedName("photo_owner_id")
	private Integer photoOwnerId;

	public Integer getPhotoId() {
		return photoId;
	}

	public PhotoCommentEvent setPhotoId(Integer photoId) {
		this.photoId = photoId;
		return this;
	}

	public Integer getPhotoOwnerId() {
		return photoOwnerId;
	}

	public PhotoCommentEvent setPhotoOwnerId(Integer photoOwnerId) {
		this.photoOwnerId = photoOwnerId;
		return this;
	}
}
