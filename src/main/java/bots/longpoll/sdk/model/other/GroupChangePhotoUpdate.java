package bots.longpoll.sdk.model.other;

import bots.longpoll.sdk.model.photos.Photo;
import bots.longpoll.sdk.model.update.UpdateObject;
import com.google.gson.annotations.SerializedName;

public class GroupChangePhotoUpdate extends UpdateObject {
	@SerializedName("user_id")
	private Integer userId;
	@SerializedName("photo")
	private Photo photo;

	public Integer getUserId() {
		return userId;
	}

	public Photo getPhoto() {
		return photo;
	}
}
