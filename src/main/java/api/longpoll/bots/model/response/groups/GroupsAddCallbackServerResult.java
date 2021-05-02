package api.longpoll.bots.model.response.groups;

import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>groups.addCallbackServer</b> request.
 */
public class GroupsAddCallbackServerResult extends GenericResult<GroupsAddCallbackServerResult.Response> {
    /**
     * Response object.
     */
    public static class Response {
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
            return "Response{" +
                    "serverId=" + serverId +
                    '}';
        }
    }
}
