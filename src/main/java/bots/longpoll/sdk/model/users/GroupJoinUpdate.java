package bots.longpoll.sdk.model.users;

import bots.longpoll.sdk.model.update.UpdateObject;
import com.google.gson.annotations.SerializedName;

public class GroupJoinUpdate extends UpdateObject {
	@SerializedName("user_id")
	private Integer userId;
	@SerializedName("join_type")
	private String joinType;

	public Integer getUserId() {
		return userId;
	}

	public GroupJoinUpdate setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public String getJoinType() {
		return joinType;
	}

	public GroupJoinUpdate setJoinType(String joinType) {
		this.joinType = joinType;
		return this;
	}
}
