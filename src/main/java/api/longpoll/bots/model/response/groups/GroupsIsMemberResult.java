package api.longpoll.bots.model.response.groups;

import api.longpoll.bots.adapters.BoolIntAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class GroupsIsMemberResult {
    private Object response;

    public static class Response {
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
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
