package api.longpoll.bots.http.impl;

import api.longpoll.bots.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * HTTP response wrapper.
 */
public class DefaultHttpResponse implements HttpResponse {
    /**
     * HTTP response code.
     */
    private int responseCode;

    /**
     * HTTP response message.
     */
    private String responseMessage;

    /**
     * HTTP response headers.
     */
    private final Map<String, String> headers = new HashMap<>();

    /**
     * HTTP response body.
     */
    private String body;

    public DefaultHttpResponse setResponseCode(int responseCode) {
        this.responseCode = responseCode;
        return this;
    }

    public DefaultHttpResponse addHeader(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    public DefaultHttpResponse setBody(String body) {
        this.body = body;
        return this;
    }

    public DefaultHttpResponse setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
        return this;
    }

    @Override
    public int getResponseCode() {
        return responseCode;
    }

    @Override
    public String getResponseMessage() {
        return responseMessage;
    }

    @Override
    public Map<String, String> getHeaders() {
        return headers;
    }

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "DefaultHttpResponse{" +
                "responseCode=" + responseCode +
                ", responseMessage='" + responseMessage + '\'' +
                ", headers=" + headers +
                ", body='" + body + '\'' +
                '}';
    }
}
