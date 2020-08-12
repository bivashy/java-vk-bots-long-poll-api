package api.longpoll.bots.model.market.item;

import api.longpoll.bots.model.wall.reply.WallReply;
import com.google.gson.annotations.SerializedName;

public class MarketCommentEvent extends WallReply {
	@SerializedName("market_owner_id")
	private Integer marketOwnerId;
	@SerializedName("item_id")
	private Integer itemId;

	public Integer getMarketOwnerId() {
		return marketOwnerId;
	}

	public MarketCommentEvent setMarketOwnerId(Integer marketOwnerId) {
		this.marketOwnerId = marketOwnerId;
		return this;
	}

	public Integer getItemId() {
		return itemId;
	}

	public MarketCommentEvent setItemId(Integer itemId) {
		this.itemId = itemId;
		return this;
	}
}
