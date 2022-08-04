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
     * Content-Type.
     */
    private static final String CONTENT_TYPE = "application/x-www-form-urlencoded";

    /**
     * Content params.
     */
    private final Map<String, String> params = new HashMap<>();

    public FormUrlencoded addParam(String key, String value) {
        params.put(key, value);
        return this;
    }

    public String getContent() {
        return params.entrySet()
                .stream()
                .map(entry -> encode(entry.getKey()) + "=" + encode(entry.getValue()))
                .collect(Collectors.joining("&"));
    }

    private String encode(String s) {
        try {
            return URLEncoder.encode(s, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getContentType() {
        return CONTENT_TYPE;
    }

    @Override
    public String toString() {
        return "FormUrlencoded{" +
                "params=" + params +
                '}';
    }
}
