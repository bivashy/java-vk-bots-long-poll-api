package api.longpoll.bots.methods.stories;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.CachedConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.additional.StoriesFeedBlock;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.response.GenericResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>stories.get</b> method.
 *
 * @see <a href="https://vk.com/dev/stories.get">https://vk.com/dev/stories.get</a>
 */
public class StoriesGet extends GetMethod<GenericResult<VkList<StoriesFeedBlock>>> {
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

    public StoriesGet(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().storiesGet();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<VkList<StoriesFeedBlock>>> getConverter() {
        return CachedConverterFactory.getConverter(GenericResult.class, VkList.class, StoriesFeedBlock.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("owner_id", ownerId),
                keyVal("extended", extended, true),
                keyVal("fields", fields)
        );
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public StoriesGet setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public Boolean getExtended() {
        return extended;
    }

    public StoriesGet setExtended(Boolean extended) {
        this.extended = extended;
        return this;
    }

    public List<String> getFields() {
        return fields;
    }

    public StoriesGet setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }
}
