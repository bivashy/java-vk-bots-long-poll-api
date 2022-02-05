package api.longpoll.bots.exceptions;

import api.longpoll.bots.http.HttpRequest;
import api.longpoll.bots.http.HttpResponse;

/**
 * Occurs when server returns HTTP code 400 or higher.
 */
public class VkApiHttpException extends VkApiException {
    public VkApiHttpException(HttpRequest httpRequest, HttpResponse httpResponse) {
        super("Server returned HTTP response code: " + httpResponse.getStatusCode() + " for URL: " + httpRequest.getUrl());
    }
}
