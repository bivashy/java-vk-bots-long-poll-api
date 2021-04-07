package api.longpoll.bots.model.response.docs;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>docs.getUploadServer</b> request.
 */
public class DocsGetUploadServerResponse {
    /**
     * Link to which the document can be uploaded.
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
        return "DocsGetUploadServerResponse{" +
                "uploadUrl='" + uploadUrl + '\'' +
                '}';
    }
}
