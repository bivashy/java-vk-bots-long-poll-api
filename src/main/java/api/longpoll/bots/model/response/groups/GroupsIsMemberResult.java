package api.longpoll.bots.model.response.groups;

import api.longpoll.bots.adapters.BoolIntAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class GroupsIsMemberResult {
    private Object response;

    public class Response {
        @SerializedName("member")
        @JsonAdapter(BoolIntAdapter.class)
        private Boolean member;
        @SerializedName("request")
        @JsonAdapter(BoolIntAdapter.class)
        private Boolean request;
        @SerializedName("invitation")
        @JsonAdapter(BoolIntAdapter.class)
        private Boolean invitation;
        @SerializedName("can_invite")
        @JsonAdapter(BoolIntAdapter.class)
        private Boolean canInvite;
        @SerializedName("can_recall")
        @JsonAdapter(BoolIntAdapter.class)
        private Boolean canRecall;
        @SerializedName("user_id")
        private Integer userId;

        public Boolean getMember() {
            return member;
        }

        public Response setMember(Boolean member) {
            this.member = member;
            return this;
        }

        public Boolean getRequest() {
            return request;
        }

        public Response setRequest(Boolean request) {
            this.request = request;
            return this;
        }

        public Boolean getInvitation() {
            return invitation;
        }

        public Response setInvitation(Boolean invitation) {
            this.invitation = invitation;
            return this;
        }

        public Boolean getCanInvite() {
            return canInvite;
        }

        public Response setCanInvite(Boolean canInvite) {
            this.canInvite = canInvite;
            return this;
        }

        public Boolean getCanRecall() {
            return canRecall;
        }

        public Response setCanRecall(Boolean canRecall) {
            this.canRecall = canRecall;
            return this;
        }

        public Integer getUserId() {
            return userId;
        }

        public Response setUserId(Integer userId) {
            this.userId = userId;
            return this;
        }
    }

    public Object getResponse() {
        return response;
    }

    public GroupsIsMemberResult setResponse(Object response) {
        this.response = response;
        return this;
    }
}
