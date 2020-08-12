package bots.longpoll.sdk.model.photos;

import com.google.gson.annotations.SerializedName;

public class PhotosGetMessagesUploadServerResponse {
	@SerializedName("upload_url")
	private String uploadUrl;
	@SerializedName("album_id")
	private Integer albumId;
	@SerializedName("group_id")
	private Integer groupId;

	public String getUploadUrl() {
		return uploadUrl;
	}

	public PhotosGetMessagesUploadServerResponse setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
		return this;
	}

	public Integer getAlbumId() {
		return albumId;
	}

	public PhotosGetMessagesUploadServerResponse setAlbumId(Integer albumId) {
		this.albumId = albumId;
		return this;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public PhotosGetMessagesUploadServerResponse setGroupId(Integer groupId) {
		this.groupId = groupId;
		return this;
	}
}
