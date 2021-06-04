package api.longpoll.bots.handlers.update;

import api.longpoll.bots.model.events.Event;

import java.util.List;

/**
 * Handles VK updates.
 */
@FunctionalInterface
public interface UpdateHandler {
    /**
     * Handles VK updates.
     *
     * @param updates VK updates.
     */
    void handleUpdates(List<Event> updates);
}
