package api.longpoll.bots.model.objects.additional.buttons;

import com.google.gson.JsonElement;

/**
 * A button to send user location.
 */
public class LocationButton extends Button {
    public LocationButton(Action action) {
        super(action);
    }

    public static class Action extends Button.Action {
        public Action() {
            this(null);
        }

        public Action(JsonElement payload) {
            super("location", payload);
        }
    }
}
