package api.longpoll.bots.model.users;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

public class UserUnblockEvent implements EventObject {
	@SerializedName("admin_id")
	private Integer adminId;
	@SerializedName("user_id")
	private Integer userId;
	@SerializedName("by_end_date")
	private Integer byEndDate;

	public Integer getAdminId() {
		return adminId;
	}

	public UserUnblockEvent setAdminId(Integer adminId) {
		this.adminId = adminId;
		return this;
	}

	public Integer getUserId() {
		return userId;
	}

	public UserUnblockEvent setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public Integer getByEndDate() {
		return byEndDate;
	}

	public UserUnblockEvent setByEndDate(Integer byEndDate) {
		this.byEndDate = byEndDate;
		return this;
	}
}
