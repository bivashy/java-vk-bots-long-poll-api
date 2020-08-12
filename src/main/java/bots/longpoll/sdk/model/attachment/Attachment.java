package bots.longpoll.sdk.model.attachment;

import bots.longpoll.sdk.model.photos.Photo;
import com.google.gson.annotations.SerializedName;

public class Attachment {
	@SerializedName("type")
	private String type;
	private MediaObject mediaObject;

	public Attachment setType(String type) {
		this.type = type;
		return this;
	}

	public Attachment setMediaObject(MediaObject mediaObject) {
		this.mediaObject = mediaObject;
		return this;
	}

	public String getType() {
		return type;
	}

	public MediaObject getMediaObject() {
		return mediaObject;
	}

	public Photo getPhoto() {
		return mediaObject instanceof Photo
				? (Photo) mediaObject
				: null;
	}
}
