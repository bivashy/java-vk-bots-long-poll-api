package api.longpoll.bots.methods.stories;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.JsonToPojoConverterFactory;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.additional.StoriesFeedBlock;
import api.longpoll.bots.model.response.ExtendedVkList;
import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>stories.getReplies</b> method.
 *
 * @see <a href="https://vk.com/dev/stories.getReplies">https://vk.com/dev/stories.getReplies</a>
 */
public class StoriesGetReplies extends GetMethod<GenericResult<ExtendedVkList<StoriesFeedBlock>>> {
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
    protected JsonToPojoConverter<GenericResult<ExtendedVkList<StoriesFeedBlock>>> getConverter() {
        return JsonToPojoConverterFactory.get(new TypeToken<GenericResult<ExtendedVkList<StoriesFeedBlock>>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("owner_id", ownerId),
                keyVal("story_id", storyId),
                keyVal("access_key", accessKey),
                keyVal("extended", extended, true),
                keyVal("fields", fields)
        );
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public StoriesGetReplies setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public Integer getStoryId() {
        return storyId;
    }

    public StoriesGetReplies setStoryId(Integer storyId) {
        this.storyId = storyId;
        return this;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public StoriesGetReplies setAccessKey(String accessKey) {
        this.accessKey = accessKey;
        return this;
    }

    public Boolean getExtended() {
        return extended;
    }

    public StoriesGetReplies setExtended(Boolean extended) {
        this.extended = extended;
        return this;
    }

    public List<String> getFields() {
        return fields;
    }

    public StoriesGetReplies setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }
}
