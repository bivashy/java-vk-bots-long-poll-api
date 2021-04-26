package api.longpoll.bots.exceptions;

/**
 * A checked exception occurs in <b>Java VK Bots Long Poll API</b> library.
 */
public class BotsLongPollException extends Exception {
    public BotsLongPollException(Throwable cause) {
        super(cause);
    }

    public BotsLongPollException(String message) {
        super(message);
    }
}
