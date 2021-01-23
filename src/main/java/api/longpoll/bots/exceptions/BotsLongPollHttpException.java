package api.longpoll.bots.exceptions;

public class BotsLongPollHttpException extends Exception {
    public BotsLongPollHttpException(Throwable cause) {
        super(cause);
    }

    public BotsLongPollHttpException(String message) {
        super(message);
    }
}
