package api.longpoll.bots.model.objects.additional;

import api.longpoll.bots.model.objects.basic.Message;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PinnedMessage {
    @SerializedName("id")
    private Integer id;
    @SerializedName("date")
    private Integer date;
    @SerializedName("from_id")
    private Integer fromId;
    @SerializedName("text")
    private String text;
    @SerializedName("attachments")
    private List<String> attachments;
    @SerializedName("geo")
    private Geo geo;
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
