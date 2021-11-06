package api.longpoll.bots.methods.impl;

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

/**
 * Provides Stories methods.
 */
public class StoriesMethods {
    /**
     * Access token.
     */
    private final String accessToken;

    public StoriesMethods(String accessToken) {
        this.accessToken = accessToken;
    }

    public Delete delete() {
        return new Delete(accessToken);
    }

    public Get get() {
        return new Get(accessToken);
    }

    private GetById getById() {
        return new GetById(accessToken);
    }

    public GetPhotoUploadServer getPhotoUploadServer() {
        return new GetPhotoUploadServer(accessToken);
    }

    public GetReplies getReplies() {
        return new GetReplies(accessToken);
    }

    public GetStats getStats() {
        return new GetStats(accessToken);
    }

    public GetVideoUploadServer getVideoUploadServer() {
        return new GetVideoUploadServer(accessToken);
    }

    public GetViewers getViewers() {
        return new GetViewers(accessToken);
    }

    public HideAllReplies hideAllReplies() {
        return new HideAllReplies(accessToken);
    }

    public HideReply hideReply() {
        return new HideReply(accessToken);
    }

    public Save save() {
        return new Save(accessToken);
    }
}
