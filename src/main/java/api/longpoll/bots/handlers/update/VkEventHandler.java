package api.longpoll.bots.handlers.update;

import api.longpoll.bots.model.events.VkEvent;

import java.util.List;

/**
 * Handles VK events.
 */
@FunctionalInterface
public interface VkEventHandler {
    /**
     * Handles VK events.
     *
     * @param events VK events.
     */
    void handle(List<VkEvent> events);
}
