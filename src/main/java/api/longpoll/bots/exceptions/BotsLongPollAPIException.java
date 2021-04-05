package api.longpoll.bots.exceptions;

public class BotsLongPollAPIException extends Exception {
    public BotsLongPollAPIException(Throwable cause) {
        super(cause);
    }

    public BotsLongPollAPIException(String message) {
        super(message);
    }
}
