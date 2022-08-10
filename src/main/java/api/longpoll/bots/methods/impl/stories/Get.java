package api.longpoll.bots.methods.impl.stories;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.additional.StoriesFeedBlock;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.response.GenericResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>stories.get</b> method.
 * <p>
 * Returns stories available for current user.
 *
 * @see <a href="https://vk.com/dev/stories.get">https://vk.com/dev/stories.get</a>
 */
public class Get extends VkMethod<Get.ResponseBody> {
    public Get(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUri() {
        return property("stories.get");
    }

    @Override
    protected Class<ResponseBody> getResponseType() {
        return ResponseBody.class;
    }

    public Get setOwnerId(int ownerId) {
        return addParam("owner_id", ownerId);
    }

    public Get setExtended(boolean extended) {
        return addParam("extended", extended ? 1 : 0);
    }

    public Get setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public Get setFields(List<String> fields) {
        return addParam("fields", csv(fields));
    }

    @Override
    public Get addParam(String key, Object value) {
        return (Get) super.addParam(key, value);
    }

    /**
     * Response to <b>stories.get</b>
     */
    public static class ResponseBody extends GenericResponseBody<VkList<StoriesFeedBlock>> {
    }
}
