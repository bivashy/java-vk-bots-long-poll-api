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

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public void addHeader(String key, String value) {
        this.headers.put(key, value);
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
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

    /**
     * DefaultHttpResponse builder class.
     */
    public static final class Builder {
        /**
         * {@link DefaultHttpResponse} instance.
         */
        private final DefaultHttpResponse httpResponse = new DefaultHttpResponse();

        public Builder setResponseCode(int responseCode) {
            this.httpResponse.setResponseCode(responseCode);
            return this;
        }

        public Builder addHeader(String key, String value) {
            this.httpResponse.addHeader(key, value);
            return this;
        }

        public Builder setBody(String body) {
            this.httpResponse.setBody(body);
            return this;
        }

        public Builder setResponseMessage(String responseMessage) {
            this.httpResponse.setResponseMessage(responseMessage);
            return this;
        }

        public DefaultHttpResponse build() {
            return this.httpResponse;
        }
    }
}
