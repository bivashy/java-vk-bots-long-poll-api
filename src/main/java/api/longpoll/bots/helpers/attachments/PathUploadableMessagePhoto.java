package api.longpoll.bots.helpers.attachments;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.objects.additional.UploadedFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Supplier;

/**
 * Uploads a photo to message using {@link Path}.
 */
public class PathUploadableMessagePhoto extends UploadableMessagePhoto {
    /**
     * Photo {@link Path}.
     */
    private final Path path;

    public PathUploadableMessagePhoto(Path path, Supplier<Integer> peerIdSupplier, String accessToken) {
        super(peerIdSupplier, accessToken);
        this.path = path;
    }

    @Override
    public UploadedFile upload() throws VkApiException {
        try (InputStream inputStream = Files.newInputStream(path)) {
            return uploadFile(path.getFileName().toString(), inputStream);
        } catch (IOException e) {
            throw new VkApiException(e);
        }
    }
}