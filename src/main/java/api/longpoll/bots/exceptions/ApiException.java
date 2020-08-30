package api.longpoll.bots.exceptions;

public class ApiException extends RuntimeException {
    /**
     * {@inheritDoc}
     */
    public ApiException(Throwable cause) {
        super(cause);
    }

    /**
     * {@inheritDoc}
     */
    public ApiException(String message) {
        super(message);
    }
}
