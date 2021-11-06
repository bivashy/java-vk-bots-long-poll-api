package api.longpoll.bots.methods;

import api.longpoll.bots.methods.impl.wall.CloseComments;
import api.longpoll.bots.methods.impl.wall.CreateComment;
import api.longpoll.bots.methods.impl.wall.OpenComments;

/**
 * Provides Utils methods.
 */
public class WallMethods {
    /**
     * Access token.
     */
    private final String accessToken;

    public WallMethods(String accessToken) {
        this.accessToken = accessToken;
    }

    public CloseComments closeComments() {
        return new CloseComments(accessToken);
    }

    public CreateComment createComment() {
        return new CreateComment(accessToken);
    }

    public OpenComments openComments() {
        return new OpenComments(accessToken);
    }
}
