package api.longpoll.bots.helpers.attachments;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.objects.additional.UploadedFile;

import java.io.InputStream;
import java.util.function.Supplier;

/**
 * Uploads a photo to massage using {@link InputStream}.
 */
public class InputStreamUploadableMessagePhoto extends UploadableMessagePhoto {
    /**
     * Photo {@link InputStream}.
     */
    private final InputStream inputStream;

    /**
     * Photo extension.
     */
    private final String extension;

    public InputStreamUploadableMessagePhoto(InputStream inputStream, String extension, Supplier<Integer> peerIdSupplier, String accessToken) {
        super(peerIdSupplier, accessToken);
        this.inputStream = inputStream;
        this.extension = extension;
    }

    @Override
    public UploadedFile upload() throws VkApiException {
        return uploadFile("Photo" + System.currentTimeMillis() + "." + extension, inputStream);
    }
}
