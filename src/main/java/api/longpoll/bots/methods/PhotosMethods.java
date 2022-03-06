package api.longpoll.bots.methods;

import api.longpoll.bots.methods.impl.photos.GetChatUploadServer;
import api.longpoll.bots.methods.impl.photos.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.photos.GetOwnerCoverPhotoUploadServer;
import api.longpoll.bots.methods.impl.photos.SaveMessagesPhoto;
import api.longpoll.bots.methods.impl.photos.SaveOwnerCoverPhoto;

import java.util.function.Supplier;

/**
 * Provides Photos methods.
 */
public class PhotosMethods {
    /**
     * Access token.
     */
    private final Supplier<String> accessTokenSupplier;

    public PhotosMethods(Supplier<String> accessTokenSupplier) {
        this.accessTokenSupplier = accessTokenSupplier;
    }

    public GetChatUploadServer getChatUploadServer() {
        return new GetChatUploadServer(accessTokenSupplier.get());
    }

    public GetMessagesUploadServer getMessagesUploadServer() {
        return new GetMessagesUploadServer(accessTokenSupplier.get());
    }

    public GetOwnerCoverPhotoUploadServer getOwnerCoverPhotoUploadServer() {
        return new GetOwnerCoverPhotoUploadServer(accessTokenSupplier.get());
    }

    public SaveMessagesPhoto saveMessagesPhoto() {
        return new SaveMessagesPhoto(accessTokenSupplier.get());
    }

    public SaveOwnerCoverPhoto saveOwnerCoverPhoto() {
        return new SaveOwnerCoverPhoto(accessTokenSupplier.get());
    }
}
