package api.longpoll.bots.model.events.messages;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>message_deny</b> event object.
 */
public class MessageDenyEvent implements EventObject {
    /**
     * User ID.
     */
    @SerializedName("user_id")
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "MessageDenyEvent{" +
                "userId=" + userId +
                '}';
    }
}
