package api.longpoll.bots.methods.stories;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.methods.VkApi;

/**
 * Implements <b>stories.getVideoUploadServer</b> method.
 *
 * @see <a href="https://vk.com/dev/stories.getVideoUploadServer">https://vk.com/dev/stories.getVideoUploadServer</a>
 */
public class StoriesGetVideoUploadServer extends StoriesGetPhotoUploadServer {
    public StoriesGetVideoUploadServer(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().storiesGetVideoUploadServer();
    }
}
