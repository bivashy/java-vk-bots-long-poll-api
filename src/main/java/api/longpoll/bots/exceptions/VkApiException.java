package api.longpoll.bots.exceptions;

/**
 * A common exception that occurs in <b>Java VK Bots Long Poll API</b> library.
 */
public class VkApiException extends Exception {
    public VkApiException(Throwable cause) {
        super(cause);
    }

    public VkApiException(String message) {
        super(message);
    }
}
