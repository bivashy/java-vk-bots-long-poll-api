package api.longpoll.bots.model.events.market;

import api.longpoll.bots.model.wall.reply.WallComment;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>market_comment_new</b>, <b>market_comment_edit</b> and <b>market_comment_restore</b> event objects.
 */
public class MarketCommentEvent extends WallComment {
	/**
	 * Market owner ID.
	 */
	@SerializedName("market_owner_id")
	private Integer marketOwnerId;

	/**
	 * Market item ID.
	 */
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
