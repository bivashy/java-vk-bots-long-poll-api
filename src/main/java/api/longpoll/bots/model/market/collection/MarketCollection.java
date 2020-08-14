package api.longpoll.bots.model.market.collection;

import api.longpoll.bots.model.objects.media.Attachable;
import api.longpoll.bots.model.photos.Photo;
import com.google.gson.annotations.SerializedName;

public class MarketCollection implements Attachable {
	@SerializedName("id")
	private Integer id;
	@SerializedName("owner_id")
	private Integer ownerId;
	@SerializedName("title")
	private String title;
	@SerializedName("photo")
	private Photo photo;
	@SerializedName("count")
	private Integer count;
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
