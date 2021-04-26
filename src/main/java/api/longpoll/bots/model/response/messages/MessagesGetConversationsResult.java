package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.model.objects.basic.Conversation;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.response.ExtendedVkList;
import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>messages.getConversations</b> request.
 */
public class MessagesGetConversationsResult extends GenericResult<ExtendedVkList<MessagesGetConversationsResult.Response.Item>> {
    /**
     * Response object.
     */
    public static class Response extends ExtendedVkList<Response.Item> {
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

            @Override
            public String toString() {
                return "Item{" +
                        "conversation=" + conversation +
                        ", message=" + message +
                        '}';
            }
        }

        public Integer getUnreadCount() {
            return unreadCount;
        }

        public void setUnreadCount(Integer unreadCount) {
            this.unreadCount = unreadCount;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "unreadCount=" + unreadCount +
                    "} " + super.toString();
        }
    }
}
