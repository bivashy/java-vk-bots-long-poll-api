package api.longpoll.bots.methods.impl.stories;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.additional.StoriesFeedBlock;
import api.longpoll.bots.model.response.ExtendedVkList;
import api.longpoll.bots.model.response.GenericResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>stories.getReplies</b> method.
 * <p>
 * Returns replies to the story.
 *
 * @see <a href="https://vk.com/dev/stories.getReplies">https://vk.com/dev/stories.getReplies</a>
 */
public class GetReplies extends VkMethod<GetReplies.ResponseBody> {
    public GetReplies(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUri() {
        return VK_METHODS.getProperty("stories.getReplies");
    }

    @Override
    protected Class<ResponseBody> getResponseType() {
        return ResponseBody.class;
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
        return addParam("extended", extended ? 1 : 0);
    }

    public GetReplies setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetReplies setFields(List<String> fields) {
        return addParam("fields", toCSV(fields));
    }

    @Override
    public GetReplies addParam(String key, Object value) {
        return (GetReplies) super.addParam(key, value);
    }

    /**
     * Response to <b>stories.getReplies</b>
     */
    public static class ResponseBody extends GenericResponseBody<ExtendedVkList<StoriesFeedBlock>> {
    }
}
