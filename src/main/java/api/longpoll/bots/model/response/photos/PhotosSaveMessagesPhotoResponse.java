package api.longpoll.bots.model.response.photos;

import api.longpoll.bots.model.photos.Size;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotosSaveMessagesPhotoResponse {
	@SerializedName("response")
	private Response response;

	public Response getResponse() {
		return response;
	}

	public PhotosSaveMessagesPhotoResponse setResponse(Response response) {
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
		@SerializedName("sizes")
		private List<Size> sizes;

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

		public List<Size> getSizes() {
			return sizes;
		}

		public Response setSizes(List<Size> sizes) {
			this.sizes = sizes;
			return this;
		}
	}
}
