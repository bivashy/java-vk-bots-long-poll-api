package api.longpoll.bots.helpers.attachments;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.objects.additional.UploadedFile;

import java.io.InputStream;

/**
 * Default implementation of {@link UploadableFile}.
 */
public abstract class AbstractUploadableFile implements UploadableFile {
    /**
     * Uploads a file to VK server.
     *
     * @param filename    filename.
     * @param inputStream file {@link InputStream}.
     * @return uploaded file.
     * @throws VkApiException if errors occur.
     */
    public abstract UploadedFile uploadFile(String filename, InputStream inputStream) throws VkApiException;
}
