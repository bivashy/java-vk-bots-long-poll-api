package api.longpoll.bots.model.events.messages;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>message_allow</b> event object.
 */
public class MessageAllowEvent implements EventObject {
    /**
     * User ID.
     */
    @SerializedName("user_id")
    private Integer userId;

    /**
     * Key parameter.
     */
    @SerializedName("key")
    private String key;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "MessageAllowEvent{" +
                "userId=" + userId +
                ", key=" + key +
                '}';
    }
}
