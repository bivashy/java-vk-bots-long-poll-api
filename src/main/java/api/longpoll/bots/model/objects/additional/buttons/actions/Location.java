package api.longpoll.bots.model.objects.additional.buttons.actions;

import com.google.gson.JsonElement;

/**
 * Describes action for button type of Location.
 */
public class Location extends ButtonAction {
    public Location() {
        this(null);
    }

    public Location(JsonElement payload) {
        super("location", payload);
    }

    @Override
    public String toString() {
        return "Location{} " + super.toString();
    }
}
