package api.longpoll.bots.methods.impl.upload;

import api.longpoll.bots.methods.FileUploadingVkApiMethod;
import api.longpoll.bots.model.objects.media.FileType;
import com.google.gson.annotations.SerializedName;

/**
 * Implements uploading document in VK API.
 */
public class UploadDoc extends FileUploadingVkApiMethod<UploadDoc.Response> {
    /**
     * Upload URL.
     */
    private String uploadUrl;

    @Override
    protected String getUrl() {
        return uploadUrl;
    }

    @Override
    protected Class<Response> getResultType() {
        return Response.class;
    }

    @Override
    protected FileType getType() {
        return FileType.FILE;
    }

    public UploadDoc setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
        return this;
    }

    /**
     * Response to document uploading.
     */
    public static class Response {
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

        @Override
        public String toString() {
            return "Response{" +
                    "file='" + file + '\'' +
                    '}';
        }
    }
}
