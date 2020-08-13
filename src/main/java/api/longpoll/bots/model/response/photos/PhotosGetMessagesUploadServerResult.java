package api.longpoll.bots.model.response.photos;

import com.google.gson.annotations.SerializedName;

public class PhotosGetMessagesUploadServerResult {
	@SerializedName("response")
	private Response response;

	public Response getResponse() {
		return response;
	}

	public PhotosGetMessagesUploadServerResult setResponse(Response response) {
		this.response = response;
		return this;
	}

	public class Response {
		@SerializedName("upload_url")
		private String uploadUrl;
		@SerializedName("album_id")
		private Integer albumId;
		@SerializedName("group_id")
		private Integer groupId;

		public String getUploadUrl() {
			return uploadUrl;
		}

		public Response setUploadUrl(String uploadUrl) {
			this.uploadUrl = uploadUrl;
			return this;
		}

		public Integer getAlbumId() {
			return albumId;
		}

		public Response setAlbumId(Integer albumId) {
			this.albumId = albumId;
			return this;
		}

		public Integer getGroupId() {
			return groupId;
		}

		public Response setGroupId(Integer groupId) {
			this.groupId = groupId;
			return this;
		}
	}
}
