package api.longpoll.bots.helpers.attachments;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.methods.impl.photos.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.photos.SaveMessagesPhoto;
import api.longpoll.bots.methods.impl.upload.UploadPhoto;
import api.longpoll.bots.model.objects.additional.UploadedFile;

import java.io.InputStream;

/**
 * Uploads a photo to message.
 */
public abstract class UploadableMessagePhoto extends AbstractUploadableFile {
    /**
     * Gets an upload server.
     */
    private final GetMessagesUploadServer getMessagesUploadServer;

    /**
     * Saves photo.
     */
    private final SaveMessagesPhoto saveMessagesPhoto;

    public UploadableMessagePhoto(Integer peerId, String accessToken) {
        this.getMessagesUploadServer = new GetMessagesUploadServer(accessToken).setPeerId(peerId);
        this.saveMessagesPhoto = new SaveMessagesPhoto(accessToken);
    }

    @Override
    public UploadedFile uploadFile(String filename, InputStream inputStream) throws VkApiException {
        GetMessagesUploadServer.ResponseBody uploadServer = getMessagesUploadServer.execute();
        UploadPhoto.ResponseBody uploadedPhoto = new UploadPhoto(
                uploadServer.getResponse().getUploadUrl(),
                filename,
                inputStream
        ).execute();

        SaveMessagesPhoto.ResponseBody savedPhoto = saveMessagesPhoto
                .setServer(uploadedPhoto.getServer())
                .setPhoto(uploadedPhoto.getPhoto())
                .setHash(uploadedPhoto.getHash())
                .execute();
        SaveMessagesPhoto.ResponseBody.Response photo = savedPhoto.getResponse().get(0);
        return new UploadedFile(
                "photo",
                photo.getOwnerId(),
                photo.getId(),
                photo.getAccessKey()
        );
    }
}
