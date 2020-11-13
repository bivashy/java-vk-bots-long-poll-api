package api.longpoll.bots.methods.stories;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.additional.Story;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>stories.save</b> method.
 *
 * @see <a href="https://vk.com/dev/stories.save">https://vk.com/dev/stories.save</a>
 */
public class StoriesSave extends GetMethod<GenericResult<VkList<Story>>> {
    private String uploadResults;

    public StoriesSave(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().storiesSave();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<VkList<Story>>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<VkList<Story>>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(keyVal("upload_results", uploadResults));
    }

    public String getUploadResults() {
        return uploadResults;
    }

    public StoriesSave setUploadResults(String uploadResults) {
        this.uploadResults = uploadResults;
        return this;
    }
}
