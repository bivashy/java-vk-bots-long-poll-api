package api.longpoll.bots.methods.impl.upload;

import api.longpoll.bots.model.objects.media.UploadTypes;
import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.io.InputStream;

/**
 * Uploads chat photo.
 */
public class UploadChatPhoto extends UploadMethod<UploadChatPhoto.ResponseBody> {
    public UploadChatPhoto(String uri, String filename, InputStream chatPhoto) {
        super(uri, UploadTypes.FILE, filename, chatPhoto);
    }

    public UploadChatPhoto(String uri, String filename, byte[] chatPhoto) {
        super(uri, UploadTypes.FILE, filename, chatPhoto);
    }

    public UploadChatPhoto(String uri, File chatPhoto) {
        super(uri, UploadTypes.FILE, chatPhoto);
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
