package api.longpoll.bots.methods;

import api.longpoll.bots.model.objects.media.FileType;
import org.jsoup.Connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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
    protected Connection.Response execute(Connection connection) throws IOException {
        try (InputStream inputStream = new FileInputStream(file)) {
            connection.data(getType().name, file.getName(), inputStream);
            return super.execute(connection);
        }
    }

    @Override
    protected Connection.Method getMethod() {
        return Connection.Method.POST;
    }

    /**
     * Gets file type.
     *
     * @return file type.
     * @see FileType
     */
    protected abstract FileType getType();

    public File getFile() {
        return file;
    }

    public VkApiPostMethod<Response> setFile(File file) {
        this.file = file;
        return this;
    }
}
