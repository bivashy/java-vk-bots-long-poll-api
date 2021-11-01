package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.Community;
import api.longpoll.bots.model.objects.basic.User;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>groups.getBanned</b> method.
 * <p>
 * Returns a list of users on a community blacklist.
 *
 * @see <a href="https://vk.com/dev/groups.getBanned">https://vk.com/dev/groups.getBanned</a>
 */
public class GetBanned extends AuthorizedVkApiMethod<GetBanned.Response> {

    public GetBanned(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("groups.getBanned");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetBanned setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public GetBanned setOffset(int offset) {
        return addParam("offset", offset);
    }

    public GetBanned setCount(int count) {
        return addParam("count", count);
    }

    public GetBanned setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetBanned setFields(List<String> fields) {
        return addParam("fields", fields);
    }

    public GetBanned setOwnerId(int ownerId) {
        return addParam("owner_id", ownerId);
    }

    @Override
    public GetBanned addParam(String key, Object value) {
        return (GetBanned) super.addParam(key, value);
    }

    /**
     * Response to <b>groups.getBanned</b> request.
     */
    public static class Response extends GenericResponse<VkList<Response.Item>> {
        /**
         * Response item.
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

                @Override
                public String toString() {
                    return "BanInfo{" +
                            "adminId=" + adminId +
                            ", date=" + date +
                            ", reason=" + reason +
                            ", comment='" + comment + '\'' +
                            ", endDate=" + endDate +
                            '}';
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

            @Override
            public String toString() {
                return "Item{" +
                        "type='" + type + '\'' +
                        ", group=" + group +
                        ", profile=" + profile +
                        ", banInfo=" + banInfo +
                        '}';
            }
        }
    }
}
