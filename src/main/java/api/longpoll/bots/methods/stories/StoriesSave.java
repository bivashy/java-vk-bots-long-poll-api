package api.longpoll.bots.methods.stories;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.stories.StoriesListResult;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>stories.save</b> method.
 *
 * @see <a href="https://vk.com/dev/stories.save">https://vk.com/dev/stories.save</a>
 */
public class StoriesSave extends VkApiGetMethod<StoriesListResult> {
    private String uploadResults;

    public StoriesSave(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().storiesSave();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(param("upload_results", uploadResults));
    }

    @Override
    protected Class<? extends StoriesListResult> getResultType() {
        return StoriesListResult.class;
    }

    public StoriesSave setUploadResults(String uploadResults) {
        this.uploadResults = uploadResults;
        return this;
    }
}
