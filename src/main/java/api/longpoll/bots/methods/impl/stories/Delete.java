package api.longpoll.bots.methods.impl.stories;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>stories.delete</b> method.
 * <p>
 * Allows deleting a story.
 *
 * @see <a href="https://vk.com/dev/stories.delete">https://vk.com/dev/stories.delete</a>
 */
public class Delete extends AuthorizedVkApiMethod<IntegerResponse> {
    public Delete(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("stories.delete");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public Delete setOwnerId(int ownerId) {
        addParam("owner_id", ownerId);
        return this;
    }

    public Delete setStoryId(int storyId) {
        addParam("story_id", storyId);
        return this;
    }

    public Delete setStories(String... stories) {
        return setStories(Arrays.asList(stories));
    }

    public Delete setStories(List<String> stories) {
        addParam("stories", stories);
        return this;
    }
}
