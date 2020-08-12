package bots.longpoll.sdk.model.users;

import bots.longpoll.sdk.model.update.UpdateObject;
import com.google.gson.annotations.SerializedName;

public class UserUnblockUpdate extends UpdateObject {
	@SerializedName("admin_id")
	private Integer adminId;
	@SerializedName("user_id")
	private Integer userId;
	@SerializedName("by_end_date")
	private Integer byEndDate;

	public Integer getAdminId() {
		return adminId;
	}

	public UserUnblockUpdate setAdminId(Integer adminId) {
		this.adminId = adminId;
		return this;
	}

	public Integer getUserId() {
		return userId;
	}

	public UserUnblockUpdate setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public Integer getByEndDate() {
		return byEndDate;
	}

	public UserUnblockUpdate setByEndDate(Integer byEndDate) {
		this.byEndDate = byEndDate;
		return this;
	}
}
