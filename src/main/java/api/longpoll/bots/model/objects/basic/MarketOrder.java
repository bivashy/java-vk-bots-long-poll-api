package api.longpoll.bots.model.objects.basic;

import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.objects.additional.Price;
import api.longpoll.bots.model.objects.media.MarketItem;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Describes <b>market_order_new</b> and <b>market_order_edit</b> event objects.
 *
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
    public static class PropertyValue {
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

        public void setVariantId(Integer variantId) {
            this.variantId = variantId;
        }

        public String getVariantName() {
            return variantName;
        }

        public void setVariantName(String variantName) {
            this.variantName = variantName;
        }

        public String getPropertyName() {
            return propertyName;
        }

        public void setPropertyName(String propertyName) {
            this.propertyName = propertyName;
        }

        @Override
        public String toString() {
            return "PropertyValue{" +
                    "variantId=" + variantId +
                    ", variantName='" + variantName + '\'' +
                    ", propertyName='" + propertyName + '\'' +
                    '}';
        }
    }

    /**
     * Describes delivery info.
     */
    public static class Delivery {
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

        @SerializedName("delivery_point")
        private Map<String, Object> deliveryPoint;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTrackNumber() {
            return trackNumber;
        }

        public void setTrackNumber(String trackNumber) {
            this.trackNumber = trackNumber;
        }

        public String getTrackLink() {
            return trackLink;
        }

        public void setTrackLink(String trackLink) {
            this.trackLink = trackLink;
        }


        public Map<String, Object> getDeliveryPoint() {
            return deliveryPoint;
        }

        public void setDeliveryPoint(Map<String, Object> deliveryPoint) {
            this.deliveryPoint = deliveryPoint;
        }


        @Override
        public String toString() {
            return "Delivery{" +
                    "address='" + address + '\'' +
                    ", type='" + type + '\'' +
                    ", trackNumber='" + trackNumber + '\'' +
                    ", trackLink='" + trackLink + '\'' +
                    ", deliveryPoint=" + deliveryPoint +
                    '}';
        }
    }

    /**
     * Describes recipient info.
     */
    public static class Recipient {
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

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getDisplay_text() {
            return display_text;
        }

        public void setDisplay_text(String display_text) {
            this.display_text = display_text;
        }

        @Override
        public String toString() {
            return "Recipient{" +
                    "name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    ", display_text='" + display_text + '\'' +
                    '}';
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getVariantsGroupingId() {
        return variantsGroupingId;
    }

    public void setVariantsGroupingId(Integer variantsGroupingId) {
        this.variantsGroupingId = variantsGroupingId;
    }

    public Boolean getMainVariant() {
        return mainVariant;
    }

    public void setMainVariant(Boolean mainVariant) {
        this.mainVariant = mainVariant;
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(List<PropertyValue> propertyValues) {
        this.propertyValues = propertyValues;
    }

    public Integer getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(Integer cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(Integer itemsCount) {
        this.itemsCount = itemsCount;
    }

    public Price getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Price totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDisplayOrderId() {
        return displayOrderId;
    }

    public void setDisplayOrderId(String displayOrderId) {
        this.displayOrderId = displayOrderId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<MarketItem> getPreviewOrderItems() {
        return previewOrderItems;
    }

    public void setPreviewOrderItems(List<MarketItem> previewOrderItems) {
        this.previewOrderItems = previewOrderItems;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    @Override
    public String toString() {
        return "MarketOrder{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", userId=" + userId +
                ", date=" + date +
                ", variantsGroupingId=" + variantsGroupingId +
                ", mainVariant=" + mainVariant +
                ", propertyValues=" + propertyValues +
                ", cartQuantity=" + cartQuantity +
                ", status=" + status +
                ", itemsCount=" + itemsCount +
                ", totalPrice=" + totalPrice +
                ", displayOrderId='" + displayOrderId + '\'' +
                ", comment='" + comment + '\'' +
                ", previewOrderItems=" + previewOrderItems +
                ", delivery=" + delivery +
                ", recipient=" + recipient +
                '}';
    }
}
