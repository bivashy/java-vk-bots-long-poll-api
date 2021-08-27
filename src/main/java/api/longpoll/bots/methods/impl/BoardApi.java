package api.longpoll.bots.methods.impl;

import api.longpoll.bots.methods.impl.board.DeleteComment;
import api.longpoll.bots.methods.impl.board.RestoreComment;

/**
 * Provides Board methods.
 */
public class BoardApi extends AbstractVkApi {
    public BoardApi(String accessToken) {
        super(accessToken);
    }

    public DeleteComment deleteComment() {
        return new DeleteComment(getAccessToken());
    }

    public RestoreComment restoreComment() {
        return new RestoreComment(getAccessToken());
    }
}
