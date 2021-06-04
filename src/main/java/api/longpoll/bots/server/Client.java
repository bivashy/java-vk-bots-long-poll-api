package api.longpoll.bots.server;

import api.longpoll.bots.exceptions.BotsLongPollException;
import api.longpoll.bots.exceptions.BotsLongPollAPIException;
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
     * @throws BotsLongPollAPIException if error occur.
     * @throws BotsLongPollException    if error occur.
     */
    List<Event> getUpdates() throws BotsLongPollAPIException, BotsLongPollException;
}
