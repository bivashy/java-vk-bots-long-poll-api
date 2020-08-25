package api.longpoll.bots.model.response.photos;

import com.google.gson.annotations.SerializedName;

public class PhotosGetMessagesUploadServerResult {
	@SerializedName("response")
	private Response response;

	public static class Response {
		@SerializedName("upload_url")
		private String uploadUrl;
		@SerializedName("album_id")
		private Integer albumId;
		@SerializedName("group_id")
		private Integer groupId;

		public String getUploadUrl() {
			return uploadUrl;
		}

		public void setUploadUrl(String uploadUrl) {
			this.uploadUrl = uploadUrl;
		}

		public Integer getAlbumId() {
			return albumId;
		}

		public void setAlbumId(Integer albumId) {
			this.albumId = albumId;
		}

		public Integer getGroupId() {
			return groupId;
		}

		public void setGroupId(Integer groupId) {
			this.groupId = groupId;
		}
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}
}
