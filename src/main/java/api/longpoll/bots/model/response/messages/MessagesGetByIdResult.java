package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.Message;
import com.google.gson.annotations.SerializedName;

public class MessagesGetByIdResult {
    @SerializedName("response")
    private VkList<Message> messages;

    public VkList<Message> getMessages() {
        return messages;
    }

    public MessagesGetByIdResult setMessages(VkList<Message> messages) {
        this.messages = messages;
        return this;
    }
}
