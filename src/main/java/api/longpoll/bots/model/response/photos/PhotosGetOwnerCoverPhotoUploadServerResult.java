package api.longpoll.bots.model.response.photos;

import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>photos.getOwnerCoverPhotoUploadServer</b> request.
 */
public class PhotosGetOwnerCoverPhotoUploadServerResult extends GenericResult<PhotosGetOwnerCoverPhotoUploadServerResult.Response> {
    /**
     * Response object.
     */
    public static class Response {
        /**
         * Photo upload URL.
         */
        @SerializedName("upload_url")
        private String uploadUrl;

        public String getUploadUrl() {
            return uploadUrl;
        }

        public void setUploadUrl(String uploadUrl) {
            this.uploadUrl = uploadUrl;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "uploadUrl='" + uploadUrl + '\'' +
                    '}';
        }
    }
}
