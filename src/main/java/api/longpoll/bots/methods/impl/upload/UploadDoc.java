package api.longpoll.bots.methods.impl.upload;

import api.longpoll.bots.model.objects.media.UploadTypes;
import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.io.InputStream;

/**
 * Implements uploading document in VK API.
 */
public class UploadDoc extends UploadMethod<UploadDoc.ResponseBody> {

    public UploadDoc(String uri, String filename, InputStream doc) {
        super(uri, UploadTypes.FILE, filename, doc);
    }

    public UploadDoc(String url, String filename, byte[] doc) {
        super(url, UploadTypes.FILE, filename, doc);
    }

    public UploadDoc(String url, File doc) {
        super(url, UploadTypes.FILE, doc);
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
