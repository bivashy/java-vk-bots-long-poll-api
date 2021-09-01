package api.longpoll.bots.client;

import api.longpoll.bots.exceptions.VkApiException;
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
     * @throws VkApiException if errors occur.
     */
    List<VkEvent> getEvents() throws VkApiException;
}
