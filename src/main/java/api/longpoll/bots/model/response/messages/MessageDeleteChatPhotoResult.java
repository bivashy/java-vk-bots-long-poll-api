package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.model.objects.basic.Chat;
import com.google.gson.annotations.SerializedName;

public class MessageDeleteChatPhotoResult {
    @SerializedName("response")
    private Response response;

    public static class Response {
        @SerializedName("message_id")
        private Object messageId;
        @SerializedName("chat")
        private Chat chat;

        public Object getMessageId() {
            return messageId;
        }

        public Response setMessageId(Object messageId) {
            this.messageId = messageId;
            return this;
        }

        public Chat getChat() {
            return chat;
        }

        public Response setChat(Chat chat) {
            this.chat = chat;
            return this;
        }
    }

    public Response getResponse() {
        return response;
    }

    public MessageDeleteChatPhotoResult setResponse(Response response) {
        this.response = response;
        return this;
    }
}
