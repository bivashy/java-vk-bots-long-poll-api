package api.longpoll.bots.model.response.groups;

import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>groups.getOnlineStatus</b> request.
 */
public class GroupsGetOnlineStatusResult extends GenericResult<GroupsGetOnlineStatusResult.Response> {
    /**
     * Response object.
     */
    public static class Response {
        /**
         * Community's status.
         */
        @SerializedName("status")
        private String status;

        /**
         * Estimated time in minutes (for status = answer_mark).
         */
        @SerializedName("minutes")
        private Integer minutes;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Integer getMinutes() {
            return minutes;
        }

        public void setMinutes(Integer minutes) {
            this.minutes = minutes;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "status='" + status + '\'' +
                    ", minutes=" + minutes +
                    '}';
        }
    }
}
