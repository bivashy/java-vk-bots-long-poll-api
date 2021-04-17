package api.longpoll.bots.methods.stories;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.JsonToPojoConverterFactory;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>stories.hideReply</b> method.
 *
 * @see <a href="https://vk.com/dev/stories.hideReply">https://vk.com/dev/stories.hideReply</a>
 */
public class StoriesHideReply extends GetMethod<GenericResult<Integer>> {
    /**
     * Reply owner ID.
     */
    private Integer ownerId;

    /**
     * Reply story ID.
     */
    private Integer storyId;

    public StoriesHideReply(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().storiesHideReply();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
        return JsonToPojoConverterFactory.get(new TypeToken<GenericResult<Integer>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("owner_id", ownerId),
                keyVal("story_id", storyId)
        );
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public StoriesHideReply setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public Integer getStoryId() {
        return storyId;
    }

    public StoriesHideReply setStoryId(Integer storyId) {
        this.storyId = storyId;
        return this;
    }
}
