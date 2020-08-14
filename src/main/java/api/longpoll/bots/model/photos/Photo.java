package api.longpoll.bots.model.photos;

import api.longpoll.bots.model.objects.media.Attachable;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photo implements Attachable {
	@SerializedName("id")
	private Integer id;
	@SerializedName("album_id")
	private Integer albumId;
	@SerializedName("owner_id")
	private Integer ownerId;
	@SerializedName("user_id")
	private Integer userId;
	@SerializedName("text")
	private String text;
	@SerializedName("date")
	private Integer date;
	@SerializedName("sizes")
	private List<Size> sizes;
	@SerializedName("access_key")
	private String accessKey;

	public boolean hasText() {
		return text != null && !text.isEmpty();
	}

	public Photo setId(Integer id) {
		this.id = id;
		return this;
	}

	public Photo setAlbumId(Integer albumId) {
		this.albumId = albumId;
		return this;
	}

	public Photo setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public Photo setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public Photo setText(String text) {
		this.text = text;
		return this;
	}

	public Photo setDate(Integer date) {
		this.date = date;
		return this;
	}

	public Photo setSizes(List<Size> sizes) {
		this.sizes = sizes;
		return this;
	}

	public Integer getId() {
		return id;
	}

	public Integer getAlbumId() {
		return albumId;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getText() {
		return text;
	}

	public Integer getDate() {
		return date;
	}

	public List<Size> getSizes() {
		return sizes;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public Photo setAccessKey(String accessKey) {
		this.accessKey = accessKey;
		return this;
	}
}
