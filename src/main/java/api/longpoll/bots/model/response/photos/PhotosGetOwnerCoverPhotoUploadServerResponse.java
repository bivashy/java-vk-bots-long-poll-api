package api.longpoll.bots.model.response.photos;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>photos.getOwnerCoverPhotoUploadServer</b> request.
 */
public class PhotosGetOwnerCoverPhotoUploadServerResponse {
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
        return "PhotosGetOwnerCoverPhotoUploadServerResponse{" +
                "uploadUrl='" + uploadUrl + '\'' +
                '}';
    }
}
