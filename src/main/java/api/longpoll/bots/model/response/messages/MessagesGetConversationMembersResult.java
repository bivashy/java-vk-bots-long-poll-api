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

        public Response setProfiles(List<User> profiles) {
            this.profiles = profiles;
            return this;
        }

        public List<Community> getGroups() {
            return groups;
        }

        public Response setGroups(List<Community> groups) {
            this.groups = groups;
            return this;
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

        public Item setMemberId(Integer memberId) {
            this.memberId = memberId;
            return this;
        }

        public Integer getInvitedBy() {
            return invitedBy;
        }

        public Item setInvitedBy(Integer invitedBy) {
            this.invitedBy = invitedBy;
            return this;
        }

        public Integer getJoinDate() {
            return joinDate;
        }

        public Item setJoinDate(Integer joinDate) {
            this.joinDate = joinDate;
            return this;
        }

        public Boolean getAdmin() {
            return admin;
        }

        public Item setAdmin(Boolean admin) {
            this.admin = admin;
            return this;
        }

        public Boolean getCanKick() {
            return canKick;
        }

        public Item setCanKick(Boolean canKick) {
            this.canKick = canKick;
            return this;
        }
    }

    public Response getResponse() {
        return response;
    }

    public MessagesGetConversationMembersResult setResponse(Response response) {
        this.response = response;
        return this;
    }
}
