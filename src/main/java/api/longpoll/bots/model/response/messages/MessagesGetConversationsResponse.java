package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.model.objects.basic.Conversation;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.response.ExtendedVkList;
import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>messages.getConversations</b> request.
 */
public class MessagesGetConversationsResponse extends ExtendedVkList<MessagesGetConversationsResponse.Item> {
    /**
     * Number of unread conversations.
     */
    @SerializedName("unread_count")
    private Integer unreadCount;

    /**
     * Describes VkList item.
     */
    public static class Item {
        /**
         * Conversation object.
         */
        @SerializedName("conversation")
        private Conversation conversation;

        /**
         * Last message in conversation.
         */
        @SerializedName("last_message")
        private Message message;

        public Conversation getConversation() {
            return conversation;
        }

        public void setConversation(Conversation conversation) {
            this.conversation = conversation;
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }
    }

    public Integer getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(Integer unreadCount) {
        this.unreadCount = unreadCount;
    }
}
