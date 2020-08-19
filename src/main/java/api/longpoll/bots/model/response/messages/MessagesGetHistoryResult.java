package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.Conversation;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.objects.basic.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MessagesGetHistoryResult {
    @SerializedName("response")
    private Response response;

    public static class Response extends VkList<Message> {
        @SerializedName("unread")
        private Integer unread;
        @SerializedName("conversations")
        private List<Conversation> conversations;
        @SerializedName("profiles")
        private List<User> profiles;

        public Integer getUnread() {
            return unread;
        }

        public Response setUnread(Integer unread) {
            this.unread = unread;
            return this;
        }

        public List<Conversation> getConversations() {
            return conversations;
        }

        public Response setConversations(List<Conversation> conversations) {
            this.conversations = conversations;
            return this;
        }

        public List<User> getProfiles() {
            return profiles;
        }

        public Response setProfiles(List<User> profiles) {
            this.profiles = profiles;
            return this;
        }
    }

    public Response getResponse() {
        return response;
    }

    public MessagesGetHistoryResult setResponse(Response response) {
        this.response = response;
        return this;
    }
}
