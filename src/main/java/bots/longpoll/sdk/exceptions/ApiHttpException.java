package bots.longpoll.sdk.exceptions;

public class ApiHttpException extends Exception {
	/**
	 * {@inheritDoc}
	 */
	public ApiHttpException(Throwable cause) {
		super(cause);
	}

	/**
	 * {@inheritDoc}
	 */
	public ApiHttpException(String message) {
		super(message);
	}
}
