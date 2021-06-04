package api.longpoll.bots.server;

import api.longpoll.bots.exceptions.BotsLongPollException;
import api.longpoll.bots.model.events.Event;

import java.util.List;

/**
 * Client to get Vk Long Poll updates.
 */
public interface Client {
    /**
     * Gets updates from VK Long Poll server
     *
     * @return Long Poll updates
     * @throws BotsLongPollException    if error occur.
     */
    List<Event> getUpdates() throws BotsLongPollException;
}
