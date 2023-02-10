package api.longpoll.bots.methods;

import api.longpoll.bots.methods.impl.docs.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.docs.GetWallUploadServer;
import api.longpoll.bots.methods.impl.docs.Save;
import api.longpoll.bots.methods.impl.docs.Search;

import java.util.function.Supplier;

/**
 * Provides Docs methods.
 */
public class DocsMethods {
    /**
     * {@code access_token}.
     */
    private final Supplier<String> accessTokenSupplier;

    public DocsMethods(Supplier<String> accessTokenSupplier) {
        this.accessTokenSupplier = accessTokenSupplier;
    }

    public GetMessagesUploadServer getMessagesUploadServer() {
        return new GetMessagesUploadServer(accessTokenSupplier.get());
    }

    public GetWallUploadServer getWallUploadServer() {
        return new GetWallUploadServer(accessTokenSupplier.get());
    }

    public Save save() {
        return new Save(accessTokenSupplier.get());
    }

    public Search search() {
        return new Search(accessTokenSupplier.get());
    }
}
