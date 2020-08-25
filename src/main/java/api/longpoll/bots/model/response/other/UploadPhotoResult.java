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

	public void setServer(Integer server) {
		this.server = server;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
}
