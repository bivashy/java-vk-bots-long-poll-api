package api.longpoll.bots.model.messages;

import com.google.gson.annotations.SerializedName;

public class MessageUploadPhotoResponse {
	@SerializedName("server")
	private Integer server;
	@SerializedName("photo")
	private String photo;
	@SerializedName("hash")
	private String hash;

	public Integer getServer() {
		return server;
	}

	public MessageUploadPhotoResponse setServer(Integer server) {
		this.server = server;
		return this;
	}

	public String getPhoto() {
		return photo;
	}

	public MessageUploadPhotoResponse setPhoto(String photo) {
		this.photo = photo;
		return this;
	}

	public String getHash() {
		return hash;
	}

	public MessageUploadPhotoResponse setHash(String hash) {
		this.hash = hash;
		return this;
	}
}
