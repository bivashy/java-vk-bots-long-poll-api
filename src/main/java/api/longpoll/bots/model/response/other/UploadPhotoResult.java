package api.longpoll.bots.model.response.other;

import com.google.gson.annotations.SerializedName;

public class UploadPhotoResult {
	@SerializedName("server")
	private Integer server;
	@SerializedName("photo")
	private String photo;
	@SerializedName("hash")
	private String hash;

	public Integer getServer() {
		return server;
	}

	public UploadPhotoResult setServer(Integer server) {
		this.server = server;
		return this;
	}

	public String getPhoto() {
		return photo;
	}

	public UploadPhotoResult setPhoto(String photo) {
		this.photo = photo;
		return this;
	}

	public String getHash() {
		return hash;
	}

	public UploadPhotoResult setHash(String hash) {
		this.hash = hash;
		return this;
	}
}
