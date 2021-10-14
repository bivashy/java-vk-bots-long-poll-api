package api.longpoll.bots.model.objects.additional;

import com.google.gson.annotations.SerializedName;

/**
 * Marks special message.
 */
public abstract class Template {
    /**
     * Type of message.
     */
    @SerializedName("type")
    private final String type;

    public Template(String type) {
        this.type = type;
    }
}
