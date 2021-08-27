package api.longpoll.bots.methods.impl.wall;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>wall.closeComments</b> method.
 *
 * @see <a href="https://vk.com/dev/wall.closeComments">https://vk.com/dev/wall.closeComments</a>
 */
public class CloseComments extends AuthorizedVkApiMethod<IntegerResponse> {
    public CloseComments(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("wall.closeComments");
    }

    @Override
    protected Class<IntegerResponse> getResultType() {
        return IntegerResponse.class;
    }

    public CloseComments setOwnerId(int ownerId) {
        addParam("owner_id", ownerId);
        return this;
    }

    public CloseComments setPostId(int postId) {
        addParam("post_id", postId);
        return this;
    }
}
