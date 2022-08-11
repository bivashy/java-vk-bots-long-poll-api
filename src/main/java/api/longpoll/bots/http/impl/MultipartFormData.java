package api.longpoll.bots.http.impl;

import api.longpoll.bots.http.FormInput;
import api.longpoll.bots.http.RequestBody;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * {@code multipart/form-data} request body.
 */
public class MultipartFormData implements RequestBody {
    /**
     * Content-Type key.
     */
    private static final String CONTENT_TYPE_KEY = "Content-Type";

    /**
     * Content-Type value.
     */
    private static final String CONTENT_TYPE_VALUE = "multipart/form-data; boundary=";

    /**
     * Content boundary.
     */
    private final String boundary = UUID.randomUUID().toString();

    /**
     * Request headers.
     */
    private final Map<String, String> headers = new HashMap<>();

    /**
     * Form input.
     */
    private final FormInput formInput;

    public MultipartFormData(FormInput formInput) {
        this.formInput = formInput;
        this.headers.put(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE + boundary);
    }

    public String getBoundary() {
        return boundary;
    }

    public FormInput getFormInput() {
        return formInput;
    }

    @Override
    public Map<String, String> getHeaders() {
        return headers;
    }

    @Override
    public String toString() {
        return "MultipartFormData{" +
                "formInput=" + formInput +
                '}';
    }
}
