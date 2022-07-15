package api.longpoll.bots.helpers.attachments;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.objects.additional.UploadedFile;

/**
 * Uploads a file to VK server.
 */
@FunctionalInterface
public interface UploadableFile {
    /**
     * Uploads a file to VK server.
     *
     * @return uploaded file info.
     * @throws VkApiException if errors occur.
     */
    UploadedFile upload() throws VkApiException;
}
