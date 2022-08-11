package api.longpoll.bots.http;

import java.util.Map;

/**
 * HTTP request wrapper.
 */
public interface HttpRequest {
    /**
     * Gets HTTP method. E.g. GET or POST.
     *
     * @return HTTP method.
     */
    String getRequestMethod();

    /**
     * Gets HTTP request URI.
     *
     * @return HTTP request URI.
     */
    String getUri();

    /**
     * Gets HTTP request headers.
     *
     * @return HTTP request headers.
     */
    Map<String, String> getHeaders();

    /**
     * Gets HTTP request body.
     *
     * @return HTTP request body.
     */
    RequestBody getRequestBody();
}
