package bots.longpoll.sdk.model.photos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotosSaveMessagesPhotoResponse {
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

	public PhotosSaveMessagesPhotoResponse setAlbumId(Integer albumId) {
		this.albumId = albumId;
		return this;
	}

	public Integer getDate() {
		return date;
	}

	public PhotosSaveMessagesPhotoResponse setDate(Integer date) {
		this.date = date;
		return this;
	}

	public Integer getId() {
		return id;
	}

	public PhotosSaveMessagesPhotoResponse setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public PhotosSaveMessagesPhotoResponse setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public Boolean getHasTags() {
		return hasTags;
	}

	public PhotosSaveMessagesPhotoResponse setHasTags(Boolean hasTags) {
		this.hasTags = hasTags;
		return this;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public PhotosSaveMessagesPhotoResponse setAccessKey(String accessKey) {
		this.accessKey = accessKey;
		return this;
	}

	public List<Size> getSizes() {
		return sizes;
	}

	public PhotosSaveMessagesPhotoResponse setSizes(List<Size> sizes) {
		this.sizes = sizes;
		return this;
	}
}
