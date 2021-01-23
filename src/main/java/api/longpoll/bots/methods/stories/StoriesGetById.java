package api.longpoll.bots.methods.stories;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.CachedConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.additional.Story;
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
public class StoriesGetById extends GetMethod<GenericResult<VkList<Story>>> {
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

    public StoriesGetById(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().storiesGetById();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<VkList<Story>>> getConverter() {
        return CachedConverterFactory.getConverter(GenericResult.class, VkList.class, Story.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("stories", stories),
                keyVal("extended", extended, true),
                keyVal("fields", fields)
        );
    }

    public List<String> getStories() {
        return stories;
    }

    public StoriesGetById setStories(List<String> stories) {
        this.stories = stories;
        return this;
    }

    public Boolean getExtended() {
        return extended;
    }

    public StoriesGetById setExtended(Boolean extended) {
        this.extended = extended;
        return this;
    }

    public List<String> getFields() {
        return fields;
    }

    public StoriesGetById setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }
}
