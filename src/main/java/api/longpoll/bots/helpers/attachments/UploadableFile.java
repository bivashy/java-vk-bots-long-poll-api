package api.longpoll.bots.helpers.attachments;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.objects.additional.UploadedFile;

import java.util.concurrent.CompletableFuture;

public interface UploadableFile {
    UploadedFile upload() throws VkApiException;
    CompletableFuture<UploadedFile> uploadAsync();
}
