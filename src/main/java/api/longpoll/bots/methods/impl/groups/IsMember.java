package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.adapters.deserializers.BoolIntDeserializer;
import api.longpoll.bots.adapters.deserializers.GroupsIsMemberResponseDeserializer;
import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>groups.isMember</b> method.
 * <p>
 * Returns information specifying whether a user is a member of a community.
 *
 * @see <a href="https://vk.com/dev/groups.isMember">https://vk.com/dev/groups.isMember</a>
 */
public class IsMember extends AuthorizedVkApiMethod<IsMember.Response> {
    public IsMember(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("groups.isMember");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public IsMember setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public IsMember setUserId(int userId) {
        return addParam("user_id", userId);
    }

    public IsMember setUserIds(Integer... userIds) {
        return setUserIds(Arrays.asList(userIds));
    }

    public IsMember setUserIds(List<Integer> userIds) {
        return addParam("user_ids", userIds);
    }

    public IsMember setExtended(boolean extended) {
        return addParam("extended", new BoolInt(extended));
    }

    @Override
    public IsMember addParam(String key, Object value) {
        return (IsMember) super.addParam(key, value);
    }

    /**
     * Response to <b>groups.isMember</b> request.
     */
    @JsonAdapter(GroupsIsMemberResponseDeserializer.class)
    public static class Response extends GenericResponse<Object> {
        /**
         * Response object.
         */
        public static class ResponseObject {
            /**
             * Whether the user is a member of the community.
             */
            @SerializedName("member")
            @JsonAdapter(BoolIntDeserializer.class)
            private Boolean member;

            /**
             * Whether the user left a request to join the group, which can be declined by the groups.leave method.
             */
            @SerializedName("request")
            @JsonAdapter(BoolIntDeserializer.class)
            private Boolean request;

            /**
             * Whether the user is invited to join the group or event.
             */
            @SerializedName("invitation")
            @JsonAdapter(BoolIntDeserializer.class)
            private Boolean invitation;

            /**
             * Whether user can invite others.
             */
            @SerializedName("can_invite")
            @JsonAdapter(BoolIntDeserializer.class)
            private Boolean canInvite;

            /**
             * Whether user can deny invitation.
             */
            @SerializedName("can_recall")
            @JsonAdapter(BoolIntDeserializer.class)
            private Boolean canRecall;

            /**
             * User ID.
             */
            @SerializedName("user_id")
            private Integer userId;

            public Boolean getMember() {
                return member;
            }

            public void setMember(Boolean member) {
                this.member = member;
            }

            public Boolean getRequest() {
                return request;
            }

            public void setRequest(Boolean request) {
                this.request = request;
            }

            public Boolean getInvitation() {
                return invitation;
            }

            public void setInvitation(Boolean invitation) {
                this.invitation = invitation;
            }

            public Boolean getCanInvite() {
                return canInvite;
            }

            public void setCanInvite(Boolean canInvite) {
                this.canInvite = canInvite;
            }

            public Boolean getCanRecall() {
                return canRecall;
            }

            public void setCanRecall(Boolean canRecall) {
                this.canRecall = canRecall;
            }

            public Integer getUserId() {
                return userId;
            }

            public void setUserId(Integer userId) {
                this.userId = userId;
            }

            @Override
            public String toString() {
                return "ResponseObject{" +
                        "member=" + member +
                        ", request=" + request +
                        ", invitation=" + invitation +
                        ", canInvite=" + canInvite +
                        ", canRecall=" + canRecall +
                        ", userId=" + userId +
                        '}';
            }
        }
    }
}
