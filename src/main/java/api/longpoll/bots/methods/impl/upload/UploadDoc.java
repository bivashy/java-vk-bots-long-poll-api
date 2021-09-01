package api.longpoll.bots.methods.impl.upload;

import api.longpoll.bots.model.objects.media.FileType;
import com.google.gson.annotations.SerializedName;

/**
 * Implements uploading document in VK API.
 */
public class UploadDoc extends AbstractUploadMethod<UploadDoc.Response> {
    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    @Override
    protected FileType getType() {
        return FileType.FILE;
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
