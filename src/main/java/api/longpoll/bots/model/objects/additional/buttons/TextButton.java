package api.longpoll.bots.model.objects.additional.buttons;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

/**
 * Text button.
 */
public class TextButton extends Button {
    /**
     * Button color.
     *
     * @see api.longpoll.bots.model.objects.additional.buttons.Button.Color
     */
    @SerializedName("color")
    private Color color;

    public TextButton(Color color, Action action) {
        super(action);
        this.color = color;
    }

    /**
     * Describes action for button type of Text.
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
        return "TextButton{" +
                "color=" + color +
                "} " + super.toString();
    }
}
