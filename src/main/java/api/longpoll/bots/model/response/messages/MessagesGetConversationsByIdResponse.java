package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.Conversation;
import api.longpoll.bots.model.objects.basic.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Response to <b>messages.getConversationsById</b> request.
 */
public class MessagesGetConversationsByIdResponse extends VkList<Conversation> {
    /**
     * List of users.
     */
    @SerializedName("profiles")
    private List<User> profiles;

    public List<User> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<User> profiles) {
        this.profiles = profiles;
    }
}
