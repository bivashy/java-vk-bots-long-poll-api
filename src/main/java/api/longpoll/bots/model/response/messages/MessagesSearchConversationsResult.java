package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.Community;
import api.longpoll.bots.model.objects.basic.Conversation;
import api.longpoll.bots.model.objects.basic.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MessagesSearchConversationsResult {
    @SerializedName("response")
    private Response response;

    public static class Response extends VkList<Conversation> {
        @SerializedName("profiles")
        private List<User> profiles;
        @SerializedName("groups")
        private List<Community> groups;

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

    public Response getResponse() {
        return response;
    }

    public MessagesSearchConversationsResult setResponse(Response response) {
        this.response = response;
        return this;
    }
}
