package bots.longpoll.sdk.model.market.item;

import bots.longpoll.sdk.model.update.UpdateObject;
import com.google.gson.annotations.SerializedName;

public class MarketCommentDeleteUpdate extends UpdateObject {
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

	public MarketCommentDeleteUpdate setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public Integer getId() {
		return id;
	}

	public MarketCommentDeleteUpdate setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getUserId() {
		return userId;
	}

	public MarketCommentDeleteUpdate setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public Integer getDeleterId() {
		return deleterId;
	}

	public MarketCommentDeleteUpdate setDeleterId(Integer deleterId) {
		this.deleterId = deleterId;
		return this;
	}

	public Integer getItemId() {
		return itemId;
	}

	public MarketCommentDeleteUpdate setItemId(Integer itemId) {
		this.itemId = itemId;
		return this;
	}
}
