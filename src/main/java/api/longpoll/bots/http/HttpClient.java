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
     * @return response.
     * @throws IOException if error occurs.
     */
    HttpResponse execute(HttpRequest httpRequest) throws IOException;
}
