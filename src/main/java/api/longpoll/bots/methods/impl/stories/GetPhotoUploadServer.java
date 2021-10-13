package api.longpoll.bots.methods.impl.stories;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>stories.getPhotoUploadServer</b> method.
 * <p>
 * Returns URL for uploading a story with photo.
 *
 * @see <a href="https://vk.com/dev/stories.getPhotoUploadServer">https://vk.com/dev/stories.getPhotoUploadServer</a>
 */
public class GetPhotoUploadServer extends AuthorizedVkApiMethod<GetPhotoUploadServer.Response> {
    public GetPhotoUploadServer(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("stories.getPhotoUploadServer");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetPhotoUploadServer setAddToNews(boolean addToNews) {
        return addParam("add_to_news", new BoolInt(addToNews));
    }

    public GetPhotoUploadServer setReplyToStory(String replyToStory) {
        return addParam("reply_to_story", replyToStory);
    }

    public GetPhotoUploadServer setLinkText(String linkText) {
        return addParam("link_text", linkText);
    }

    public GetPhotoUploadServer setLinkUrl(String linkUrl) {
        return addParam("link_url", linkUrl);
    }

    public GetPhotoUploadServer setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public GetPhotoUploadServer setClickableStickers(String clickableStickers) {
        return addParam("clickable_stickers", clickableStickers);
    }

    public GetPhotoUploadServer setUserIds(Integer... userIds) {
        return setUserIds(Arrays.asList(userIds));
    }

    public GetPhotoUploadServer setUserIds(List<Integer> userIds) {
        return addParam("user_ids", userIds);
    }

    @Override
    public GetPhotoUploadServer addParam(String key, Object value) {
        return (GetPhotoUploadServer) super.addParam(key, value);
    }

    /**
     * Response to <b>stories.getPhotoUploadServer</b> and <b>stories.getVideoUploadServer</b>
     */
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject {
            /**
             * Upload URL.
             */
            @SerializedName("upload_url")
            private Integer uploadUrl;

            /**
             * Users ID who can to see story.
             */
            @SerializedName("user_ids")
            private List<Integer> userIds;

            public Integer getUploadUrl() {
                return uploadUrl;
            }

            public void setUploadUrl(Integer uploadUrl) {
                this.uploadUrl = uploadUrl;
            }

            public List<Integer> getUserIds() {
                return userIds;
            }

            public void setUserIds(List<Integer> userIds) {
                this.userIds = userIds;
            }

            @Override
            public String toString() {
                return "ResponseObject{" +
                        "uploadUrl=" + uploadUrl +
                        ", userIds=" + userIds +
                        '}';
            }
        }
    }
}
