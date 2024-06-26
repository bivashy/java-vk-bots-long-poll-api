package api.longpoll.bots.methods.impl.stories;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.additional.Story;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.response.GenericResponseBody;
import api.longpoll.bots.utils.VkMethods;

/**
 * Implements <b>stories.save</b> method.
 *
 * @see <a href="https://vk.com/dev/stories.save">https://vk.com/dev/stories.save</a>
 */
public class Save extends VkMethod<Save.ResponseBody> {
    public Save(String accessToken) {
        super(VkMethods.get("stories.save"), accessToken);
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    public Save setUploadResults(String uploadResults) {
        return addParam("upload_results", uploadResults);
    }

    @Override
    public Save addParam(String key, Object value) {
        return (Save) super.addParam(key, value);
    }

    /**
     * Response to <b>stories.get</b>
     */
    public static class ResponseBody extends GenericResponseBody<VkList<Story>> {
    }
}
