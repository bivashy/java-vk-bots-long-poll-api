package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.objects.basic.Chat;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>messages.setChatPhoto</b> method.
 * <p>
 * Sets a previously-uploaded picture as the cover picture of a chat.
 *
 * @see <a href="https://vk.com/dev/messages.setChatPhoto">https://vk.com/dev/messages.setChatPhoto</a>
 */
public class SetChatPhoto extends AuthorizedVkApiMethod<SetChatPhoto.Response> {
    public SetChatPhoto(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.setChatPhoto");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
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
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject {
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
                return "ResponseObject{" +
                        "messageId=" + messageId +
                        ", chat=" + chat +
                        '}';
            }
        }
    }
}
