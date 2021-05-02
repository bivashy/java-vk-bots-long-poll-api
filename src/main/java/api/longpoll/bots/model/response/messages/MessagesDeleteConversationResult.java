package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>messages.deleteConversation</b> request.
 */
public class MessagesDeleteConversationResult extends GenericResult<MessagesDeleteConversationResult.Response> {
    /**
     * Response object.
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

        @Override
        public String toString() {
            return "Response{" +
                    "lastDeletedId=" + lastDeletedId +
                    '}';
        }
    }
}
