package api.longpoll.bots.model.objects.additional.buttons.actions;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

/**
 * Describes action for button type of Text.
 */
public class Text extends ButtonAction {
    /**
     * Button text.
     */
    @SerializedName("label")
    private String label;

    public Text(String label) {
        this(label, null);
    }

    public Text(String label, JsonElement payload) {
        super("text", payload);
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
        return "Text{" +
                "label='" + label + '\'' +
                "} " + super.toString();
    }
}
