package api.longpoll.bots.model.objects.basic;

import api.longpoll.bots.model.objects.media.Attachment;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public abstract class AttachmentHolder {
    /**
     * List of attachments in the comments (photos, links, etc.)
     */
    @SerializedName("attachments")
    private List<Attachment> attachments;

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }


    @Override
    public String toString() {
        return "AttachmentHolder{" +
                "attachments=" + attachments +
                '}';
    }
}
