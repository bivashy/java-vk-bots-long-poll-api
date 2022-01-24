package api.longpoll.bots.helpers.attachments;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.methods.impl.photos.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.photos.SaveMessagesPhoto;
import api.longpoll.bots.methods.impl.upload.UploadPhoto;
import api.longpoll.bots.model.objects.additional.VkAttachment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.Supplier;

/**
 * Attaches photo to message.
 */
public class MessagePhotoAttachable implements Attachable {
    /**
     * Photo to attach.
     */
    private final File photo;

    /**
     * Gets upload server.
     */
    private final GetMessagesUploadServer getMessagesUploadServer;

    /**
     * Uploads photo to VK.
     */
    private final UploadPhoto uploadPhoto;

    /**
     * Saves photo.
     */
    private final SaveMessagesPhoto saveMessagesPhoto;

    public MessagePhotoAttachable(File photo, Supplier<Integer> peerIdSupplier, String accessToken) {
        this.photo = photo;
        this.uploadPhoto = new UploadPhoto();
        this.getMessagesUploadServer = new GetMessagesUploadServer(accessToken).setPeerId(peerIdSupplier.get());
        this.saveMessagesPhoto = new SaveMessagesPhoto(accessToken);
    }

    @Override
    public VkAttachment attach() throws VkApiException {
        try (InputStream inputStream = new FileInputStream(photo)) {
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
            return new VkAttachment(savedPhoto);
        } catch (IOException e) {
            throw new VkApiException(e);
        }
    }
}
