package api.longpoll.bots.methods;

import api.longpoll.bots.model.objects.media.FileType;
import kong.unirest.HttpRequest;
import kong.unirest.HttpRequestWithBody;
import kong.unirest.Unirest;

import java.io.File;
import java.io.IOException;

/**
 * Executes generic POST HTTP request to VK API.
 * POST HTTP requests are used to upload files to VK server.
 * These request do not require neither <b>access token</b> not <b>API version</b> as parameters.
 *
 * @param <Response> VK API response type.
 * @see VkApiMethod
 */
public abstract class VkApiPostMethod<Response> extends VkApiMethod<Response> {
    /**
     * File to be uploaded to VK server.
     */
    private File file;

    @Override
    protected String execute(HttpRequest<?> httpRequest) throws IOException {
        return super.execute(((HttpRequestWithBody) httpRequest).field(getType().name, file));
    }

    @Override
    protected HttpRequest<?> httpRequest() {
        return Unirest.post(getApi());
    }

    /**
     * Gets file type.
     *
     * @return file type.
     * @see FileType
     */
    protected abstract FileType getType();

    public VkApiPostMethod<Response> setFile(File file) {
        this.file = file;
        return this;
    }
}
