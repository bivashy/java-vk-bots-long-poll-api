package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.objects.basic.Chat;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>messages.deleteChatPhoto</b> method.
 * <p>
 * Deletes a chat's cover picture.
 *
 * @see <a href="https://vk.com/dev/messages.deleteChatPhoto">https://vk.com/dev/messages.deleteChatPhoto</a>
 */
public class DeleteChatPhoto extends AuthorizedVkApiMethod<DeleteChatPhoto.Response> {
    public DeleteChatPhoto(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.deleteChatPhoto");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public DeleteChatPhoto setChatId(int chatId) {
        return addParam("chat_id", chatId);
    }

    public DeleteChatPhoto setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public DeleteChatPhoto addParam(String key, Object value) {
        return (DeleteChatPhoto) super.addParam(key, value);
    }

    /**
     * Response to <b>messages.deleteChatPhoto</b> request.
     */
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject {
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
                return "ResponseObject{" +
                        "messageId=" + messageId +
                        ", chat=" + chat +
                        '}';
            }
        }
    }
}
