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

    /**
     * User-Agent header value.
     */
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
        this.addHeader(USER_AGENT_KEY, USER_AGENT_VALUE);
        this.addHeader(ACCEPT_KEY, ACCEPT_VALUE);
    }

    public void addHeader(String key, String value) {
        this.headers.put(key, value);
    }

    public void addHeaders(Map<String, String> headers) {
        this.headers.putAll(headers);
    }

    public void setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
        this.addHeaders(requestBody.getHeaders());
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

    /**
     * PostRequest builder.
     */
    public static class Builder {
        /**
         * {@link PostRequest} instance.
         */
        private final PostRequest postRequest;

        public Builder(String uri) {
            this.postRequest = new PostRequest(uri);
        }

        public Builder addHeader(String key, String value) {
            this.postRequest.addHeader(key, value);
            return this;
        }

        public Builder addHeaders(Map<String, String> headers) {
            this.postRequest.addHeaders(headers);
            return this;
        }

        public Builder setRequestBody(RequestBody requestBody) {
            this.postRequest.setRequestBody(requestBody);
            return this;
        }

        public PostRequest build() {
            return this.postRequest;
        }
    }
}
