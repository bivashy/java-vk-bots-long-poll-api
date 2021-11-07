package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.config.VkBotsConfig;
import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.methods.impl.photos.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.photos.SaveMessagesPhoto;
import api.longpoll.bots.methods.impl.upload.UploadPhoto;
import api.longpoll.bots.model.objects.additional.VkAttachment;

import java.io.InputStream;

/**
 * Uploads photo to conversation.
 * Executes:
 * <ol>
 *     <li>photos.getMessagesUploadServer</li>
 *     <li>[uploading photo to VK server]</li>
 *     <li>photos.saveMessagesPhoto</li>
 * </ol>
 * The result of execution can be passed as <b>messages.send</b> parameter.
 */
public class AttachPhoto extends VkMethod<VkAttachment> {
    /**
     * ID of conversation.
     */
    private int peerId;

    /**
     * Name of file.
     */
    private String filename;

    /**
     * File {@link InputStream}.
     */
    private InputStream photo;

    /**
     * Gets upload server.
     */
    private final GetMessagesUploadServer getMessagesUploadServer;

    /**
     * Upload file to VK server.
     */
    private final UploadPhoto uploadPhoto = VkBotsConfig.getInstance().getUploadPhoto();

    /**
     * Saves uploaded document.
     */
    private final SaveMessagesPhoto saveMessagesPhoto;

    public AttachPhoto(String accessToken) {
        super(accessToken);
        getMessagesUploadServer = VkBotsConfig.getInstance().getPhotosGetMessagesUploadServerFactory().get(accessToken);
        saveMessagesPhoto = VkBotsConfig.getInstance().getSaveMessagePhotoFactory().get(accessToken);
    }

    @Override
    public VkAttachment execute() throws VkApiException {
        GetMessagesUploadServer.Response uploadServer = getMessagesUploadServer
                .setPeerId(peerId)
                .execute();
        UploadPhoto.Response uploadedPhoto = uploadPhoto
                .setUrl(uploadServer.getResponseObject().getUploadUrl())
                .setPhoto(filename, photo)
                .execute();
        SaveMessagesPhoto.Response savedPhoto = saveMessagesPhoto
                .setServer(uploadedPhoto.getServer())
                .setPhoto(uploadedPhoto.getPhoto())
                .setHash(uploadedPhoto.getHash())
                .execute();
        return new VkAttachment(savedPhoto);
    }

    public AttachPhoto setPeerId(int peerId) {
        this.peerId = peerId;
        return this;
    }

    public AttachPhoto setPhoto(String filename, InputStream photo) {
        this.filename = filename;
        this.photo = photo;
        return this;
    }

    @Override
    protected Class<VkAttachment> getResponseType() {
        return null;
    }

    @Override
    public String getUrl() {
        return null;
    }
}
