package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.Community;
import api.longpoll.bots.model.objects.basic.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MessagesGetConversationMembersResult {
    @SerializedName("response")
    private Response response;

    public static class Response extends VkList<Item> {
        @SerializedName("profiles")
        private List<User> profiles;
        @SerializedName("groups")
        private List<Community> groups;

        public List<User> getProfiles() {
            return profiles;
        }

        public void setProfiles(List<User> profiles) {
            this.profiles = profiles;
        }

        public List<Community> getGroups() {
            return groups;
        }

        public void setGroups(List<Community> groups) {
            this.groups = groups;
        }
    }

    public static class Item {
        @SerializedName("member_id")
        private Integer memberId;
        @SerializedName("invited_by")
        private Integer invitedBy;
        @SerializedName("join_date")
        private Integer joinDate;
        @SerializedName("is_admin")
        private Boolean admin;
        @SerializedName("can_kick")
        private Boolean canKick;

        public Integer getMemberId() {
            return memberId;
        }

        public void setMemberId(Integer memberId) {
            this.memberId = memberId;
        }

        public Integer getInvitedBy() {
            return invitedBy;
        }

        public void setInvitedBy(Integer invitedBy) {
            this.invitedBy = invitedBy;
        }

        public Integer getJoinDate() {
            return joinDate;
        }

        public void setJoinDate(Integer joinDate) {
            this.joinDate = joinDate;
        }

        public Boolean getAdmin() {
            return admin;
        }

        public void setAdmin(Boolean admin) {
            this.admin = admin;
        }

        public Boolean getCanKick() {
            return canKick;
        }

        public void setCanKick(Boolean canKick) {
            this.canKick = canKick;
        }
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
