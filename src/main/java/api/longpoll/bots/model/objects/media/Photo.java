package api.longpoll.bots.model.objects.media;

import api.longpoll.bots.model.objects.additional.PhotoSize;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Describes photo.
 * @see <a href="https://vk.com/dev/objects/photo">Photo</a>
 */
public class Photo implements Attachable {
	/**
	 * Photo ID.
	 */
	@SerializedName("id")
	private Integer id;

	/**
	 * Photo album ID.
	 */
	@SerializedName("album_id")
	private Integer albumId;

	/**
	 * Photo owner ID.
	 */
	@SerializedName("owner_id")
	private Integer ownerId;

	/**
	 * 	ID of the user who uploaded the photo (if the photo is uploaded in community). 100 for photos uploaded by the community.
	 */
	@SerializedName("user_id")
	private Integer userId;

	/**
	 * Description text.
	 */
	@SerializedName("text")
	private String text;

	/**
	 * Date when the photo has been added in Unixtime.
	 */
	@SerializedName("date")
	private Integer date;

	/**
	 * Array with the photo copies of different photoSizes.
	 */
	@SerializedName("sizes")
	private List<PhotoSize> photoSizes;

	/**
	 * Photo access key.
	 */
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

	public Photo setPhotoSizes(List<PhotoSize> photoSizes) {
		this.photoSizes = photoSizes;
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

	public List<PhotoSize> getPhotoSizes() {
		return photoSizes;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public Photo setAccessKey(String accessKey) {
		this.accessKey = accessKey;
		return this;
	}
}
