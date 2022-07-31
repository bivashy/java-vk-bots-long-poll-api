package api.longpoll.bots.helpers.attachments;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.objects.additional.UploadedFile;

import java.io.InputStream;
import java.util.function.Supplier;

/**
 * Uploads a document to a message using {@link InputStream}.
 */
public class InputStreamUploadableMessageDoc extends UploadableMessageDoc {
    /**
     * Document {@link InputStream}.
     */
    private final InputStream inputStream;

    /**
     * Document extension.
     */
    private final String extension;

    public InputStreamUploadableMessageDoc(InputStream inputStream, String extension, Supplier<Integer> peerIdSupplier, String accessToken) {
        super(peerIdSupplier, accessToken);
        this.inputStream = inputStream;
        this.extension = extension;
    }

    @Override
    public UploadedFile upload() throws VkApiException {
        return uploadFile("Doc" + System.currentTimeMillis() + "." + extension, inputStream);
    }
}
