package api.longpoll.bots.methods.stories;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.stories.StoriesGetRepliesResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>stories.getReplies</b> method.
 *
 * @see <a href="https://vk.com/dev/stories.getReplies">https://vk.com/dev/stories.getReplies</a>
 */
public class StoriesGetReplies extends VkApiGetMethod<StoriesGetRepliesResult> {
    /**
     * Story owner ID.
     */
    private Integer ownerId;

    /**
     * Story ID.
     */
    private Integer storyId;

    /**
     * Access key for the private object.
     */
    private String accessKey;

    /**
     * To return additional fields.
     */
    private Boolean extended;

    /**
     * Additional fields of profiles and communities to return.
     */
    private List<String> fields;

    public StoriesGetReplies(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().storiesGetReplies();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("owner_id", ownerId),
                param("story_id", storyId),
                param("access_key", accessKey),
                param("extended", extended, true),
                param("fields", fields)
        );
    }

    @Override
    protected Class<? extends StoriesGetRepliesResult> getResultType() {
        return StoriesGetRepliesResult.class;
    }

    public StoriesGetReplies setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public StoriesGetReplies setStoryId(Integer storyId) {
        this.storyId = storyId;
        return this;
    }

    public StoriesGetReplies setAccessKey(String accessKey) {
        this.accessKey = accessKey;
        return this;
    }

    public StoriesGetReplies setExtended(Boolean extended) {
        this.extended = extended;
        return this;
    }

    public StoriesGetReplies setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }
}
