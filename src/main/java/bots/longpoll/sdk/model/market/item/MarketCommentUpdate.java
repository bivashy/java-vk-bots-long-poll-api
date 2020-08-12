package bots.longpoll.sdk.model.market.item;

import bots.longpoll.sdk.model.wall.reply.WallReply;
import com.google.gson.annotations.SerializedName;

public class MarketCommentUpdate extends WallReply {
	@SerializedName("market_owner_id")
	private Integer marketOwnerId;
	@SerializedName("item_id")
	private Integer itemId;

	public Integer getMarketOwnerId() {
		return marketOwnerId;
	}

	public MarketCommentUpdate setMarketOwnerId(Integer marketOwnerId) {
		this.marketOwnerId = marketOwnerId;
		return this;
	}

	public Integer getItemId() {
		return itemId;
	}

	public MarketCommentUpdate setItemId(Integer itemId) {
		this.itemId = itemId;
		return this;
	}
}
