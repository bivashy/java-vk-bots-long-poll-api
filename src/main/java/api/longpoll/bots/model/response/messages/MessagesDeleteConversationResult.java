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

        public void setLastDeletedId(Integer lastDeletedId) {
            this.lastDeletedId = lastDeletedId;
        }
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
