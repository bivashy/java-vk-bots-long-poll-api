package api.longpoll.bots.methods.impl;

import api.longpoll.bots.methods.impl.photos.GetChatUploadServer;
import api.longpoll.bots.methods.impl.photos.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.photos.GetOwnerCoverPhotoUploadServer;
import api.longpoll.bots.methods.impl.photos.SaveOwnerCoverPhoto;
import api.longpoll.bots.methods.impl.photos.SaveMessagesPhoto;

/**
 * Provides Photos methods.
 */
public class PhotosApi extends AbstractVkApi {
    public PhotosApi(String accessToken) {
        super(accessToken);
    }

    public GetChatUploadServer getChatUploadServer() {
        return new GetChatUploadServer(getAccessToken());
    }

    public GetMessagesUploadServer getMessagesUploadServer() {
        return new GetMessagesUploadServer(getAccessToken());
    }

    public GetOwnerCoverPhotoUploadServer getOwnerCoverPhotoUploadServer() {
        return new GetOwnerCoverPhotoUploadServer(getAccessToken());
    }

    public SaveMessagesPhoto saveMessagesPhoto() {
        return new SaveMessagesPhoto(getAccessToken());
    }

    public SaveOwnerCoverPhoto saveOwnerCoverPhoto() {
        return new SaveOwnerCoverPhoto(getAccessToken());
    }
}
