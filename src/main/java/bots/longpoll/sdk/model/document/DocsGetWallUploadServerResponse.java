package bots.longpoll.sdk.model.document;

import com.google.gson.annotations.SerializedName;

public class DocsGetWallUploadServerResponse {
	@SerializedName("upload_url")
	private String uploadUrl;

	public String getUploadUrl() {
		return uploadUrl;
	}

	public DocsGetWallUploadServerResponse setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
		return this;
	}
}
