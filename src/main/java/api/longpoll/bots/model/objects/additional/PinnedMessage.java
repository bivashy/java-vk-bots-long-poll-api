package api.longpoll.bots.model.objects.additional;

import api.longpoll.bots.model.objects.basic.Message;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Describes Pinned Message.
 *
 * @see <a href="https://vk.com/dev/objects/pinned_message">Pinned Message</a>
 */
public class PinnedMessage {
    /**
     * Message ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Message sent time in Unixtime.
     */
    @SerializedName("date")
    private Integer date;

    /**
     * Sender ID.
     */
    @SerializedName("from_id")
    private Integer fromId;

    /**
     * Message text.
     */
    @SerializedName("text")
    private String text;

    /**
     * Message attachments.
     */
    @SerializedName("attachments")
    private List<String> attachments;

    /**
     * Location information.
     */
    @SerializedName("geo")
    private Geo geo;

    /**
     * Forwarded messages.
     */
    @SerializedName("fwd_messages")
    private List<Message> fwdMessages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public List<Message> getFwdMessages() {
        return fwdMessages;
    }

    public void setFwdMessages(List<Message> fwdMessages) {
        this.fwdMessages = fwdMessages;
    }

    @Override
    public String toString() {
        return "PinnedMessage{" +
                "id=" + id +
                ", date=" + date +
                ", fromId=" + fromId +
                ", text='" + text + '\'' +
                ", attachments=" + attachments +
                ", geo=" + geo +
                ", fwdMessages=" + fwdMessages +
                '}';
    }
}
