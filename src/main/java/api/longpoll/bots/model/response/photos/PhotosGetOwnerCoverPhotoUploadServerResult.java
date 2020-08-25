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
