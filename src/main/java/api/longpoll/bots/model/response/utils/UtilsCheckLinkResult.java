package api.longpoll.bots.model.response.utils;

import com.google.gson.annotations.SerializedName;

public class UtilsCheckLinkResult {
    @SerializedName("response")
    private Response response;

    public static class Response {
        @SerializedName("status")
        private String status;
        @SerializedName("link")
        private String link;

        public String getStatus() {
            return status;
        }

        public Response setStatus(String status) {
            this.status = status;
            return this;
        }

        public String getLink() {
            return link;
        }

        public Response setLink(String link) {
            this.link = link;
            return this;
        }
    }

    public Response getResponse() {
        return response;
    }

    public UtilsCheckLinkResult setResponse(Response response) {
        this.response = response;
        return this;
    }
}
