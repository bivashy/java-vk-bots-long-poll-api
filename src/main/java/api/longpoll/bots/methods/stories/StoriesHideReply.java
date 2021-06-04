package api.longpoll.bots.methods.stories;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.IntegerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>stories.hideReply</b> method.
 *
 * Hides the reply to the current user's story.
 *
 * @see <a href="https://vk.com/dev/stories.hideReply">https://vk.com/dev/stories.hideReply</a>
 */
public class StoriesHideReply extends VkApiGetMethod<IntegerResult> {
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
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(
                keyVal("owner_id", ownerId),
                keyVal("story_id", storyId)
        );
    }

    @Override
    protected Class<? extends IntegerResult> getResultType() {
        return IntegerResult.class;
    }

    public StoriesHideReply setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public StoriesHideReply setStoryId(Integer storyId) {
        this.storyId = storyId;
        return this;
    }
}
