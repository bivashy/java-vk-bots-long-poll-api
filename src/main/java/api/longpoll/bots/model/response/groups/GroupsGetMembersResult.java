package api.longpoll.bots.model.response.groups;

import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.User;
import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>groups.getMembers</b> request.
 */
public class GroupsGetMembersResult {
    /**
     * Response object.
     */
    @SerializedName("response")
    private VkList<Object> response;

    /**
     * Describes VkList item.
     */
    public static class Item extends User {
        /**
         * Group role.
         */
        @SerializedName("role")
        private String role;

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }

    public VkList<Object> getResponse() {
        return response;
    }

    public void setResponse(VkList<Object> response) {
        this.response = response;
    }
}
