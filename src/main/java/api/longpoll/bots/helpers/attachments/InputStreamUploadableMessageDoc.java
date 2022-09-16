package api.longpoll.bots.helpers.attachments;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.objects.additional.UploadedFile;

import java.io.InputStream;

/**
 * Uploads a document to a message using {@link InputStream}.
 */
public class InputStreamUploadableMessageDoc extends UploadableMessageDoc {
    /**
     * Document {@link InputStream}.
     */
    private final InputStream inputStream;

    /**
     * Document name.
     */
    private final String filename;

    public InputStreamUploadableMessageDoc(InputStream inputStream, String filename, Integer peerId, String accessToken) {
        super(peerId, accessToken);
        this.inputStream = inputStream;
        this.filename = filename;
    }

    @Override
    public UploadedFile upload() throws VkApiException {
        return uploadFile(filename, inputStream);
    }
}
