package api.longpoll.bots.model.response.docs;

import api.longpoll.bots.model.objects.media.Attachable;
import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>docs.save</b> request.
 */
public class DocsSaveResponse {
    /**
     * Type of document. Possible values:
     * <ul>
     *     <li>graffiti</li>
     *     <li>audio_message</li>
     *     <li>doc</li>
     * </ul>
     */
    @SerializedName("type")
    private String type;

    /**
     * Saved document.
     */
    private Attachable attachable;

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
        return "DocsSaveResponse{" +
                "type='" + type + '\'' +
                ", attachable=" + attachable +
                '}';
    }
}
