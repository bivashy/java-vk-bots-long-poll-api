package api.longpoll.bots.model.response.groups;

import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.Community;
import api.longpoll.bots.model.objects.basic.User;
import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>groups.getBanned</b> requst.
 */
public class GroupsGetBannedResult {
    /**
     * Response object.
     */
    @SerializedName("response")
    private VkList<Item> response;

    /**
     * Describes VkList item.
     */
    public static class Item {
        /**
         * Type.
         */
        @SerializedName("type")
        private String type;

        /**
         * Community information (for type = group).
         */
        @SerializedName("group")
        private Community group;

        /**
         * User information (for type = profile).
         */
        @SerializedName("profile")
        private User profile;

        /**
         * Information about ban.
         */
        @SerializedName("ban_info")
        private BanInfo banInfo;

        /**
         * Describes ban information.
         */
        public static class BanInfo {
            /**
             * Administrator ID.
             */
            @SerializedName("admin_id")
            private Integer adminId;

            /**
             * Date in Unixtime when the user or community had been added to the blacklist.
             */
            @SerializedName("date")
            private Integer date;

            /**
             * Reason for ban.
             */
            @SerializedName("reason")
            private Integer reason;

            /**
             * Comment text.
             */
            @SerializedName("comment")
            private String comment;

            /**
             * Expired date for the ban (0 — forever).
             */
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
