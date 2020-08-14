package api.longpoll.bots.model.other;

import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.photos.Photo;
import com.google.gson.annotations.SerializedName;

public class GroupChangePhotoEvent implements EventObject {
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
