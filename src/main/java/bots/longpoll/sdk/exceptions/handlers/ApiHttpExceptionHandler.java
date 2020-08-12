package bots.longpoll.sdk.exceptions.handlers;

import bots.longpoll.sdk.exceptions.ApiHttpException;

public interface ApiHttpExceptionHandler {
	void handle(ApiHttpException e);
}
