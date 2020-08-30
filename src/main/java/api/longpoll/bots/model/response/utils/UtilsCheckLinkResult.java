package api.longpoll.bots.model.response.utils;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>utils.checkLink</b> request.
 */
public class UtilsCheckLinkResult {
    /**
     * Response object.
     */
    @SerializedName("response")
    private Response response;

    /**
     * describes response.
     */
    public static class Response {
        /**
         * Status.
         */
        @SerializedName("status")
        private String status;

        /**
         * Input link.
         */
        @SerializedName("link")
        private String link;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
