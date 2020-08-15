package api.longpoll.bots.model.events.market;

import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.objects.media.MarketItem;
import api.longpoll.bots.model.objects.additional.Price;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Describes <b>market_order_new</b> and <b>market_order_edit</b> event objects.
 * @see <a href="https://vk.com/dev/objects/market_order">Market Order</a>
 */
public class MarketOrder implements EventObject {
	/**
	 * Order ID.
	 */
	@SerializedName("id")
	private Integer id;

	/**
	 * Order group ID.
	 */
	@SerializedName("group_id")
	private Integer groupId;

	/**
	 * Customer ID.
	 */
	@SerializedName("user_id")
	private Integer userId;

	/**
	 * Order creation date in Unixtime.
	 */
	@SerializedName("date")
	private Integer date;

	/**
	 * Variants grouping ID.
	 */
	@SerializedName("variants_grouping_id")
	private Integer variantsGroupingId;

	/**
	 * <b>true</b>, if variant is main.
	 */
	@SerializedName("is_main_variant")
	private Boolean mainVariant;

	/**
	 * Order properties.
	 */
	@SerializedName("property_values")
	private List<PropertyValue> propertyValues;

	/**
	 * Cart quantity.
	 */
	@SerializedName("cart_quantity")
	private Integer cartQuantity;

	/**
	 * Order status. Possible values:
	 * <ul>
	 *     <li>0 - new;</li>
	 *     <li>1 - approving;</li>
	 *     <li>2 - packaging</li>
	 *     <li>3 - delivering;</li>
	 *     <li>4 - delivered;</li>
	 *     <li>5 - canceled;</li>
	 *     <li>6 - returned.</li>
	 * </ul>
	 */
	@SerializedName("status")
	private Integer status;

	/**
	 * Order items count.
	 */
	@SerializedName("items_count")
	private Integer itemsCount;

	/**
	 * Order total price.
	 */
	@SerializedName("total_price")
	private Price totalPrice;

	/**
	 * Unique ID consisting of Customer ID and Order ID.
	 */
	@SerializedName("display_order_id")
	private String displayOrderId;

	/**
	 * Order comment.
	 */
	@SerializedName("comment")
	private String comment;

	/**
	 * Order items.
	 */
	@SerializedName("preview_order_items")
	private List<MarketItem> previewOrderItems;

	/**
	 * Delivery info.
	 */
	@SerializedName("delivery")
	private Delivery delivery;

	/**
	 * Recipient info.
	 */
	@SerializedName("recipient")
	private Recipient recipient;

	/**
	 * Describes order property.
	 */
	public class PropertyValue {
		/**
		 * Variant ID.
		 */
		@SerializedName("variant_id")
		private Integer variantId;

		/**
		 * Variant name.
		 */
		@SerializedName("variant_name")
		private String variantName;

		/**
		 * Property name.
		 */
		@SerializedName("property_name")
		private String propertyName;

		public Integer getVariantId() {
			return variantId;
		}

		public PropertyValue setVariantId(Integer variantId) {
			this.variantId = variantId;
			return this;
		}

		public String getVariantName() {
			return variantName;
		}

		public PropertyValue setVariantName(String variantName) {
			this.variantName = variantName;
			return this;
		}

		public String getPropertyName() {
			return propertyName;
		}

		public PropertyValue setPropertyName(String propertyName) {
			this.propertyName = propertyName;
			return this;
		}
	}

	/**
	 * Describes delivery info.
	 */
	public class Delivery {
		/**
		 * Delivery address.
		 */
		@SerializedName("address")
		private String address;

		/**
		 * Delivery type.
		 */
		@SerializedName("type")
		private String type;

		/**
		 * Track number for order tracking.
		 */
		@SerializedName("track_number")
		private String trackNumber;

		/**
		 * Link for tracking the order by track number.
		 */
		@SerializedName("track_link")
		private String trackLink;

		public String getAddress() {
			return address;
		}

		public Delivery setAddress(String address) {
			this.address = address;
			return this;
		}

		public String getType() {
			return type;
		}

		public Delivery setType(String type) {
			this.type = type;
			return this;
		}

		public String getTrackNumber() {
			return trackNumber;
		}

		public Delivery setTrackNumber(String trackNumber) {
			this.trackNumber = trackNumber;
			return this;
		}

		public String getTrackLink() {
			return trackLink;
		}

		public Delivery setTrackLink(String trackLink) {
			this.trackLink = trackLink;
			return this;
		}
	}

	/**
	 * Describes recipient info.
	 */
	public class Recipient {
		/**
		 * Recipient name.
		 */
		@SerializedName("name")
		private String name;

		/**
		 * Recipient phone number.
		 */
		@SerializedName("phone")
		private String phone;

		/**
		 * String representation of customer information.
		 */
		@SerializedName("display_text")
		private String display_text;

		public String getName() {
			return name;
		}

		public Recipient setName(String name) {
			this.name = name;
			return this;
		}

		public String getPhone() {
			return phone;
		}

		public Recipient setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public String getDisplay_text() {
			return display_text;
		}

		public Recipient setDisplay_text(String display_text) {
			this.display_text = display_text;
			return this;
		}
	}

	public Integer getId() {
		return id;
	}

	public MarketOrder setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public MarketOrder setGroupId(Integer groupId) {
		this.groupId = groupId;
		return this;
	}

	public Integer getUserId() {
		return userId;
	}

	public MarketOrder setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public Integer getDate() {
		return date;
	}

	public MarketOrder setDate(Integer date) {
		this.date = date;
		return this;
	}

	public Integer getVariantsGroupingId() {
		return variantsGroupingId;
	}

	public MarketOrder setVariantsGroupingId(Integer variantsGroupingId) {
		this.variantsGroupingId = variantsGroupingId;
		return this;
	}

	public Boolean getMainVariant() {
		return mainVariant;
	}

	public MarketOrder setMainVariant(Boolean mainVariant) {
		this.mainVariant = mainVariant;
		return this;
	}

	public List<PropertyValue> getPropertyValues() {
		return propertyValues;
	}

	public MarketOrder setPropertyValues(List<PropertyValue> propertyValues) {
		this.propertyValues = propertyValues;
		return this;
	}

	public Integer getCartQuantity() {
		return cartQuantity;
	}

	public MarketOrder setCartQuantity(Integer cartQuantity) {
		this.cartQuantity = cartQuantity;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public MarketOrder setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Integer getItemsCount() {
		return itemsCount;
	}

	public MarketOrder setItemsCount(Integer itemsCount) {
		this.itemsCount = itemsCount;
		return this;
	}

	public Price getTotalPrice() {
		return totalPrice;
	}

	public MarketOrder setTotalPrice(Price totalPrice) {
		this.totalPrice = totalPrice;
		return this;
	}

	public String getDisplayOrderId() {
		return displayOrderId;
	}

	public MarketOrder setDisplayOrderId(String displayOrderId) {
		this.displayOrderId = displayOrderId;
		return this;
	}

	public String getComment() {
		return comment;
	}

	public MarketOrder setComment(String comment) {
		this.comment = comment;
		return this;
	}

	public List<MarketItem> getPreviewOrderItems() {
		return previewOrderItems;
	}

	public MarketOrder setPreviewOrderItems(List<MarketItem> previewOrderItems) {
		this.previewOrderItems = previewOrderItems;
		return this;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public MarketOrder setDelivery(Delivery delivery) {
		this.delivery = delivery;
		return this;
	}

	public Recipient getRecipient() {
		return recipient;
	}

	public MarketOrder setRecipient(Recipient recipient) {
		this.recipient = recipient;
		return this;
	}
}
