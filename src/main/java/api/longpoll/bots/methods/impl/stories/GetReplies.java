package api.longpoll.bots.methods.impl.stories;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
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
public class GetReplies extends AuthorizedVkApiMethod<GetReplies.Response> {
    public GetReplies(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("stories.getReplies");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetReplies setOwnerId(int ownerId) {
        addParam("owner_id", ownerId);
        return this;
    }

    public GetReplies setStoryId(int storyId) {
        addParam("story_id", storyId);
        return this;
    }

    public GetReplies setAccessKey(String accessKey) {
        addParam("access_key", accessKey);
        return this;
    }

    public GetReplies setExtended(boolean extended) {
        addParam("extended", new BoolInt(extended));
        return this;
    }

    public GetReplies setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetReplies setFields(List<String> fields) {
        addParam("fields", fields);
        return this;
    }

    /**
     * Response to <b>stories.getReplies</b>
     */
    public static class Response extends GenericResponse<ExtendedVkList<StoriesFeedBlock>> {
    }
}
