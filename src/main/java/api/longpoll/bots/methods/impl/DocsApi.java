package api.longpoll.bots.methods.impl;

import api.longpoll.bots.methods.impl.docs.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.docs.GetWallUploadServer;
import api.longpoll.bots.methods.impl.docs.Save;
import api.longpoll.bots.methods.impl.docs.Search;

/**
 * Provides Docs methods.
 */
public class DocsApi extends AbstractVkApi {
    public DocsApi(String accessToken) {
        super(accessToken);
    }

    public GetMessagesUploadServer getMessagesUploadServer() {
        return new GetMessagesUploadServer(getAccessToken());
    }

    public GetWallUploadServer getWallUploadServer() {
        return new GetWallUploadServer(getAccessToken());
    }

    public Save save() {
        return new Save(getAccessToken());
    }

    public Search search() {
        return new Search(getAccessToken());
    }
}
