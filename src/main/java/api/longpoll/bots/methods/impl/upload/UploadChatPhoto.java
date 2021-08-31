package api.longpoll.bots.methods.impl.upload;

import api.longpoll.bots.model.objects.media.FileType;
import com.google.gson.annotations.SerializedName;

/**
 * Uploads chat photo.
 */
public class UploadChatPhoto extends AbstractUploadMethod<UploadChatPhoto.Response> {
    @Override
    protected FileType getType() {
        return FileType.FILE;
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    /**
     * Response to chat photo uploading.
     */
    public static class Response {
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
