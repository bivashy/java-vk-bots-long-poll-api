package api.longpoll.bots.methods;

import api.longpoll.bots.model.objects.media.FileType;

import java.io.File;

/**
 * Uploads file to VK.
 * This request requires neither <b>access token</b> not <b>API version</b> as parameters.
 *
 * @param <Response> VK API response type.
 * @see VkMethod
 */
public abstract class FileUploadingVkMethod<Response> extends VkMethod<Response> {
    /**
     * File to be uploaded to VK server.
     */
    private File file;

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

    public FileUploadingVkMethod<Response> setFile(File file) {
        this.file = file;
        return this;
    }
}
