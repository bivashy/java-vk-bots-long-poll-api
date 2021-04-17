package api.longpoll.bots.methods.stories;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.JsonToPojoConverterFactory;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>stories.delete</b> method.
 *
 * @see <a href="https://vk.com/dev/stories.delete">https://vk.com/dev/stories.delete</a>
 */
public class StoriesDelete extends GetMethod<GenericResult<Integer>> {
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
    protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
        return JsonToPojoConverterFactory.get(new TypeToken<GenericResult<Integer>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("owner_id", ownerId),
                keyVal("story_id", storyId),
                keyVal("stories", stories)
        );
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public StoriesDelete setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public Integer getStoryId() {
        return storyId;
    }

    public StoriesDelete setStoryId(Integer storyId) {
        this.storyId = storyId;
        return this;
    }

    public List<String> getStories() {
        return stories;
    }

    public StoriesDelete setStories(List<String> stories) {
        this.stories = stories;
        return this;
    }
}
