package api.longpoll.bots.model.response.other;

import com.google.gson.annotations.SerializedName;

/**
 * Result to story uploading.
 */
public class UploadStoryResult {
    @SerializedName("upload_result")
    private String uploadResult;

    public String getUploadResult() {
        return uploadResult;
    }

    public void setUploadResult(String uploadResult) {
        this.uploadResult = uploadResult;
    }
}
