package api.longpoll.bots.methods.impl.upload;

import api.longpoll.bots.model.objects.media.UploadTypes;
import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.io.InputStream;

/**
 * Implements uploading story in VK API.
 */
public class UploadStory extends UploadMethod<UploadStory.ResponseBody> {
    public UploadStory(String uploadUrl, String filename, InputStream story) {
        super(uploadUrl, UploadTypes.VIDEO_FILE, filename, story);
    }

    public UploadStory(String uploadUrl, String filename, byte[] story) {
        super(uploadUrl, UploadTypes.VIDEO_FILE, filename, story);
    }

    public UploadStory(String uploadUrl, File story) {
        super(uploadUrl, UploadTypes.VIDEO_FILE, story);
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    /**
     * Response to story uploading.
     */
    public static class ResponseBody {
        @SerializedName("upload_result")
        private String uploadResult;

        public String getUploadResult() {
            return uploadResult;
        }

        public void setUploadResult(String uploadResult) {
            this.uploadResult = uploadResult;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "uploadResult='" + uploadResult + '\'' +
                    '}';
        }
    }
}
