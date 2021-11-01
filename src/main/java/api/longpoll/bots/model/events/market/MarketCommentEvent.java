package api.longpoll.bots.model.events.market;

import api.longpoll.bots.model.objects.basic.WallComment;
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

    public void setMarketOwnerId(Integer marketOwnerId) {
        this.marketOwnerId = marketOwnerId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }


    @Override
    public String toString() {
        return "MarketCommentEvent{" +
                "marketOwnerId=" + marketOwnerId +
                ", itemId=" + itemId +
                "} " + super.toString();
    }
}
