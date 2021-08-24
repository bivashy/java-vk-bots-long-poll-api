package api.longpoll.bots.methods.stories;

import api.longpoll.bots.methods.VkApiProperties;

/**
 * Implements <b>stories.getVideoUploadServer</b> method.
 *
 * Allows to receive URL for uploading story with video.
 *
 * @see <a href="https://vk.com/dev/stories.getVideoUploadServer">https://vk.com/dev/stories.getVideoUploadServer</a>
 */
public class StoriesGetVideoUploadServer extends StoriesGetPhotoUploadServer {
    public StoriesGetVideoUploadServer(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApiProperties.get("stories.getVideoUploadServer");
    }
}
