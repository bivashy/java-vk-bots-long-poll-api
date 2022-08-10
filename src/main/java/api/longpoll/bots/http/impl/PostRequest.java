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
     * Content-Type header.
     */
    private static final String CONTENT_TYPE_KEY = "Content-Type";

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
    }

    private PostRequest addHeader(String key, String value) {
        headers.put(key, value);
        return this;
    }

    public PostRequest setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
        return addHeader(CONTENT_TYPE_KEY, requestBody.getContentType());
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
