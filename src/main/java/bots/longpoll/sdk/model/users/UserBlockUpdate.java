package bots.longpoll.sdk.model.users;

import bots.longpoll.sdk.model.update.UpdateObject;
import com.google.gson.annotations.SerializedName;

public class UserBlockUpdate extends UpdateObject {
	@SerializedName("admin_id")
	private Integer adminId;
	@SerializedName("user_id")
	private Integer userId;
	@SerializedName("unblock_date")
	private Integer unblockDate;
	@SerializedName("reason")
	private Integer reason;
	@SerializedName("comment")
	private Integer comment;

	public Integer getAdminId() {
		return adminId;
	}

	public UserBlockUpdate setAdminId(Integer adminId) {
		this.adminId = adminId;
		return this;
	}

	public Integer getUserId() {
		return userId;
	}

	public UserBlockUpdate setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public Integer getUnblockDate() {
		return unblockDate;
	}

	public UserBlockUpdate setUnblockDate(Integer unblockDate) {
		this.unblockDate = unblockDate;
		return this;
	}

	public Integer getReason() {
		return reason;
	}

	public UserBlockUpdate setReason(Integer reason) {
		this.reason = reason;
		return this;
	}

	public Integer getComment() {
		return comment;
	}

	public UserBlockUpdate setComment(Integer comment) {
		this.comment = comment;
		return this;
	}
}
