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

	public MarketCommentDeleteEvent setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public Integer getId() {
		return id;
	}

	public MarketCommentDeleteEvent setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getUserId() {
		return userId;
	}

	public MarketCommentDeleteEvent setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public Integer getDeleterId() {
		return deleterId;
	}

	public MarketCommentDeleteEvent setDeleterId(Integer deleterId) {
		this.deleterId = deleterId;
		return this;
	}

	public Integer getItemId() {
		return itemId;
	}

	public MarketCommentDeleteEvent setItemId(Integer itemId) {
		this.itemId = itemId;
		return this;
	}
}
