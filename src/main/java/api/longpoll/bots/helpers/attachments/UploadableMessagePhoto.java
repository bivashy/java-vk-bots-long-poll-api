package api.longpoll.bots.helpers.attachments;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.methods.impl.photos.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.photos.SaveMessagesPhoto;
import api.longpoll.bots.methods.impl.upload.UploadPhoto;
import api.longpoll.bots.model.objects.additional.UploadedFile;

import java.io.InputStream;
import java.util.function.Supplier;

/**
 * Uploads a photo to message.
 */
public abstract class UploadableMessagePhoto extends AbstractUploadableFile {
    /**
     * Gets an upload server.
     */
    private final GetMessagesUploadServer getMessagesUploadServer;

    /**
     * Uploads a photo to VK server.
     */
    private final UploadPhoto uploadPhoto;

    /**
     * Saves photo.
     */
    private final SaveMessagesPhoto saveMessagesPhoto;

    public UploadableMessagePhoto(Supplier<Integer> peerIdSupplier, String accessToken) {
        this.uploadPhoto = new UploadPhoto();
        this.getMessagesUploadServer = new GetMessagesUploadServer(accessToken).setPeerId(peerIdSupplier.get());
        this.saveMessagesPhoto = new SaveMessagesPhoto(accessToken);
    }

    @Override
    public UploadedFile uploadFile(String filename, InputStream inputStream) throws VkApiException {
        GetMessagesUploadServer.ResponseBody uploadServer = getMessagesUploadServer.execute();
        UploadPhoto.Response uploadedPhoto = uploadPhoto
                .setPhoto(filename, inputStream)
                .setUrl(uploadServer.getResponse().getUploadUrl())
                .execute();
        SaveMessagesPhoto.ResponseBody savedPhoto = saveMessagesPhoto
                .setServer(uploadedPhoto.getServer())
                .setPhoto(uploadedPhoto.getPhoto())
                .setHash(uploadedPhoto.getHash())
                .execute();
        SaveMessagesPhoto.ResponseBody.Response photo = savedPhoto.getResponse().get(0);
        return new UploadedFile() {
            @Override
            public String getType() {
                return "photo";
            }

            @Override
            public int getOwnerId() {
                return photo.getOwnerId();
            }

            @Override
            public int getMediaId() {
                return photo.getId();
            }

            @Override
            public String getAccessKey() {
                return photo.getAccessKey();
            }
        };
    }
}