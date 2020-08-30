package api.longpoll.bots.model.response.messages;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>messages.getInviteLink</b> request.
 */
public class MessagesGetInviteLinkResult {
    /**
     * Response object.
     */
    @SerializedName("response")
    private Response response;

    /**
     * Describes response object.
     */
    public static class Response {
        /**
         * Link for inviting.
         */
        @SerializedName("link")
        private String link;

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
