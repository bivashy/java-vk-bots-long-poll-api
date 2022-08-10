package api.longpoll.bots.http.impl;

import api.longpoll.bots.http.RequestBody;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * {@code application/x-www-form-urlencoded} request body.
 */
public class FormUrlencoded implements RequestBody {
    /**
     * Content-Type key.
     */
    private static final String CONTENT_TYPE_KEY = "Content-Type";

    /**
     * Content-Type value.
     */
    private static final String CONTENT_TYPE_VALUE = "application/x-www-form-urlencoded";

    /**
     * Content-Length key.
     */
    private static final String CONTENT_LENGTH_KEY = "Content-Length";

    /**
     * Request headers.
     */
    private final Map<String, String> headers = new HashMap<>();

    /**
     * Request body.
     */
    private final String body;

    public FormUrlencoded(Map<String, String> params) {
        this.body = params.entrySet()
                .stream()
                .map(entry -> encode(entry.getKey()) + "=" + encode(entry.getValue()))
                .collect(Collectors.joining("&"));
        this.headers.put(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE);
        this.headers.put(CONTENT_LENGTH_KEY, String.valueOf(this.body.length()));
    }

    /**
     * Gets form body.
     *
     * @return form body.
     */
    public String getBody() {
        return body;
    }

    /**
     * Encodes a string.
     *
     * @param s string to encode.
     * @return encoded string.
     */
    private String encode(String s) {
        try {
            return URLEncoder.encode(s, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<String, String> getHeaders() {
        return headers;
    }

    @Override
    public String toString() {
        return "FormUrlencoded{" +
                "body='" + body + '\'' +
                '}';
    }
}
