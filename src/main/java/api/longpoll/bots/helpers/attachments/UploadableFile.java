package api.longpoll.bots.helpers.attachments;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.objects.additional.UploadedFile;

import java.util.concurrent.CompletableFuture;

/**
 * Uploads file.
 */
public interface UploadableFile {
    /**
     * Uploads file synchronously.
     *
     * @return uploaded file.
     * @throws VkApiException if errors occur.
     */
    UploadedFile upload() throws VkApiException;

    /**
     * Uploads file asynchronously.
     *
     * @return uploaded file.
     */
    CompletableFuture<UploadedFile> uploadAsync();
}
