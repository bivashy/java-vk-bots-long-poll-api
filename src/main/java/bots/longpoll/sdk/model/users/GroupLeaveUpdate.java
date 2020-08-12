package bots.longpoll.sdk.model.users;

import bots.longpoll.sdk.adapters.BoolIntAdapter;
import bots.longpoll.sdk.model.update.UpdateObject;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class GroupLeaveUpdate extends UpdateObject {
	@SerializedName("user_id")
	private Integer userId;
	@SerializedName("self")
	@JsonAdapter(BoolIntAdapter.class)
	private Boolean self;

	public Integer getUserId() {
		return userId;
	}

	public GroupLeaveUpdate setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public Boolean getSelf() {
		return self;
	}

	public GroupLeaveUpdate setSelf(Boolean self) {
		this.self = self;
		return this;
	}
}
