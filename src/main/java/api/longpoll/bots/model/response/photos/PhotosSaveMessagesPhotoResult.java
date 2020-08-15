package api.longpoll.bots.model.response.photos;

import api.longpoll.bots.model.objects.additional.PhotoSize;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotosSaveMessagesPhotoResult {
	@SerializedName("response")
	private List<Response> response;

	public List<Response> getResponse() {
		return response;
	}

	public PhotosSaveMessagesPhotoResult setResponse(List<Response> response) {
		this.response = response;
		return this;
	}

	public class Response {
		@SerializedName("album_id")
		private Integer albumId;
		@SerializedName("date")
		private Integer date;
		@SerializedName("id")
		private Integer id;
		@SerializedName("owner_id")
		private Integer ownerId;
		@SerializedName("has_tags")
		private Boolean hasTags;
		@SerializedName("access_key")
		private String accessKey;
		@SerializedName("photoSizes")
		private List<PhotoSize> photoSizes;

		public Integer getAlbumId() {
			return albumId;
		}

		public Response setAlbumId(Integer albumId) {
			this.albumId = albumId;
			return this;
		}

		public Integer getDate() {
			return date;
		}

		public Response setDate(Integer date) {
			this.date = date;
			return this;
		}

		public Integer getId() {
			return id;
		}

		public Response setId(Integer id) {
			this.id = id;
			return this;
		}

		public Integer getOwnerId() {
			return ownerId;
		}

		public Response setOwnerId(Integer ownerId) {
			this.ownerId = ownerId;
			return this;
		}

		public Boolean getHasTags() {
			return hasTags;
		}

		public Response setHasTags(Boolean hasTags) {
			this.hasTags = hasTags;
			return this;
		}

		public String getAccessKey() {
			return accessKey;
		}

		public Response setAccessKey(String accessKey) {
			this.accessKey = accessKey;
			return this;
		}

		public List<PhotoSize> getPhotoSizes() {
			return photoSizes;
		}

		public Response setPhotoSizes(List<PhotoSize> photoSizes) {
			this.photoSizes = photoSizes;
			return this;
		}
	}
}
