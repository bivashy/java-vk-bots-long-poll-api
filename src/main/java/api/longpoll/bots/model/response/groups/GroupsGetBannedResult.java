package api.longpoll.bots.model.response.groups;

import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.Community;
import api.longpoll.bots.model.objects.basic.User;
import com.google.gson.annotations.SerializedName;

public class GroupsGetBannedResult {
	@SerializedName("response")
	private VkList<Item> response;

	public static class Item {
		@SerializedName("type")
		private String type;
		@SerializedName("group")
		private Community group;
		@SerializedName("profile")
		private User profile;
		@SerializedName("ban_info")
		private BanInfo banInfo;

		public static class BanInfo {
			@SerializedName("admin_id")
			private Integer adminId;
			@SerializedName("date")
			private Integer date;
			@SerializedName("reason")
			private Integer reason;
			@SerializedName("comment")
			private String comment;
			@SerializedName("end_date")
			private Integer endDate;

			public Integer getAdminId() {
				return adminId;
			}

			public void setAdminId(Integer adminId) {
				this.adminId = adminId;
			}

			public Integer getDate() {
				return date;
			}

			public void setDate(Integer date) {
				this.date = date;
			}

			public Integer getReason() {
				return reason;
			}

			public void setReason(Integer reason) {
				this.reason = reason;
			}

			public String getComment() {
				return comment;
			}

			public void setComment(String comment) {
				this.comment = comment;
			}

			public Integer getEndDate() {
				return endDate;
			}

			public void setEndDate(Integer endDate) {
				this.endDate = endDate;
			}
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Community getGroup() {
			return group;
		}

		public void setGroup(Community group) {
			this.group = group;
		}

		public User getProfile() {
			return profile;
		}

		public void setProfile(User profile) {
			this.profile = profile;
		}

		public BanInfo getBanInfo() {
			return banInfo;
		}

		public void setBanInfo(BanInfo banInfo) {
			this.banInfo = banInfo;
		}
	}

	public VkList<Item> getResponse() {
		return response;
	}

	public void setResponse(VkList<Item> response) {
		this.response = response;
	}
}
