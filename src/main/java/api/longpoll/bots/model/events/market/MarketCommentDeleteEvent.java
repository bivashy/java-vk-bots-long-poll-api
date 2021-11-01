package api.longpoll.bots.model.events.market;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>market_comment_delete</b> event objects.
 */
public class MarketCommentDeleteEvent implements EventObject {
    /**
     * Market owner ID.
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Comment ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Comment author ID.
     */
    @SerializedName("user_id")
    private Integer userId;

    /**
     * ID of the user who deleted a comment.
     */
    @SerializedName("deleter_id")
    private Integer deleterId;

    /**
     * Market item ID.
     */
    @SerializedName("item_id")
    private Integer itemId;

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDeleterId() {
        return deleterId;
    }

    public void setDeleterId(Integer deleterId) {
        this.deleterId = deleterId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "MarketCommentDeleteEvent{" +
                "ownerId=" + ownerId +
                ", id=" + id +
                ", userId=" + userId +
                ", deleterId=" + deleterId +
                ", itemId=" + itemId +
                '}';
    }
}
