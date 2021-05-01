package api.longpoll.bots.methods.stories;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.IntegerResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>stories.delete</b> method.
 *
 * @see <a href="https://vk.com/dev/stories.delete">https://vk.com/dev/stories.delete</a>
 */
public class StoriesDelete extends VkApiGetMethod<IntegerResult> {
    /**
     * Story owner's ID.
     */
    private Integer ownerId;

    /**
     * Story ID.
     */
    private Integer storyId;

    /**
     * List of words.
     */
    private List<String> stories;

    public StoriesDelete(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().storiesDelete();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("owner_id", ownerId),
                param("story_id", storyId),
                param("stories", stories)
        );
    }

    @Override
    protected Class<? extends IntegerResult> getResultType() {
        return IntegerResult.class;
    }

    public StoriesDelete setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public StoriesDelete setStoryId(Integer storyId) {
        this.storyId = storyId;
        return this;
    }

    public StoriesDelete setStories(List<String> stories) {
        this.stories = stories;
        return this;
    }
}
