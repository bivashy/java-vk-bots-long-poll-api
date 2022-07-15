package api.longpoll.bots.helpers.attachments;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.methods.impl.photos.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.photos.SaveMessagesPhoto;
import api.longpoll.bots.methods.impl.upload.UploadPhoto;
import api.longpoll.bots.model.objects.additional.UploadedFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.function.Supplier;

/**
 * Uploads a photo to VK server.
 */
public class UploadableMessagePhoto implements UploadableFile {
    /**
     * Photo to upload.
     */
    private final File photo;

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

    public UploadableMessagePhoto(File photo, Supplier<Integer> peerIdSupplier, String accessToken) {
        this.photo = photo;
        this.uploadPhoto = new UploadPhoto();
        this.getMessagesUploadServer = new GetMessagesUploadServer(accessToken).setPeerId(peerIdSupplier.get());
        this.saveMessagesPhoto = new SaveMessagesPhoto(accessToken);
    }

    @Override
    public UploadedFile upload() throws VkApiException {
        try (InputStream inputStream = Files.newInputStream(photo.toPath())) {
            GetMessagesUploadServer.Response uploadServer = getMessagesUploadServer.execute();
            UploadPhoto.Response uploadedPhoto = uploadPhoto
                    .setPhoto(photo.getName(), inputStream)
                    .setUrl(uploadServer.getResponseObject().getUploadUrl())
                    .execute();
            SaveMessagesPhoto.Response savedPhoto = saveMessagesPhoto
                    .setServer(uploadedPhoto.getServer())
                    .setPhoto(uploadedPhoto.getPhoto())
                    .setHash(uploadedPhoto.getHash())
                    .execute();
            SaveMessagesPhoto.Response.ResponseObject photo = savedPhoto.getResponseObject().get(0);
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
        } catch (IOException e) {
            throw new VkApiException(e);
        }
    }
}
