package api.longpoll.bots.model.objects.additional;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Stores messages to forward.
 */
public class Forward {
    /**
     * Messages owner.
     * Should be set when forwarding messages from community to dialog.
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Messages origin.
     */
    @SerializedName("peer_id")
    private int peerId;

    /**
     * Conversation message IDs.
     */
    @SerializedName("conversation_message_ids")
    private List<Integer> conversationMessageIds;

    /**
     * Message IDs.
     */
    @SerializedName("message_ids")
    private List<Integer> messageIds;

    /**
     * To forward message to the same char.
     */
    @SerializedName("is_reply")
    private Boolean isReply;

    public Integer getOwnerId() {
        return ownerId;
    }

    public Forward setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public int getPeerId() {
        return peerId;
    }

    public Forward setPeerId(int peerId) {
        this.peerId = peerId;
        return this;
    }

    public List<Integer> getConversationMessageIds() {
        return conversationMessageIds;
    }

    public Forward setConversationMessageIds(List<Integer> conversationMessageIds) {
        this.conversationMessageIds = conversationMessageIds;
        return this;
    }

    public List<Integer> getMessageIds() {
        return messageIds;
    }

    public Forward setMessageIds(List<Integer> messageIds) {
        this.messageIds = messageIds;
        return this;
    }

    public Boolean getReply() {
        return isReply;
    }

    public Forward setReply(Boolean reply) {
        isReply = reply;
        return this;
    }


    @Override
    public String toString() {
        return "Forward{" +
                "ownerId=" + ownerId +
                ", peerId=" + peerId +
                ", conversationMessageIds=" + conversationMessageIds +
                ", messageIds=" + messageIds +
                ", isReply=" + isReply +
                '}';
    }
}
