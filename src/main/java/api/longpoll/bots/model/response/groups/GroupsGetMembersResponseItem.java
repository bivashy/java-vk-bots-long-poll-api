package api.longpoll.bots.model.response.groups;

import api.longpoll.bots.model.objects.basic.User;
import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>groups.getMembers</b> request.
 */
public class GroupsGetMembersResponseItem extends User {
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
        return "GroupsGetMembersResponseItem{" +
                "role='" + role + '\'' +
                "} " + super.toString();
    }
}
