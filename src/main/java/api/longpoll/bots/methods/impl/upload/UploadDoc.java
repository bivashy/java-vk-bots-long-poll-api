package api.longpoll.bots.methods.impl.upload;

import api.longpoll.bots.model.objects.media.UploadTypes;
import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.io.InputStream;

/**
 * Implements uploading document in VK API.
 */
public class UploadDoc extends UploadMethod<UploadDoc.ResponseBody> {

    public UploadDoc(String uploadUrl, String filename, InputStream doc) {
        super(uploadUrl, UploadTypes.FILE, filename, doc);
    }

    public UploadDoc(String uploadUrl, String filename, byte[] doc) {
        super(uploadUrl, UploadTypes.FILE, filename, doc);
    }

    public UploadDoc(String uploadUrl, File doc) {
        super(uploadUrl, UploadTypes.FILE, doc);
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    /**
     * Response to document uploading.
     */
    public static class ResponseBody {
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
