package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.basic.Chat;
import api.longpoll.bots.model.response.GenericResponseBody;
import api.longpoll.bots.utils.VkMethods;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>messages.deleteChatPhoto</b> method.
 * <p>
 * Deletes a chat's cover picture.
 *
 * @see <a href="https://vk.com/dev/messages.deleteChatPhoto">https://vk.com/dev/messages.deleteChatPhoto</a>
 */
public class DeleteChatPhoto extends VkMethod<DeleteChatPhoto.ResponseBody> {
    public DeleteChatPhoto(String accessToken) {
        super(VkMethods.get("messages.deleteChatPhoto"), accessToken);
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
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
    public static class ResponseBody extends GenericResponseBody<ResponseBody.Response> {
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
}
