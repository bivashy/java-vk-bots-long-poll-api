package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.basic.Chat;
import api.longpoll.bots.model.response.GenericResponseBody;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>messages.setChatPhoto</b> method.
 * <p>
 * Sets a previously-uploaded picture as the cover picture of a chat.
 *
 * @see <a href="https://vk.com/dev/messages.setChatPhoto">https://vk.com/dev/messages.setChatPhoto</a>
 */
public class SetChatPhoto extends VkMethod<SetChatPhoto.ResponseBody> {
    public SetChatPhoto(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUri() {
        return property("messages.setChatPhoto");
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    public SetChatPhoto setFile(String file) {
        return addParam("file", file);
    }

    @Override
    public SetChatPhoto addParam(String key, Object value) {
        return (SetChatPhoto) super.addParam(key, value);
    }

    /**
     * Response to <b>messages.setChatPhoto</b> request.
     */
    public static class ResponseBody extends GenericResponseBody<ResponseBody.Response> {
        /**
         * Response object.
         */
        public static class Response {
            @SerializedName("message_id")
            private Integer messageId;

            @SerializedName("chat")
            private Chat chat;

            public Integer getMessageId() {
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
}
