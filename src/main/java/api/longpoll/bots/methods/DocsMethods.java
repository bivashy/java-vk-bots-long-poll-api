package api.longpoll.bots.methods;

import api.longpoll.bots.methods.impl.docs.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.docs.GetWallUploadServer;
import api.longpoll.bots.methods.impl.docs.Save;
import api.longpoll.bots.methods.impl.docs.Search;

/**
 * Provides Docs methods.
 */
public class DocsMethods {
    /**
     * Access token.
     */
    private final String accessToken;

    public DocsMethods(String accessToken) {
        this.accessToken = accessToken;
    }

    public GetMessagesUploadServer getMessagesUploadServer() {
        return new GetMessagesUploadServer(accessToken);
    }

    public GetWallUploadServer getWallUploadServer() {
        return new GetWallUploadServer(accessToken);
    }

    public Save save() {
        return new Save(accessToken);
    }

    public Search search() {
        return new Search(accessToken);
    }
}
