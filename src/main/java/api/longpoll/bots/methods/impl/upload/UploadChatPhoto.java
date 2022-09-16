package api.longpoll.bots.methods.impl.upload;

import api.longpoll.bots.model.objects.media.FileType;
import com.google.gson.annotations.SerializedName;

import java.io.InputStream;

/**
 * Uploads chat photo.
 */
public class UploadChatPhoto extends UploadMethod<UploadChatPhoto.ResponseBody> {
    public UploadChatPhoto(String uri, String filename, InputStream inputStream) {
        super(uri, FileType.FILE, filename, inputStream);
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    /**
     * Response to chat photo uploading.
     */
    public static class ResponseBody {
        /**
         * Response.
         */
        @SerializedName("response")
        private String response;

        public String getResponse() {
            return response;
        }

        public void setResponse(String response) {
            this.response = response;
        }


        @Override
        public String toString() {
            return "Response{" +
                    "response='" + response + '\'' +
                    '}';
        }
    }
}
