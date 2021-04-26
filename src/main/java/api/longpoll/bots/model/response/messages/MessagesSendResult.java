package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.adapters.deserializers.MessagesSendResultDeserializer;
import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Result to <b>messages.send</b> request.
 */
@JsonAdapter(MessagesSendResultDeserializer.class)
public class MessagesSendResult extends GenericResult<Object> {
    /**
     * Response object.
     */
    public static class Response {
        /**
         * Peer ID.
         */
        @SerializedName("peer_id")
        private Integer peerId;

        /**
         * Message ID.
         */
        @SerializedName("message_id")
        private Integer messageId;

        /**
         * Error message, if message is not delivered.
         */
        @SerializedName("error")
        private String error;

        public Integer getPeerId() {
            return peerId;
        }

        public void setPeerId(Integer peerId) {
            this.peerId = peerId;
        }

        public Integer getMessageId() {
            return messageId;
        }

        public void setMessageId(Integer messageId) {
            this.messageId = messageId;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "peerId=" + peerId +
                    ", messageId=" + messageId +
                    ", error='" + error + '\'' +
                    '}';
        }
    }
}
