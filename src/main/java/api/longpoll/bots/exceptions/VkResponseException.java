package api.longpoll.bots.exceptions;

/**
 * Occurs when VK returns "error" of "failed" response.
 */
public class VkResponseException extends VkApiException {
    public VkResponseException(String message) {
        super(message);
    }
}
