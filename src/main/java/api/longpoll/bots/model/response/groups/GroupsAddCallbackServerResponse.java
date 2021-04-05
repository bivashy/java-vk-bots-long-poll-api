package api.longpoll.bots.model.response.groups;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>groups.addCallbackServer</b> request.
 */
public class GroupsAddCallbackServerResponse {
    /**
     * Server ID.
     */
    @SerializedName("server_id")
    private Integer serverId;

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    @Override
    public String toString() {
        return "GroupsAddCallbackServerResponse{" +
                "serverId=" + serverId +
                '}';
    }
}
