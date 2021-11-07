package api.longpoll.bots.http;

import java.io.IOException;

/**
 * An HTTP client to send HTTP requests.
 */
public interface HttpClient {
    /**
     * Sends HTTP request.
     *
     * @param httpRequest an HTTP request to be sent.
     * @return response body.
     * @throws IOException if error occurs.
     */
    String execute(HttpRequest httpRequest) throws IOException;
}
