package api.longpoll.bots.methods.impl.upload;

import api.longpoll.bots.methods.FileUploadingVkApiMethod;
import api.longpoll.bots.model.objects.media.FileType;
import com.google.gson.annotations.SerializedName;

/**
 * Implements uploading story in VK API.
 */
public class UploadStory extends FileUploadingVkApiMethod<UploadStory.Response> {
    /**
     * Upload URL.
     */
    private String uploadUrl;

    @Override
    protected FileType getType() {
        return FileType.VIDEO_FILE;
    }

    @Override
    protected String getUrl() {
        return uploadUrl;
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public UploadStory setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
        return this;
    }

    /**
     * Response to story uploading.
     */
    public static class Response {
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
