package api.longpoll.bots.model.objects.additional.buttons;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

/**
 * Callback button.
 */
public class CallbackButton extends Button {
    /**
     * Button color.
     *
     * @see api.longpoll.bots.model.objects.additional.buttons.Button.Color
     */
    @SerializedName("color")
    private Color color;

    public CallbackButton(Color color, Action action) {
        super(action);
        this.color = color;
    }

    /**
     * Describes action for button type of Callback.
     */
    public static class Action extends Button.Action {
        /**
         * Button text.
         */
        @SerializedName("label")
        private String label;

        public Action(String label) {
            this(label, null);
        }

        public Action(String label, JsonElement payload) {
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
            return "Action{" +
                    "label='" + label + '\'' +
                    "} " + super.toString();
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "CallbackButton{" +
                "color=" + color +
                "} " + super.toString();
    }
}
