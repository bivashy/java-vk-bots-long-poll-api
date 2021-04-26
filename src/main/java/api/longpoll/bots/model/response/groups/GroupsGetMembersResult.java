package api.longpoll.bots.model.response.groups;

import api.longpoll.bots.adapters.deserializers.GroupsGetMemberResultDeserializer;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.User;
import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Result to <b>groups.getMembers</b> request.
 */
@JsonAdapter(GroupsGetMemberResultDeserializer.class)
public class GroupsGetMembersResult extends GenericResult<VkList<Object>> {
    /**
     * Response Item.
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


        @Override
        public String toString() {
            return "Item{" +
                    "role='" + role + '\'' +
                    "} " + super.toString();
        }
    }
}
