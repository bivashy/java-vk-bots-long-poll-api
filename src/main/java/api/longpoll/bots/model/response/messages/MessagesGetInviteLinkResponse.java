package api.longpoll.bots.model.response.messages;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>messages.getInviteLink</b> request.
 */
public class MessagesGetInviteLinkResponse {
    /**
     * Link for inviting.
     */
    @SerializedName("link")
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
