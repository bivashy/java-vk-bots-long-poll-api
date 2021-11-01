package api.longpoll.bots.http.params;

import api.longpoll.bots.exceptions.VkApiException;

/**
 * Attachment to be passed into VK API request parameters.
 */
public interface AttachableParam {
    /**
     * Converts attachment object into proper string value.
     *
     * @return attachment string value.
     * @throws VkApiException if errors occur.
     */
    String attach() throws VkApiException;
}
