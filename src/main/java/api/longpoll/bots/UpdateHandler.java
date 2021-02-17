package api.longpoll.bots;

import api.longpoll.bots.model.events.Event;

import java.util.List;

public interface UpdateHandler {
    void handleUpdates(List<Event> updates);
}
