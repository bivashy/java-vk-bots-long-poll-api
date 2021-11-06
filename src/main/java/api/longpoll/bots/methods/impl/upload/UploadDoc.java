package api.longpoll.bots.methods.impl.upload;

import api.longpoll.bots.http.MultipartFormData;
import api.longpoll.bots.model.objects.media.FileType;
import com.google.gson.annotations.SerializedName;

import java.io.InputStream;

/**
 * Implements uploading document in VK API.
 */
public class UploadDoc extends UploadMethod<UploadDoc.Response> {
    @Override
    public UploadDoc setUrl(String uploadUrl) {
        return (UploadDoc) super.setUrl(uploadUrl);
    }

    public UploadDoc setDoc(InputStream doc) {
        return (UploadDoc) super.setMultipartFormData(new MultipartFormData(
                FileType.FILE,
                "doc",
                doc
        ));
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
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
