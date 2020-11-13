package api.longpoll.bots.methods.stories;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.stories.StoriesGetStatsResponse;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>stories.getStats</b> method.
 *
 * @see <a href="https://vk.com/dev/stories.getStats">https://vk.com/dev/stories.getStats</a>
 */
public class StoriesGetStats extends GetMethod<GenericResult<StoriesGetStatsResponse>> {
    /**
     * Story owner ID.
     */
    private Integer ownerId;

    /**
     * Story ID.
     */
    private Integer storyId;

    public StoriesGetStats(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().storiesGetStats();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<StoriesGetStatsResponse>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<StoriesGetStatsResponse>>(){}.getType());
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

    public StoriesGetStats setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public Integer getStoryId() {
        return storyId;
    }

    public StoriesGetStats setStoryId(Integer storyId) {
        this.storyId = storyId;
        return this;
    }
}
