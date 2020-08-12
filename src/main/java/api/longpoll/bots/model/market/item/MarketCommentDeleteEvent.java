package api.longpoll.bots.model.market.item;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

public class MarketCommentDeleteEvent extends EventObject {
	@SerializedName("owner_id")
	private Integer ownerId;
	@SerializedName("id")
	private Integer id;
	@SerializedName("user_id")
	private Integer userId;
	@SerializedName("deleter_id")
	private Integer deleterId;
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
