package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.Chat;
import api.longpoll.bots.model.objects.basic.Community;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.objects.basic.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MessagesGetConversationsResult {
    @SerializedName("response")
    private Response response;

    public static class Response extends VkList<Item> {
        @SerializedName("unread_count")
        private Integer unreadCount;
        @SerializedName("profiles")
        private List<User> profiles;
        @SerializedName("groups")
        private List<Community> groups;

        public Integer getUnreadCount() {
            return unreadCount;
        }

        public Response setUnreadCount(Integer unreadCount) {
            this.unreadCount = unreadCount;
            return this;
        }

        public List<User> getProfiles() {
            return profiles;
        }

        public Response setProfiles(List<User> profiles) {
            this.profiles = profiles;
            return this;
        }

        public List<Community> getGroups() {
            return groups;
        }

        public Response setGroups(List<Community> groups) {
            this.groups = groups;
            return this;
        }
    }

    public static class Item {
        @SerializedName("conversation")
        private Chat chat;
        @SerializedName("last_message")
        private Message message;

        public Chat getChat() {
            return chat;
        }

        public Item setChat(Chat chat) {
            this.chat = chat;
            return this;
        }

        public Message getMessage() {
            return message;
        }

        public Item setMessage(Message message) {
            this.message = message;
            return this;
        }
    }

    public Response getResponse() {
        return response;
    }

    public MessagesGetConversationsResult setResponse(Response response) {
        this.response = response;
        return this;
    }
}
