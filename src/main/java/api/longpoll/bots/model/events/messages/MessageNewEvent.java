package api.longpoll.bots.model.events.messages;

import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.objects.additional.ClientInfo;
import api.longpoll.bots.model.objects.basic.Message;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>message_new</b>, <b>message_reply</b> and <b>message_edit</b> event objects.
 */
public class MessageNewEvent implements EventObject {
    /**
     * Message object.
     */
    @SerializedName("message")
    private Message message;

    /**
     * Information about features available to the user.
     */
    @SerializedName("client_info")
    private ClientInfo clientInfo;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    @Override
    public String toString() {
        return "MessageNewEvent{" +
                "message=" + message +
                ", clientInfo=" + clientInfo +
                '}';
    }
}
