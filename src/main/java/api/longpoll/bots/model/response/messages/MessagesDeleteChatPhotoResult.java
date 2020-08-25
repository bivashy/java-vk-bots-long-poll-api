package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.model.objects.basic.Chat;
import com.google.gson.annotations.SerializedName;

public class MessagesDeleteChatPhotoResult {
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

        public void setMessageId(Object messageId) {
            this.messageId = messageId;
        }

        public Chat getChat() {
            return chat;
        }

        public void setChat(Chat chat) {
            this.chat = chat;
        }
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
