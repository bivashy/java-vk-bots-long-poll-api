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
public class StoriesApi extends AbstractVkApi {
    public StoriesApi(String accessToken) {
        super(accessToken);
    }

    public Delete delete() {
        return new Delete(getAccessToken());
    }

    public Get get() {
        return new Get(getAccessToken());
    }

    private GetById getById() {
        return new GetById(getAccessToken());
    }

    public GetPhotoUploadServer getPhotoUploadServer() {
        return new GetPhotoUploadServer(getAccessToken());
    }

    public GetReplies getReplies() {
        return new GetReplies(getAccessToken());
    }

    public GetStats getStats() {
        return new GetStats(getAccessToken());
    }

    public GetVideoUploadServer getVideoUploadServer() {
        return new GetVideoUploadServer(getAccessToken());
    }

    public GetViewers getViewers() {
        return new GetViewers(getAccessToken());
    }

    public HideAllReplies hideAllReplies() {
        return new HideAllReplies(getAccessToken());
    }

    public HideReply hideReply() {
        return new HideReply(getAccessToken());
    }

    public Save save() {
        return new Save(getAccessToken());
    }
}
