package api.longpoll.bots.server;

import api.longpoll.bots.exceptions.BotsLongPollException;
import api.longpoll.bots.model.events.VkEvent;

import java.util.List;

/**
 * Client to get VK events.
 */
public interface LongPollClient {
    /**
     * Gets VK events from VK Long Poll server
     *
     * @return VK events
     * @throws BotsLongPollException if error occurs.
     */
    List<VkEvent> getEvents() throws BotsLongPollException;
}
