package api.longpoll.bots.http.params;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.methods.impl.photos.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.photos.SaveMessagesPhoto;
import api.longpoll.bots.methods.impl.upload.UploadPhoto;

import java.io.File;

/**
 * Photo attachment represented by {@link File}. Can be attached to messages.
 */
public class MessagePhoto extends AbstractAttachable {
    private String accessToken;
    private int peerId;
    private File photo;

    public MessagePhoto(String accessToken, int peerId, File photo) {
        this.accessToken = accessToken;
        this.peerId = peerId;
        this.photo = photo;
    }

    @Override
    public String attach() throws VkApiException {
        SaveMessagesPhoto.Response.ResponseObject uploadedPhoto = uploadPhoto().getResponseObject().get(0);
        return toAttachmentString("photo", uploadedPhoto.getOwnerId(), uploadedPhoto.getId(), uploadedPhoto.getAccessKey());
    }

    private SaveMessagesPhoto.Response uploadPhoto() throws VkApiException {
        GetMessagesUploadServer.Response.ResponseObject uploadServer = new GetMessagesUploadServer(accessToken)
                .setPeerId(peerId)
                .execute()
                .getResponseObject();
        UploadPhoto.Response uploadPhoto = new UploadPhoto()
                .setUploadUrl(uploadServer.getUploadUrl())
                .setFile(photo)
                .execute();
        return new SaveMessagesPhoto(accessToken)
                .setHash(uploadPhoto.getHash())
                .setPhoto(uploadPhoto.getPhoto())
                .setServer(uploadPhoto.getServer())
                .execute();
    }
}
