package api.longpoll.bots.model.objects.media;

import com.google.gson.annotations.SerializedName;

/**
 * Describes attachment.
 */
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
}
