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
