package api.longpoll.bots.exceptions.handlers;

import api.longpoll.bots.exceptions.ApiHttpException;

public interface ApiHttpExceptionHandler {
    void handle(ApiHttpException e);
}
