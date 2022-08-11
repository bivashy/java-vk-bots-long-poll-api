package api.longpoll.bots.exceptions;

/**
 * Occurs when server returns HTTP code 400 or higher.
 */
public class VkApiHttpException extends VkApiException {
    public VkApiHttpException(String message) {
        super(message);
    }
}
