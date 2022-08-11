package api.longpoll.bots.http;

import java.util.Map;

/**
 * HTTP response wrapper.
 */
public interface HttpResponse {
    /**
     * Get HTTP response code.
     *
     * @return HTTP response code.
     */
    int getResponseCode();

    /**
     * Gets HTTP response message.
     *
     * @return HTTP response message.
     */
    String getResponseMessage();

    /**
     * Gets HTTP response headers.
     *
     * @return HTTP response headers.
     */
    Map<String, String> getHeaders();

    /**
     * Gets HTTP response body.
     *
     * @return HTTP response body.
     */
    String getBody();
}
