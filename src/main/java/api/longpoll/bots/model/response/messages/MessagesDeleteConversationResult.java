package api.longpoll.bots.model.response.messages;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>messages.deleteConversation</b> request.
 */
public class MessagesDeleteConversationResult {
    /**
     * Response object.
     */
    @SerializedName("response")
    private Response response;

    /**
     * Describes response.
     */
    public static class Response {
        /**
         * Last deleted message ID.
         */
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
