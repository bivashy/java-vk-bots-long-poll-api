package api.longpoll.bots.model.objects.media;

import api.longpoll.bots.adapters.deserializers.AttachmentDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Describes attachment.
 */
@JsonAdapter(AttachmentDeserializer.class)
public class Attachment {
    /**
     * Attachment type.
     */
    @SerializedName("type")
    private AttachmentType type;

    /**
     * Attachment object.
     */
    private Attachable attachable;

    public AttachmentType getType() {
        return type;
    }

    public void setType(AttachmentType type) {
        this.type = type;
    }

    public Attachable getAttachable() {
        return attachable;
    }

    public void setAttachable(Attachable attachable) {
        this.attachable = attachable;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "type=" + type +
                ", attachable=" + attachable +
                '}';
    }
}
