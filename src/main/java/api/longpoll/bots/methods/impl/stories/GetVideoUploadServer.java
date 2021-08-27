package api.longpoll.bots.methods.impl.stories;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>stories.getVideoUploadServer</b> method.
 * <p>
 * Allows receiving URL for uploading story with video.
 *
 * @see <a href="https://vk.com/dev/stories.getVideoUploadServer">https://vk.com/dev/stories.getVideoUploadServer</a>
 */
public class GetVideoUploadServer extends AuthorizedVkApiMethod<GetVideoUploadServer.Response> {
    public GetVideoUploadServer(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("stories.getVideoUploadServer");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetVideoUploadServer setAddToNews(boolean addToNews) {
        addParam("add_to_news", new BoolInt(addToNews));
        return this;
    }

    public GetVideoUploadServer setReplyToStory(String replyToStory) {
        addParam("reply_to_story", replyToStory);
        return this;
    }

    public GetVideoUploadServer setLinkText(String linkText) {
        addParam("link_text", linkText);
        return this;
    }

    public GetVideoUploadServer setLinkUrl(String linkUrl) {
        addParam("link_url", linkUrl);
        return this;
    }

    public GetVideoUploadServer setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }

    public GetVideoUploadServer setClickableStickers(String clickableStickers) {
        addParam("clickable_stickers", clickableStickers);
        return this;
    }

    public GetVideoUploadServer setUserIds(Integer... userIds) {
        return setUserIds(Arrays.asList(userIds));
    }

    public GetVideoUploadServer setUserIds(List<Integer> userIds) {
        addParam("user_ids", userIds);
        return this;
    }

    /**
     * Response to <b>stories.getVideoUploadServer</b> and <b>stories.getVideoUploadServer</b>
     */
    public static class Response extends GetPhotoUploadServer.Response {
    }
}
