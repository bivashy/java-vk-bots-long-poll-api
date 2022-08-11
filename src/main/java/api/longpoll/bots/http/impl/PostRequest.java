package api.longpoll.bots.http.impl;

import api.longpoll.bots.http.HttpRequest;
import api.longpoll.bots.http.RequestBody;

import java.util.HashMap;
import java.util.Map;

/**
 * HTTP POST request wrapper.
 */
public class PostRequest implements HttpRequest {
    /**
     * Request method.
     */
    private static final String REQUEST_METHOD = "POST";

    /**
     * User-Agent header key.
     */
    private static final String USER_AGENT_KEY = "User-Agent";

    private static final String USER_AGENT_VALUE = "Java Client/1.0.0";

    /**
     * Accept key.
     */
    private static final String ACCEPT_KEY = "Accept";

    /**
     * Accept value.
     */
    private static final String ACCEPT_VALUE = "application/json";

    /**
     * Request URI.
     */
    private final String uri;

    /**
     * Request headers.
     */
    private final Map<String, String> headers = new HashMap<>();

    /**
     * Request body.
     */
    private RequestBody requestBody;

    public PostRequest(String uri) {
        this.uri = uri;
        addHeader(USER_AGENT_KEY, USER_AGENT_VALUE);
        addHeader(ACCEPT_KEY, ACCEPT_VALUE);
    }

    public PostRequest addHeader(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    public PostRequest addHeaders(Map<String, String> headers) {
        this.headers.putAll(headers);
        return this;
    }

    public PostRequest setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
        return addHeaders(requestBody.getHeaders());
    }

    @Override
    public String getRequestMethod() {
        return REQUEST_METHOD;
    }

    @Override
    public String getUri() {
        return uri;
    }

    @Override
    public Map<String, String> getHeaders() {
        return headers;
    }

    @Override
    public RequestBody getRequestBody() {
        return requestBody;
    }
}
