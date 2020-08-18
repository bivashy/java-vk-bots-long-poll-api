package api.longpoll.bots.model.response.messages;

import com.google.gson.annotations.SerializedName;

public class MessagesDeleteConversationResult {
    @SerializedName("response")
    private Response response;

    public static class Response {
        @SerializedName("last_deleted_id")
        private Integer lastDeletedId;

        public Integer getLastDeletedId() {
            return lastDeletedId;
        }

        public Response setLastDeletedId(Integer lastDeletedId) {
            this.lastDeletedId = lastDeletedId;
            return this;
        }
    }

    public Response getResponse() {
        return response;
    }

    public MessagesDeleteConversationResult setResponse(Response response) {
        this.response = response;
        return this;
    }
}
