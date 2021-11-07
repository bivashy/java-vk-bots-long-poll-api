package api.longpoll.bots.methods;

import api.longpoll.bots.methods.impl.board.DeleteComment;
import api.longpoll.bots.methods.impl.board.RestoreComment;

/**
 * Provides Board methods.
 */
public class BoardMethods {
    /**
     * Access token.
     */
    private final String accessToken;

    public BoardMethods(String accessToken) {
        this.accessToken = accessToken;
    }

    public DeleteComment deleteComment() {
        return new DeleteComment(accessToken);
    }

    public RestoreComment restoreComment() {
        return new RestoreComment(accessToken);
    }
}
