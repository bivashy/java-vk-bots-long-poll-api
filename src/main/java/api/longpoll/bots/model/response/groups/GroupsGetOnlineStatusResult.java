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

        public void setStatus(String status) {
            this.status = status;
        }

        public Integer getMinutes() {
            return minutes;
        }

        public void setMinutes(Integer minutes) {
            this.minutes = minutes;
        }
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
