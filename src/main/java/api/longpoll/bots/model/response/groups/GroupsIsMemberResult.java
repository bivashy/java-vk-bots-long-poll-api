package api.longpoll.bots.model.response.groups;

import api.longpoll.bots.adapters.deserializers.BoolIntDeserializer;
import api.longpoll.bots.adapters.deserializers.GroupsIsMemberResultDeserializer;
import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>groups.isMember</b> request.
 */
@JsonAdapter(GroupsIsMemberResultDeserializer.class)
public class GroupsIsMemberResult extends GenericResult<Object> {
    /**
     * Response object.
     */
    public static class Response {
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
            return "Response{" +
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
