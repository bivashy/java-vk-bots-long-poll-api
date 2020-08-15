package api.longpoll.bots.model.objects.media;

import com.google.gson.annotations.SerializedName;

/**
 * Describes market collection.
 * @see <a href="https://vk.com/dev/objects/market_album">Market Collection</a>
 */
public class MarketCollection implements Attachable {
	/**
	 * Collection ID.
	 */
	@SerializedName("id")
	private Integer id;

	/**
	 * Collection owner ID.
	 */
	@SerializedName("owner_id")
	private Integer ownerId;

	/**
	 * Collection title.
	 */
	@SerializedName("title")
	private String title;

	/**
	 * Collection cover photo object.
	 */
	@SerializedName("photo")
	private Photo photo;

	/**
	 * Items number.
	 */
	@SerializedName("count")
	private Integer count;

	/**
	 * Last update date in Unixtime.
	 */
	@SerializedName("updated_time")
	private Integer updatedTime;

	public Integer getId() {
		return id;
	}

	public MarketCollection setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public MarketCollection setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public MarketCollection setTitle(String title) {
		this.title = title;
		return this;
	}

	public Photo getPhoto() {
		return photo;
	}

	public MarketCollection setPhoto(Photo photo) {
		this.photo = photo;
		return this;
	}

	public Integer getCount() {
		return count;
	}

	public MarketCollection setCount(Integer count) {
		this.count = count;
		return this;
	}

	public Integer getUpdatedTime() {
		return updatedTime;
	}

	public MarketCollection setUpdatedTime(Integer updatedTime) {
		this.updatedTime = updatedTime;
		return this;
	}
}
