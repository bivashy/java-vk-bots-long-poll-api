package api.longpoll.bots.methods.stories;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.stories.StoriesGetResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>stories.get</b> method.
 *
 * @see <a href="https://vk.com/dev/stories.get">https://vk.com/dev/stories.get</a>
 */
public class StoriesGet extends VkApiGetMethod<StoriesGetResult> {
    /**
     * Owner ID.
     */
    private Integer ownerId;

    /**
     * To return additional fields for users and communities.
     */
    private Boolean extended;

    /**
     * Additional fields of profiles and communities to return.
     */
    private List<String> fields;

    public StoriesGet(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().storiesGet();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("owner_id", ownerId),
                param("extended", extended, true),
                param("fields", fields)
        );
    }

    @Override
    protected Class<? extends StoriesGetResult> getResultType() {
        return StoriesGetResult.class;
    }

    public StoriesGet setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public StoriesGet setExtended(Boolean extended) {
        this.extended = extended;
        return this;
    }

    public StoriesGet setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }
}
