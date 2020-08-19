package api.longpoll.bots.model.response.messages;

import com.google.gson.annotations.SerializedName;

public class MessagesGetInviteLinkResult {
    @SerializedName("response")
    private Response response;

    public static class Response {
        @SerializedName("link")
        private String link;

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

    public MessagesGetInviteLinkResult setResponse(Response response) {
        this.response = response;
        return this;
    }
}
