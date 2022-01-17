package api.longpoll.bots.helpers.attachments;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.objects.additional.VkAttachment;

/**
 * Attaches files.
 */
@FunctionalInterface
public interface Attachable {
    /**
     * Attaches files.
     *
     * @return VK attachment
     * @throws VkApiException if errors occur.
     */
    VkAttachment attach() throws VkApiException;
}
