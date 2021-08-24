package api.longpoll.bots.methods.stories;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.stories.StoriesGetResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>stories.get</b> method.
 *
 * Returns stories available for current user.
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
        return VkApiProperties.get("stories.get");
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(
                keyVal("owner_id", ownerId),
                keyVal("extended", extended, true),
                keyVal("fields", fields)
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
