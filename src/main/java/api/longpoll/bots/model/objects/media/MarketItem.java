package api.longpoll.bots.model.objects.media;

import api.longpoll.bots.model.objects.additional.Price;
import com.google.gson.annotations.SerializedName;

/**
 * Describes market item.
 * @see <a href="https://vk.com/dev/objects/market_item">Market Item</a>
 */
public class MarketItem implements Attachable {
	/**
	 * Item ID.
	 */
	@SerializedName("id")
	private Integer id;

	/**
	 * Item owner ID.
	 */
	@SerializedName("owner_id")
	private Integer ownerId;

	/**
	 * Item title.
	 */
	@SerializedName("title")
	private String title;

	/**
	 * Item description.
	 */
	@SerializedName("description")
	private String description;

	/**
	 * Item price.
	 */
	@SerializedName("price")
	private ItemPrice price;

	/**
	 * Item category.
	 */
	@SerializedName("category")
	private Category category;

	/**
	 * URL of the item photo.
	 */
	@SerializedName("thumb_photo")
	private String thumbPhoto;

	/**
	 * Creation date in Unixtime.
	 */
	@SerializedName("date")
	private Integer date;

	/**
	 * Availability status. Possible values:
	 * <ul>
	 *     <li>0 — item is available;</li>
	 *     <li>1 — item is deleted;</li>
	 *     <li>2 — item is unavailable.</li>
	 * </ul>
	 */
	@SerializedName("availability")
	private Integer availability;

	/**
	 * <b>true</b>, if object is added to favorites by current users.
	 */
	@SerializedName("is_favorite")
	private boolean favourite;

	/**
	 * Describes item price.
	 */
	public class ItemPrice extends Price {
		/**
		 * Old price value multiplied by 100.
		 */
		@SerializedName("old_amount")
		private Integer oldAmount;

		public Integer getOldAmount() {
			return oldAmount;
		}

		public ItemPrice setOldAmount(Integer oldAmount) {
			this.oldAmount = oldAmount;
			return this;
		}
	}

	/**
	 * Describes item category.
	 */
	public class Category {
		/**
		 * Category ID.
		 */
		@SerializedName("id")
		private Integer id;

		/**
		 * Category name.
		 */
		@SerializedName("name")
		private String name;

		/**
		 * Category section.
		 */
		@SerializedName("section")
		private Section section;

		/**
		 * Describes category section.
		 */
		public class Section {
			/**
			 * Section ID.
			 */
			@SerializedName("id")
			private Integer id;

			/**
			 * Section name.
			 */
			@SerializedName("name")
			private String name;

			public Integer getId() {
				return id;
			}

			public Section setId(Integer id) {
				this.id = id;
				return this;
			}

			public String getName() {
				return name;
			}

			public Section setName(String name) {
				this.name = name;
				return this;
			}
		}

		public Integer getId() {
			return id;
		}

		public Category setId(Integer id) {
			this.id = id;
			return this;
		}

		public String getName() {
			return name;
		}

		public Category setName(String name) {
			this.name = name;
			return this;
		}

		public Section getSection() {
			return section;
		}

		public Category setSection(Section section) {
			this.section = section;
			return this;
		}
	}

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
