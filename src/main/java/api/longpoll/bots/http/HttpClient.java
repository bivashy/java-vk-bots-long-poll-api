package api.longpoll.bots.http;

import java.io.IOException;

/**
 * An HTTP client to send HTTP requests.
 */
public interface HttpClient {
    String execute(HttpRequest httpRequest) throws IOException;
}
