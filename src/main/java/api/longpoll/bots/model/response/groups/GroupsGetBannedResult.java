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

			public BanInfo setAdminId(Integer adminId) {
				this.adminId = adminId;
				return this;
			}

			public Integer getDate() {
				return date;
			}

			public BanInfo setDate(Integer date) {
				this.date = date;
				return this;
			}

			public Integer getReason() {
				return reason;
			}

			public BanInfo setReason(Integer reason) {
				this.reason = reason;
				return this;
			}

			public String getComment() {
				return comment;
			}

			public BanInfo setComment(String comment) {
				this.comment = comment;
				return this;
			}

			public Integer getEndDate() {
				return endDate;
			}

			public BanInfo setEndDate(Integer endDate) {
				this.endDate = endDate;
				return this;
			}
		}

		public String getType() {
			return type;
		}

		public Item setType(String type) {
			this.type = type;
			return this;
		}

		public Community getGroup() {
			return group;
		}

		public Item setGroup(Community group) {
			this.group = group;
			return this;
		}

		public User getProfile() {
			return profile;
		}

		public Item setProfile(User profile) {
			this.profile = profile;
			return this;
		}

		public BanInfo getBanInfo() {
			return banInfo;
		}

		public Item setBanInfo(BanInfo banInfo) {
			this.banInfo = banInfo;
			return this;
		}
	}

	public VkList<Item> getResponse() {
		return response;
	}

	public GroupsGetBannedResult setResponse(VkList<Item> response) {
		this.response = response;
		return this;
	}
}
