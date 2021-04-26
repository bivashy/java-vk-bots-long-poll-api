package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.model.objects.basic.Chat;
import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>messages.deleteChatPhoto</b> request.
 */
public class MessagesDeleteChatPhotoResult extends GenericResult<MessagesDeleteChatPhotoResult.Response> {
    /**
     * Response object.
     */
    public static class Response {
        /**
         * ID of the system message sent.
         */
        @SerializedName("message_id")
        private Integer messageId;

        /**
         * Chat object.
         */
        @SerializedName("chat")
        private Chat chat;

        public Object getMessageId() {
            return messageId;
        }

        public void setMessageId(Integer messageId) {
            this.messageId = messageId;
        }

        public Chat getChat() {
            return chat;
        }

        public void setChat(Chat chat) {
            this.chat = chat;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "messageId=" + messageId +
                    ", chat=" + chat +
                    '}';
        }
    }
}
