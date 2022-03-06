package api.longpoll.bots.methods;

import api.longpoll.bots.methods.impl.stories.Delete;
import api.longpoll.bots.methods.impl.stories.Get;
import api.longpoll.bots.methods.impl.stories.GetById;
import api.longpoll.bots.methods.impl.stories.GetPhotoUploadServer;
import api.longpoll.bots.methods.impl.stories.GetReplies;
import api.longpoll.bots.methods.impl.stories.GetStats;
import api.longpoll.bots.methods.impl.stories.GetVideoUploadServer;
import api.longpoll.bots.methods.impl.stories.GetViewers;
import api.longpoll.bots.methods.impl.stories.HideAllReplies;
import api.longpoll.bots.methods.impl.stories.HideReply;
import api.longpoll.bots.methods.impl.stories.Save;

import java.util.function.Supplier;

/**
 * Provides Stories methods.
 */
public class StoriesMethods {
    /**
     * Access token.
     */
    private final Supplier<String> accessTokenSupplier;

    public StoriesMethods(Supplier<String> accessTokenSupplier) {
        this.accessTokenSupplier = accessTokenSupplier;
    }

    public Delete delete() {
        return new Delete(accessTokenSupplier.get());
    }

    public Get get() {
        return new Get(accessTokenSupplier.get());
    }

    private GetById getById() {
        return new GetById(accessTokenSupplier.get());
    }

    public GetPhotoUploadServer getPhotoUploadServer() {
        return new GetPhotoUploadServer(accessTokenSupplier.get());
    }

    public GetReplies getReplies() {
        return new GetReplies(accessTokenSupplier.get());
    }

    public GetStats getStats() {
        return new GetStats(accessTokenSupplier.get());
    }

    public GetVideoUploadServer getVideoUploadServer() {
        return new GetVideoUploadServer(accessTokenSupplier.get());
    }

    public GetViewers getViewers() {
        return new GetViewers(accessTokenSupplier.get());
    }

    public HideAllReplies hideAllReplies() {
        return new HideAllReplies(accessTokenSupplier.get());
    }

    public HideReply hideReply() {
        return new HideReply(accessTokenSupplier.get());
    }

    public Save save() {
        return new Save(accessTokenSupplier.get());
    }
}
