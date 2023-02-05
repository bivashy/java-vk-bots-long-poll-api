package api.longpoll.bots.helpers.attachments;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.methods.impl.photos.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.photos.SaveMessagesPhoto;
import api.longpoll.bots.methods.impl.upload.UploadPhoto;
import api.longpoll.bots.model.objects.additional.UploadedFile;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class MessagePhotoUploader implements MessageFileUploader {
    private final GetMessagesUploadServer getMessagesUploadServer;
    private final SaveMessagesPhoto saveMessagesPhoto;
    private final Function<String, UploadPhoto> uploadPhotoFactory;

    public MessagePhotoUploader(String accessToken, int peerId, Function<String, UploadPhoto> uploadPhotoFactory) {
        this.getMessagesUploadServer = new GetMessagesUploadServer(accessToken).setPeerId(peerId);
        this.saveMessagesPhoto = new SaveMessagesPhoto(accessToken);
        this.uploadPhotoFactory = uploadPhotoFactory;
    }

    @Override
    public UploadedFile upload() throws VkApiException {
        String uploadUrl = getMessagesUploadServer.execute()
                .getResponse()
                .getUploadUrl();
        UploadPhoto.ResponseBody upload = uploadPhotoFactory.apply(uploadUrl).execute();
        SaveMessagesPhoto.ResponseBody.Response photo = saveMessagesPhoto.setPhoto(upload.getPhoto())
                .setHash(upload.getHash())
                .setServer(upload.getServer())
                .execute()
                .getResponse()
                .get(0);
        return new UploadedFile("photo", photo.getOwnerId(), photo.getId(), photo.getAccessKey());
    }

    @Override
    public CompletableFuture<UploadedFile> uploadAsync() {
        return getMessagesUploadServer.executeAsync()
                .thenApply(uploadServer -> uploadServer.getResponse().getUploadUrl())
                .thenCompose(uploadUrl -> uploadPhotoFactory.apply(uploadUrl).executeAsync())
                .thenApply(upload -> saveMessagesPhoto.setPhoto(upload.getPhoto()).setHash(upload.getHash()).setServer(upload.getServer()))
                .thenCompose(VkMethod::executeAsync)
                .thenApply(savedPhoto -> savedPhoto.getResponse().get(0))
                .thenApply(photo -> new UploadedFile("photo", photo.getOwnerId(), photo.getId(), photo.getAccessKey()));
    }
}
