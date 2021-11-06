package api.longpoll.bots.methods.impl;

import api.longpoll.bots.methods.impl.photos.GetChatUploadServer;
import api.longpoll.bots.methods.impl.photos.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.photos.GetOwnerCoverPhotoUploadServer;
import api.longpoll.bots.methods.impl.photos.SaveOwnerCoverPhoto;
import api.longpoll.bots.methods.impl.photos.SaveMessagesPhoto;

/**
 * Provides Photos methods.
 */
public class PhotosMethods {
    /**
     * Access token.
     */
    private final String accessToken;

    public PhotosMethods(String accessToken) {
        this.accessToken = accessToken;
    }

    public GetChatUploadServer getChatUploadServer() {
        return new GetChatUploadServer(accessToken);
    }

    public GetMessagesUploadServer getMessagesUploadServer() {
        return new GetMessagesUploadServer(accessToken);
    }

    public GetOwnerCoverPhotoUploadServer getOwnerCoverPhotoUploadServer() {
        return new GetOwnerCoverPhotoUploadServer(accessToken);
    }

    public SaveMessagesPhoto saveMessagesPhoto() {
        return new SaveMessagesPhoto(accessToken);
    }

    public SaveOwnerCoverPhoto saveOwnerCoverPhoto() {
        return new SaveOwnerCoverPhoto(accessToken);
    }
}
