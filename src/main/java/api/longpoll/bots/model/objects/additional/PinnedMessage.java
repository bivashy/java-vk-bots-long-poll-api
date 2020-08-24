package api.longpoll.bots.model.objects.additional;

import api.longpoll.bots.model.objects.basic.Message;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Describes Pinned Message.
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

    public PinnedMessage setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getDate() {
        return date;
    }

    public PinnedMessage setDate(Integer date) {
        this.date = date;
        return this;
    }

    public Integer getFromId() {
        return fromId;
    }

    public PinnedMessage setFromId(Integer fromId) {
        this.fromId = fromId;
        return this;
    }

    public String getText() {
        return text;
    }

    public PinnedMessage setText(String text) {
        this.text = text;
        return this;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public PinnedMessage setAttachments(List<String> attachments) {
        this.attachments = attachments;
        return this;
    }

    public Geo getGeo() {
        return geo;
    }

    public PinnedMessage setGeo(Geo geo) {
        this.geo = geo;
        return this;
    }

    public List<Message> getFwdMessages() {
        return fwdMessages;
    }

    public PinnedMessage setFwdMessages(List<Message> fwdMessages) {
        this.fwdMessages = fwdMessages;
        return this;
    }
}
