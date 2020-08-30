package api.longpoll.bots.model.response.other;

import com.google.gson.annotations.SerializedName;

/**
 * Response to document uploading.
 */
public class UploadDocResult {
    /**
     * Uploaded file.
     */
    @SerializedName("file")
    private String file;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
