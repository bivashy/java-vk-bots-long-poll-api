package api.longpoll.bots.http.impl;

import api.longpoll.bots.http.FormInput;
import api.longpoll.bots.http.RequestBody;

import java.util.UUID;

/**
 * {@code multipart/form-data} request body.
 */
public class MultipartFormData implements RequestBody {
    /**
     * Content boundary.
     */
    private final String boundary = UUID.randomUUID().toString();

    /**
     * Content-Type.
     */
    private final String contentType = "multipart/form-data; boundary=" + boundary;

    /**
     * Form input.
     */
    private FormInput formInput;

    public MultipartFormData setFormInput(FormInput formInput) {
        this.formInput = formInput;
        return this;
    }

    public String getBoundary() {
        return boundary;
    }

    public FormInput getFormInput() {
        return formInput;
    }

    @Override
    public String getContentType() {
        return contentType;
    }
}
