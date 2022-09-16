package api.longpoll.bots.methods.impl.upload;

import api.longpoll.bots.http.RequestBody;
import api.longpoll.bots.http.impl.FileInput;
import api.longpoll.bots.http.impl.MultipartFormData;
import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.media.FileType;

import java.io.InputStream;

/**
 * Generic method that uploads files to VK server.
 *
 * @param <ResponseBody> response type.
 */
public abstract class UploadMethod<ResponseBody> extends VkMethod<ResponseBody> {
    /**
     * URI to upload file.
     */
    private final String uri;

    /**
     * File type.
     */
    private final String name;

    /**
     * Filename.
     */
    private final String filename;

    /**
     * File {@link InputStream}.
     */
    private final InputStream inputStream;

    public UploadMethod(String uri, FileType fileType, String filename, InputStream inputStream) {
        this.uri = uri;
        this.name = fileType.getValue();
        this.filename = filename;
        this.inputStream = inputStream;
    }

    @Override
    public String getUri() {
        return uri;
    }

    @Override
    protected RequestBody getRequestBody() {
        return new MultipartFormData(new FileInput(name, filename, inputStream));
    }
}
