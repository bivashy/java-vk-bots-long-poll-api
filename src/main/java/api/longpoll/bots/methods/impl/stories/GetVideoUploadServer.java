package api.longpoll.bots.methods.impl.stories;

import api.longpoll.bots.methods.impl.VkMethod;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>stories.getVideoUploadServer</b> method.
 * <p>
 * Allows receiving URL for uploading story with video.
 *
 * @see <a href="https://vk.com/dev/stories.getVideoUploadServer">https://vk.com/dev/stories.getVideoUploadServer</a>
 */
public class GetVideoUploadServer extends VkMethod<GetVideoUploadServer.ResponseBody> {
    public GetVideoUploadServer(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUri() {
        return property("stories.getVideoUploadServer");
    }

    @Override
    protected Class<ResponseBody> getResponseType() {
        return ResponseBody.class;
    }

    public GetVideoUploadServer setAddToNews(boolean addToNews) {
        return addParam("add_to_news", addToNews ? 1 : 0);
    }

    public GetVideoUploadServer setReplyToStory(String replyToStory) {
        return addParam("reply_to_story", replyToStory);
    }

    public GetVideoUploadServer setLinkText(String linkText) {
        return addParam("link_text", linkText);
    }

    public GetVideoUploadServer setLinkUrl(String linkUrl) {
        return addParam("link_url", linkUrl);
    }

    public GetVideoUploadServer setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public GetVideoUploadServer setClickableStickers(String clickableStickers) {
        return addParam("clickable_stickers", clickableStickers);
    }

    public GetVideoUploadServer setUserIds(Integer... userIds) {
        return setUserIds(Arrays.asList(userIds));
    }

    public GetVideoUploadServer setUserIds(List<Integer> userIds) {
        return addParam("user_ids", csv(userIds));
    }

    @Override
    public GetVideoUploadServer addParam(String key, Object value) {
        return (GetVideoUploadServer) super.addParam(key, value);
    }

    /**
     * Response to <b>stories.getVideoUploadServer</b> and <b>stories.getVideoUploadServer</b>
     */
    public static class ResponseBody extends GetPhotoUploadServer.ResponseBody {
    }
}
