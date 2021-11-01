package api.longpoll.bots.methods.impl.stories;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.objects.additional.Story;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.response.GenericResponse;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>stories.get</b> method.
 * <p>
 * Returns stories available for current user.
 *
 * @see <a href="https://vk.com/dev/stories.get">https://vk.com/dev/stories.get</a>
 */
public class GetById extends AuthorizedVkApiMethod<GetById.Response> {
    public GetById(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("stories.getById");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetById setStories(String... stories) {
        return setStories(Arrays.asList(stories));
    }

    public GetById setStories(List<String> stories) {
        return addParam("stories", stories);
    }

    public GetById setExtended(boolean extended) {
        return addParam("extended", new BoolInt(extended));
    }

    public GetById setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetById setFields(List<String> fields) {
        return addParam("fields", fields);
    }

    @Override
    public GetById addParam(String key, Object value) {
        return (GetById) super.addParam(key, value);
    }

    /**
     * Response to <b>stories.get</b>
     */
    public static class Response extends GenericResponse<VkList<Story>> {
    }
}
