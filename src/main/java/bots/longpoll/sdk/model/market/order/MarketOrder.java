package bots.longpoll.sdk.model.market.order;

import bots.longpoll.sdk.model.link.product.Price;
import bots.longpoll.sdk.model.market.item.MarketItem;
import bots.longpoll.sdk.model.update.UpdateObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MarketOrder extends UpdateObject {
	@SerializedName("id")
	private Integer id;
	@SerializedName("group_id")
	private Integer groupId;
	@SerializedName("user_id")
	private Integer userId;
	@SerializedName("date")
	private Integer date;
	@SerializedName("variants_grouping_id")
	private Integer variantsGroupingId;
	@SerializedName("is_main_variant")
	private Boolean mainVariant;
	@SerializedName("property_values")
	private List<PropertyValue> propertyValues;
	@SerializedName("cart_quantity")
	private Integer cartQuantity;
	@SerializedName("status")
	private Integer status;
	@SerializedName("items_count")
	private Integer itemsCount;
	@SerializedName("total_price")
	private Price totalPrice;
	@SerializedName("display_order_id")
	private String displayOrderId;
	@SerializedName("comment")
	private String comment;
	@SerializedName("preview_order_items")
	private List<MarketItem> previewOrderItems;
	@SerializedName("delivery")
	private Delivery delivery;
	@SerializedName("recipient")
	private Recipient recipient;


}
