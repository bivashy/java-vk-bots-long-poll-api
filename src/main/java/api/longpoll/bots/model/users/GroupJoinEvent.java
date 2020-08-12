package api.longpoll.bots.model.users;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

public class GroupJoinEvent extends EventObject {
	@SerializedName("user_id")
	private Integer userId;
	@SerializedName("join_type")
	private String joinType;

	public Integer getUserId() {
		return userId;
	}

	public GroupJoinEvent setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public String getJoinType() {
		return joinType;
	}

	public GroupJoinEvent setJoinType(String joinType) {
		this.joinType = joinType;
		return this;
	}
}
