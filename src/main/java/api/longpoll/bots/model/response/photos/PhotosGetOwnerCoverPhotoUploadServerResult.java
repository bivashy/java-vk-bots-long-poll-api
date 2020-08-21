package api.longpoll.bots.model.response.photos;

import com.google.gson.annotations.SerializedName;

public class PhotosGetOwnerCoverPhotoUploadServerResult {
    @SerializedName("response")
    private Response response;

    public static class Response {
        @SerializedName("upload_url")
        private String uploadUrl;

        public String getUploadUrl() {
            return uploadUrl;
        }

        public Response setUploadUrl(String uploadUrl) {
            this.uploadUrl = uploadUrl;
            return this;
        }
    }

    public Response getResponse() {
        return response;
    }

    public PhotosGetOwnerCoverPhotoUploadServerResult setResponse(Response response) {
        this.response = response;
        return this;
    }
}
