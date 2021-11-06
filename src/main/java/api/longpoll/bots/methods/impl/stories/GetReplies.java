package api.longpoll.bots.methods.impl.stories;

import api.longpoll.bots.config.VkBotsConfig;
import api.longpoll.bots.converter.Converter;
import api.longpoll.bots.methods.AuthorizedVkMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.objects.additional.StoriesFeedBlock;
import api.longpoll.bots.model.response.ExtendedVkList;
import api.longpoll.bots.model.response.GenericResponse;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>stories.getReplies</b> method.
 * <p>
 * Returns replies to the story.
 *
 * @see <a href="https://vk.com/dev/stories.getReplies">https://vk.com/dev/stories.getReplies</a>
 */
public class GetReplies extends AuthorizedVkMethod<GetReplies.Response> {
    private final Converter<Boolean, Integer> boolIntConverter = VkBotsConfig.getInstance().getBoolIntConverter();
    private final Converter<List<?>, String> listConverter = VkBotsConfig.getInstance().getListConverter();

    public GetReplies(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VkApiProperties.get("stories.getReplies");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetReplies setOwnerId(int ownerId) {
        return addParam("owner_id", ownerId);
    }

    public GetReplies setStoryId(int storyId) {
        return addParam("story_id", storyId);
    }

    public GetReplies setAccessKey(String accessKey) {
        return addParam("access_key", accessKey);
    }

    public GetReplies setExtended(boolean extended) {
        return addParam("extended", boolIntConverter.convert(extended));
    }

    public GetReplies setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetReplies setFields(List<String> fields) {
        return addParam("fields", listConverter.convert(fields));
    }

    @Override
    public GetReplies addParam(String key, Object value) {
        return (GetReplies) super.addParam(key, value);
    }

    /**
     * Response to <b>stories.getReplies</b>
     */
    public static class Response extends GenericResponse<ExtendedVkList<StoriesFeedBlock>> {
    }
}
