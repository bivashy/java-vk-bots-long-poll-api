package api.longpoll.bots.model.market.item;

import api.longpoll.bots.model.attachment.MediaObject;
import api.longpoll.bots.model.market.item.category.Category;
import com.google.gson.annotations.SerializedName;

public class MarketItem extends MediaObject {
	@SerializedName("id")
	private Integer id;
	@SerializedName("owner_id")
	private Integer ownerId;
	@SerializedName("title")
	private String title;
	@SerializedName("description")
	private String description;
	@SerializedName("price")
	private ItemPrice price;
	@SerializedName("category")
	private Category category;
	@SerializedName("thumb_photo")
	private String thumbPhoto;
	@SerializedName("date")
	private Integer date;
	@SerializedName("availability")
	private Integer availability;
	@SerializedName("is_favorite")
	private boolean favourite;

	public Integer getId() {
		return id;
	}

	public MarketItem setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public MarketItem setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public MarketItem setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public MarketItem setDescription(String description) {
		this.description = description;
		return this;
	}

	public ItemPrice getPrice() {
		return price;
	}

	public MarketItem setPrice(ItemPrice price) {
		this.price = price;
		return this;
	}

	public Category getCategory() {
		return category;
	}

	public MarketItem setCategory(Category category) {
		this.category = category;
		return this;
	}

	public String getThumbPhoto() {
		return thumbPhoto;
	}

	public MarketItem setThumbPhoto(String thumbPhoto) {
		this.thumbPhoto = thumbPhoto;
		return this;
	}

	public Integer getDate() {
		return date;
	}

	public MarketItem setDate(Integer date) {
		this.date = date;
		return this;
	}

	public Integer getAvailability() {
		return availability;
	}

	public MarketItem setAvailability(Integer availability) {
		this.availability = availability;
		return this;
	}

	public boolean isFavourite() {
		return favourite;
	}

	public MarketItem setFavourite(boolean favourite) {
		this.favourite = favourite;
		return this;
	}
}
