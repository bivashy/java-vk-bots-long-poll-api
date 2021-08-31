package api.longpoll.bots.model.objects.additional.buttons.actions;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

/**
 * Describes action for button type of Callback.
 */
public class Callback extends ButtonAction {
    /**
     * Button text.
     */
    @SerializedName("label")
    private String label;

    public Callback(String label) {
        this(label, null);
    }

    public Callback(String label, JsonElement payload) {
        super("callback", payload);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Callback{" +
                "label='" + label + '\'' +
                "} " + super.toString();
    }
}
