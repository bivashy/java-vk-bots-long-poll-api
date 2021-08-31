package api.longpoll.bots.model.objects.additional.buttons.actions;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

/**
 * Describes button action.
 */
public abstract class ButtonAction {
    /**
     * Button type.
     */
    @SerializedName("type")
    private String type;

    /**
     * Additional information.
     */
    @SerializedName("payload")
    private JsonElement payload;

    public ButtonAction(String type, JsonElement payload) {
        this.type = type;
        this.payload = payload;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JsonElement getPayload() {
        return payload;
    }

    public void setPayload(JsonElement payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "ButtonAction{" +
                "type='" + type + '\'' +
                ", payload=" + payload +
                '}';
    }
}
