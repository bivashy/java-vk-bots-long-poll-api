package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.Conversation;
import api.longpoll.bots.model.objects.basic.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MessagesGetConversationsByIdResult {
    @SerializedName("response")
    private VkList<Item> response;

    public static class Item extends Conversation {
        @SerializedName("profiles")
        private List<User> profiles;

        public List<User> getProfiles() {
            return profiles;
        }

        public Item setProfiles(List<User> profiles) {
            this.profiles = profiles;
            return this;
        }
    }

    public VkList<Item> getResponse() {
        return response;
    }

    public MessagesGetConversationsByIdResult setResponse(VkList<Item> response) {
        this.response = response;
        return this;
    }
}
