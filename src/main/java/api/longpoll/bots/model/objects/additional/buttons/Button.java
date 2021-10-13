package api.longpoll.bots.model.objects.additional.buttons;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

/**
 * Abstract Button object.
 */
public abstract class Button {
    /**
     * An object that describes the type of action and its parameters.
     */
    @SerializedName("action")
    private Action action;

    public Button(Action action) {
        this.action = action;
    }

    /**
     * Describes button action.
     */
    public abstract static class Action {
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

        public Action(String type, JsonElement payload) {
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
            return "Action{" +
                    "type='" + type + '\'' +
                    ", payload=" + payload +
                    '}';
        }
    }

    /**
     * Describes possible button colors.
     */
    public enum Color {
        /**
         * Blue button, indicates the main action. #5181B8
         */
        @SerializedName("primary") PRIMARY,
        /**
         * Default white button. #FFFFFF
         */
        @SerializedName("secondary") SECONDARY,
        /**
         * Dangerous or negative action (cancel, delete etc.) #E64646
         */
        @SerializedName("negative") NEGATIVE,
        /**
         * Accept, agree. #4BB34B
         */
        @SerializedName("positive") POSITIVE
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }


    @Override
    public String toString() {
        return "Button{" +
                "action=" + action +
                '}';
    }
}
