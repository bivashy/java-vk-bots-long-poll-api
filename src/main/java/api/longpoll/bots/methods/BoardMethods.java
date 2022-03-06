package api.longpoll.bots.methods;

import api.longpoll.bots.methods.impl.board.DeleteComment;
import api.longpoll.bots.methods.impl.board.RestoreComment;

import java.util.function.Supplier;

/**
 * Provides Board methods.
 */
public class BoardMethods {
    /**
     * Access token.
     */
    private final Supplier<String> accessTokenSupplier;

    public BoardMethods(Supplier<String> accessTokenSupplier) {
        this.accessTokenSupplier = accessTokenSupplier;
    }

    public DeleteComment deleteComment() {
        return new DeleteComment(accessTokenSupplier.get());
    }

    public RestoreComment restoreComment() {
        return new RestoreComment(accessTokenSupplier.get());
    }
}
