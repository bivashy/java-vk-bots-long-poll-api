package api.longpoll.bots.methods.impl.wall;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>wall.openComments</b> method.
 *
 * @see <a href="https://vk.com/dev/wall.openComments">https://vk.com/dev/wall.openComments</a>
 */
public class OpenComments extends AuthorizedVkApiMethod<IntegerResponse> {
    public OpenComments(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("wall.openComments");
    }

    @Override
    protected Class<IntegerResponse> getResultType() {
        return IntegerResponse.class;
    }

    public OpenComments setOwnerId(int ownerId) {
        addParam("owner_id", ownerId);
        return this;
    }

    public OpenComments setPostId(int postId) {
        addParam("post_id", postId);
        return this;
    }
}
