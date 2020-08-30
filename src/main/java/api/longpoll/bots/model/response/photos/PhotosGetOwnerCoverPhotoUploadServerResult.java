package api.longpoll.bots.model.response.photos;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>photos.getOwnerCoverPhotoUploadServer</b> request.
 */
public class PhotosGetOwnerCoverPhotoUploadServerResult {
    /**
     * Response object.
     */
    @SerializedName("response")
    private Response response;

    /**
     * Describes response.
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
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
