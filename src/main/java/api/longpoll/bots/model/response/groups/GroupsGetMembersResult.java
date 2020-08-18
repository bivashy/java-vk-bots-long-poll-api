package api.longpoll.bots.model.response.groups;

import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.User;
import com.google.gson.annotations.SerializedName;

public class GroupsGetMembersResult {
    @SerializedName("response")
    private VkList<Object> response;

    public static class Item extends User {
        @SerializedName("role")
        private String role;

        public String getRole() {
            return role;
        }

        public Item setRole(String role) {
            this.role = role;
            return this;
        }
    }

    public VkList<Object> getResponse() {
        return response;
    }

    public GroupsGetMembersResult setResponse(VkList<Object> response) {
        this.response = response;
        return this;
    }
}
