package api.longpoll.bots.exceptions;

public class BotsLongPollException extends Exception {
    public BotsLongPollException(Throwable cause) {
        super(cause);
    }

    public BotsLongPollException(String message) {
        super(message);
    }
}
