package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.Conversation;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.objects.basic.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Response to <b>messages.getHistory</b> request.
 */
public class MessagesGetHistoryResponse extends VkList<Message> {
    /**
     * Number of unread messages.
     */
    @SerializedName("unread")
    private Integer unread;

    /**
     * List of conversations.
     */
    @SerializedName("conversations")
    private List<Conversation> conversations;

    /**
     * List of users.
     */
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

    @Override
    public String toString() {
        return "MessagesGetHistoryResponse{" +
                "unread=" + unread +
                ", conversations=" + conversations +
                ", profiles=" + profiles +
                "} " + super.toString();
    }
}
