package api.longpoll.bots.methods.impl.stories;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>stories.delete</b> method.
 * <p>
 * Allows deleting a story.
 *
 * @see <a href="https://vk.com/dev/stories.delete">https://vk.com/dev/stories.delete</a>
 */
public class Delete extends VkMethod<IntegerResponseBody> {
    public Delete(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUri() {
        return property("stories.delete");
    }

    @Override
    protected Class<IntegerResponseBody> getResponseType() {
        return IntegerResponseBody.class;
    }

    public Delete setOwnerId(int ownerId) {
        return addParam("owner_id", ownerId);
    }

    public Delete setStoryId(int storyId) {
        return addParam("story_id", storyId);
    }

    public Delete setStories(String... stories) {
        return setStories(Arrays.asList(stories));
    }

    public Delete setStories(List<String> stories) {
        return addParam("stories", csv(stories));
    }

    @Override
    public Delete addParam(String key, Object value) {
        return (Delete) super.addParam(key, value);
    }
}
