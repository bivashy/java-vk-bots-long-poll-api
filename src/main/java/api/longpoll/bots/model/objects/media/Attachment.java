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
    private AttachmentObject attachmentObject;

    public AttachmentType getType() {
        return type;
    }

    public void setType(AttachmentType type) {
        this.type = type;
    }

    public AttachmentObject getAttachable() {
        return attachmentObject;
    }

    public void setAttachable(AttachmentObject attachmentObject) {
        this.attachmentObject = attachmentObject;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "type=" + type +
                ", attachable=" + attachmentObject +
                '}';
    }
}
