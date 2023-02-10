package api.longpoll.bots.methods;

import api.longpoll.bots.methods.impl.wall.CloseComments;
import api.longpoll.bots.methods.impl.wall.CreateComment;
import api.longpoll.bots.methods.impl.wall.OpenComments;

import java.util.function.Supplier;

/**
 * Provides Utils methods.
 */
public class WallMethods {
    /**
     * {@code access_token}.
     */
    private final Supplier<String> accessTokenSupplier;

    public WallMethods(Supplier<String> accessTokenSupplier) {
        this.accessTokenSupplier = accessTokenSupplier;
    }

    public CloseComments closeComments() {
        return new CloseComments(accessTokenSupplier.get());
    }

    public CreateComment createComment() {
        return new CreateComment(accessTokenSupplier.get());
    }

    public OpenComments openComments() {
        return new OpenComments(accessTokenSupplier.get());
    }
}
