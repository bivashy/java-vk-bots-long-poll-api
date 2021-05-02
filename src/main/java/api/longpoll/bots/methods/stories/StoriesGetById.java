package api.longpoll.bots.methods.stories;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.stories.StoriesListResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>stories.get</b> method.
 *
 * @see <a href="https://vk.com/dev/stories.get">https://vk.com/dev/stories.get</a>
 */
public class StoriesGetById extends VkApiGetMethod<StoriesListResult> {
    /**
     * Stories IDs in format {owner_id}+'_'+{story_id}. Example: 12345_54331
     */
    private List<String> stories;

    /**
     * To return additional fields.
     */
    private Boolean extended;

    /**
     * Additional fields of profiles and communities to return.
     */
    private List<String> fields;

    public StoriesGetById(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().storiesGetById();
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("stories", stories),
                keyVal("extended", extended, true),
                keyVal("fields", fields)
        );
    }

    @Override
    protected Class<? extends StoriesListResult> getResultType() {
        return StoriesListResult.class;
    }

    public StoriesGetById setStories(List<String> stories) {
        this.stories = stories;
        return this;
    }

    public StoriesGetById setExtended(Boolean extended) {
        this.extended = extended;
        return this;
    }

    public StoriesGetById setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }
}
