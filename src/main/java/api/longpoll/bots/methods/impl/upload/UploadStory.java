package api.longpoll.bots.methods.impl.upload;

import api.longpoll.bots.model.objects.media.FileType;
import com.google.gson.annotations.SerializedName;

import java.io.InputStream;

/**
 * Implements uploading story in VK API.
 */
public class UploadStory extends UploadMethod<UploadStory.ResponseBody> {
    public UploadStory(String uri, String filename, InputStream inputStream) {
        super(uri, FileType.VIDEO_FILE, filename, inputStream);
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
