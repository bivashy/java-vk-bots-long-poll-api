package api.longpoll.bots.methods.impl;

import api.longpoll.bots.methods.impl.wall.CloseComments;
import api.longpoll.bots.methods.impl.wall.CreateComment;
import api.longpoll.bots.methods.impl.wall.OpenComments;

/**
 * Provides Utils methods.
 */
public class WallApi extends AbstractVkApi {
    public WallApi(String accessToken) {
        super(accessToken);
    }

    public CloseComments closeComments() {
        return new CloseComments(getAccessToken());
    }

    public CreateComment createComment() {
        return new CreateComment(getAccessToken());
    }

    public OpenComments openComments() {
        return new OpenComments(getAccessToken());
    }
}
