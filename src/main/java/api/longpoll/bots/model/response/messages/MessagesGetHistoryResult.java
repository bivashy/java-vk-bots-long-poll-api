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

        public void setUnread(Integer unread) {
            this.unread = unread;
        }

        public List<Conversation> getConversations() {
            return conversations;
        }

        public void setConversations(List<Conversation> conversations) {
            this.conversations = conversations;
        }

        public List<User> getProfiles() {
            return profiles;
        }

        public void setProfiles(List<User> profiles) {
            this.profiles = profiles;
        }
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
