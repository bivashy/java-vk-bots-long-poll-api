package api.longpoll.bots.model.events.messages;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>message_typing_state</b> event object.
 */
public class MessageTypingStateEvent implements EventObject {
    /**
     * Typing status.
     */
    @SerializedName("state")
    private String state;

    /**
     * User ID who is typing the text.
     */
    @SerializedName("from_id")
    private Integer fromId;

    /**
     * Community ID to which the user writes a message.
     */
    @SerializedName("to_id")
    private Integer toId;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    @Override
    public String toString() {
        return "MessageTypingStateEvent{" +
                "state='" + state + '\'' +
                ", fromId=" + fromId +
                ", toId=" + toId +
                '}';
    }
}
