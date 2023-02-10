package api.longpoll.bots.methods.impl.stories;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.additional.Story;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.response.GenericResponseBody;
import api.longpoll.bots.utils.ParamUtils;
import api.longpoll.bots.utils.VkMethods;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>stories.get</b> method.
 * <p>
 * Returns stories available for current user.
 *
 * @see <a href="https://vk.com/dev/stories.get">https://vk.com/dev/stories.get</a>
 */
public class GetById extends VkMethod<GetById.ResponseBody> {
    public GetById(String accessToken) {
        super(VkMethods.get("stories.getById"), accessToken);
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    public GetById setStories(String... stories) {
        return setStories(Arrays.asList(stories));
    }

    public GetById setStories(Iterable<String> stories) {
        return addParam("stories", ParamUtils.csv(stories));
    }

    public GetById setExtended(boolean extended) {
        return addParam("extended", extended ? 1 : 0);
    }

    public GetById setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetById setFields(Iterable<String> fields) {
        return addParam("fields", ParamUtils.csv(fields));
    }

    @Override
    public GetById addParam(String key, Object value) {
        return (GetById) super.addParam(key, value);
    }

    /**
     * Response to <b>stories.get</b>
     */
    public static class ResponseBody extends GenericResponseBody<VkList<Story>> {
    }
}
