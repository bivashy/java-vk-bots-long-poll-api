package api.longpoll.bots.methods.stories;

import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.stories.StoriesGetStatsResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>stories.getStats</b> method.
 *
 * @see <a href="https://vk.com/dev/stories.getStats">https://vk.com/dev/stories.getStats</a>
 */
public class StoriesGetStats extends GetMethod<StoriesGetStatsResult> {
    /**
     * Story owner ID.
     */
    private Integer ownerId;

    /**
     * Story ID.
     */
    private Integer storyId;

    public StoriesGetStats(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().storiesGetStats();
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("owner_id", ownerId),
                keyVal("story_id", storyId)
        );
    }

    @Override
    protected Class<? extends StoriesGetStatsResult> getResultType() {
        return StoriesGetStatsResult.class;
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
