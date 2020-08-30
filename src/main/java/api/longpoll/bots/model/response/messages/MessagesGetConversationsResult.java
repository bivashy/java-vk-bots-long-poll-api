package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.*;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Response to <b>messages.getConversations</b> request.
 */
public class MessagesGetConversationsResult {
    /**
     * Response object.
     */
    @SerializedName("response")
    private Response response;

    /**
     * Describes response.
     */
    public static class Response extends VkList<Item> {
        /**
         * Number of unread conversations.
         */
        @SerializedName("unread_count")
        private Integer unreadCount;

        /**
         * List of users.
         */
        @SerializedName("profiles")
        private List<User> profiles;

        /**
         * List of communities.
         */
        @SerializedName("groups")
        private List<Community> groups;

        public Integer getUnreadCount() {
            return unreadCount;
        }

        public void setUnreadCount(Integer unreadCount) {
            this.unreadCount = unreadCount;
        }

        public List<User> getProfiles() {
            return profiles;
        }

        public void setProfiles(List<User> profiles) {
            this.profiles = profiles;
        }

        public List<Community> getGroups() {
            return groups;
        }

        public void setGroups(List<Community> groups) {
            this.groups = groups;
        }
    }

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

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
