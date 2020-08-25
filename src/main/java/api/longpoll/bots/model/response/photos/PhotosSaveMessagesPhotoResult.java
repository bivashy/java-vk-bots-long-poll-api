package api.longpoll.bots.model.response.photos;

import api.longpoll.bots.model.objects.additional.PhotoSize;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotosSaveMessagesPhotoResult {
	@SerializedName("response")
	private List<Response> response;

	public static class Response {
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

		public void setAlbumId(Integer albumId) {
			this.albumId = albumId;
		}

		public Integer getDate() {
			return date;
		}

		public void setDate(Integer date) {
			this.date = date;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getOwnerId() {
			return ownerId;
		}

		public void setOwnerId(Integer ownerId) {
			this.ownerId = ownerId;
		}

		public Boolean getHasTags() {
			return hasTags;
		}

		public void setHasTags(Boolean hasTags) {
			this.hasTags = hasTags;
		}

		public String getAccessKey() {
			return accessKey;
		}

		public void setAccessKey(String accessKey) {
			this.accessKey = accessKey;
		}

		public List<PhotoSize> getPhotoSizes() {
			return photoSizes;
		}

		public void setPhotoSizes(List<PhotoSize> photoSizes) {
			this.photoSizes = photoSizes;
		}
	}

	public List<Response> getResponse() {
		return response;
	}

	public void setResponse(List<Response> response) {
		this.response = response;
	}
}
