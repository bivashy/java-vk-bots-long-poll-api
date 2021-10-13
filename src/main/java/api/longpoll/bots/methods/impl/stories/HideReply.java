package api.longpoll.bots.methods.impl.stories;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>stories.hideReply</b> method.
 * <p>
 * Hides the reply to the current user's story.
 *
 * @see <a href="https://vk.com/dev/stories.hideReply">https://vk.com/dev/stories.hideReply</a>
 */
public class HideReply extends AuthorizedVkApiMethod<IntegerResponse> {
    public HideReply(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("stories.hideReply");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public HideReply setOwnerId(int ownerId) {
        return addParam("owner_id", ownerId);
    }

    public HideReply setStoryId(int storyId) {
        return addParam("story_id", storyId);
    }

    @Override
    public HideReply addParam(String key, Object value) {
        return (HideReply) super.addParam(key, value);
    }
}
