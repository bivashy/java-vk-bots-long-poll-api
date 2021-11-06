package api.longpoll.bots.methods.impl.upload;

import api.longpoll.bots.http.MultipartFormData;
import api.longpoll.bots.model.objects.media.FileType;
import com.google.gson.annotations.SerializedName;

import java.io.InputStream;

/**
 * Implements uploading story in VK API.
 */
public class UploadStory extends UploadMethod<UploadStory.Response> {
    @Override
    public UploadStory setUrl(String uploadUrl) {
        return (UploadStory) super.setUrl(uploadUrl);
    }

    public UploadStory setStory(InputStream story) {
        return (UploadStory) super.setMultipartFormData(new MultipartFormData(
                FileType.VIDEO_FILE,
                "story",
                story
        ));
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
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
