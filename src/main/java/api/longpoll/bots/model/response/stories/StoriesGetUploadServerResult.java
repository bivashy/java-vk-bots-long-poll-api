package api.longpoll.bots.model.response.stories;

import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Response to <b>stories.getPhotoUploadServer</b> and <b>stories.getVideoUploadServer</b>
 */
public class StoriesGetUploadServerResult extends GenericResult<StoriesGetUploadServerResult.Response> {
    /**
     * Response object.
     */
    public static class Response {
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
            return "Response{" +
                    "uploadUrl=" + uploadUrl +
                    ", userIds=" + userIds +
                    '}';
        }
    }
}
