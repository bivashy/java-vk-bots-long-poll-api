package api.longpoll.bots.helpers.attachments;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.objects.additional.UploadedFile;

import java.io.InputStream;

/**
 * Uploads a photo to a message using {@link InputStream}.
 */
public class InputStreamUploadableMessagePhoto extends UploadableMessagePhoto {
    /**
     * Photo {@link InputStream}.
     */
    private final InputStream inputStream;

    /**
     * Photo name.
     */
    private final String filename;

    public InputStreamUploadableMessagePhoto(InputStream inputStream, String filename, Integer peerId, String accessToken) {
        super(peerId, accessToken);
        this.inputStream = inputStream;
        this.filename = filename;
    }

    @Override
    public UploadedFile upload() throws VkApiException {
        return uploadFile(filename, inputStream);
    }
}
