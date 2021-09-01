package api.longpoll.bots.model.objects.additional.templete;

import com.google.gson.annotations.SerializedName;

/**
 * Marks special message.
 */
public abstract class Template {
    /**
     * Type of message.
     */
    @SerializedName("type")
    private String type;

    public Template(String type) {
        this.type = type;
    }
}