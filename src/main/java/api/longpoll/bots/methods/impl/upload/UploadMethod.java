package api.longpoll.bots.methods.impl.upload;

import api.longpoll.bots.http.impl.InputStreamRequestBody;
import api.longpoll.bots.methods.impl.VkMethod;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import java.io.File;
import java.io.InputStream;
import java.net.URLConnection;

/**
 * Generic method that uploads files to VK server.
 *
 * @param <VkResponse> response type.
 */
public abstract class UploadMethod<VkResponse> extends VkMethod<VkResponse> {
    private final MultipartBody.Builder multipartBodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);

    public UploadMethod(String url, String name, String filename, InputStream inputStream) {
        this(url, name, filename, new InputStreamRequestBody(filename, inputStream));
    }

    public UploadMethod(String url, String name, String filename, byte[] file) {
        this(url, name, filename, RequestBody.create(file, MediaType.get(URLConnection.guessContentTypeFromName(filename))));
    }

    public UploadMethod(String url, String name, File file) {
        this(url, name, file.getName(), RequestBody.create(file, MediaType.get(URLConnection.guessContentTypeFromName(file.getName()))));
    }

    private UploadMethod(String url, String name, String filename, RequestBody file) {
        super(url);
        this.multipartBodyBuilder.addFormDataPart(name, filename, file);
    }

    @Override
    protected RequestBody newRequestBody() {
        return multipartBodyBuilder.build();
    }

    @Override
    public String getUri() {
        return null;
    }
}
