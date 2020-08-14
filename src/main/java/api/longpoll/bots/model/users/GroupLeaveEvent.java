package api.longpoll.bots.model.users;

import api.longpoll.bots.adapters.BoolIntAdapter;
import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class GroupLeaveEvent implements EventObject {
	@SerializedName("user_id")
	private Integer userId;
	@SerializedName("self")
	@JsonAdapter(BoolIntAdapter.class)
	private Boolean self;

	public Integer getUserId() {
		return userId;
	}

	public GroupLeaveEvent setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public Boolean getSelf() {
		return self;
	}

	public GroupLeaveEvent setSelf(Boolean self) {
		this.self = self;
		return this;
	}
}
