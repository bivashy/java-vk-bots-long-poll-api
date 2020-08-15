package api.longpoll.bots.model.events.users;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

public class UserBlockEvent implements EventObject {
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

	public UserBlockEvent setAdminId(Integer adminId) {
		this.adminId = adminId;
		return this;
	}

	public Integer getUserId() {
		return userId;
	}

	public UserBlockEvent setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public Integer getUnblockDate() {
		return unblockDate;
	}

	public UserBlockEvent setUnblockDate(Integer unblockDate) {
		this.unblockDate = unblockDate;
		return this;
	}

	public Integer getReason() {
		return reason;
	}

	public UserBlockEvent setReason(Integer reason) {
		this.reason = reason;
		return this;
	}

	public Integer getComment() {
		return comment;
	}

	public UserBlockEvent setComment(Integer comment) {
		this.comment = comment;
		return this;
	}
}
