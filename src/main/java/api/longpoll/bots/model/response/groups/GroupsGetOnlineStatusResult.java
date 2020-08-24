package api.longpoll.bots.model.response.groups;

import com.google.gson.annotations.SerializedName;

public class GroupsGetOnlineStatusResult {
    @SerializedName("response")
    private Response response;

    public static class Response {
        @SerializedName("status")
        private String status;
        @SerializedName("minutes")
        private Integer minutes;

        public String getStatus() {
            return status;
        }

        public Response setStatus(String status) {
            this.status = status;
            return this;
        }

        public Integer getMinutes() {
            return minutes;
        }

        public Response setMinutes(Integer minutes) {
            this.minutes = minutes;
            return this;
        }
    }

    public Response getResponse() {
        return response;
    }

    public GroupsGetOnlineStatusResult setResponse(Response response) {
        this.response = response;
        return this;
    }
}
