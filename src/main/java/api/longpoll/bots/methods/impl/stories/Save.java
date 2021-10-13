package api.longpoll.bots.methods.impl.stories;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.objects.additional.Story;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.response.GenericResponse;

/**
 * Implements <b>stories.save</b> method.
 *
 * @see <a href="https://vk.com/dev/stories.save">https://vk.com/dev/stories.save</a>
 */
public class Save extends AuthorizedVkApiMethod<Save.Response> {
    public Save(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("stories.save");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
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
    public class Response extends GenericResponse<VkList<Story>> {
    }
}
