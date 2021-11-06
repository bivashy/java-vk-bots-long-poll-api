package api.longpoll.bots.methods.impl.upload;

import api.longpoll.bots.http.MultipartFormData;
import api.longpoll.bots.model.objects.media.FileType;
import com.google.gson.annotations.SerializedName;

import java.io.InputStream;

/**
 * Uploads chat photo.
 */
public class UploadChatPhoto extends UploadMethod<UploadChatPhoto.Response> {
    @Override
    public UploadChatPhoto setUrl(String uploadUrl) {
        return (UploadChatPhoto) super.setUrl(uploadUrl);
    }

    public UploadChatPhoto setChatPhoto(InputStream chatPhoto) {
        return (UploadChatPhoto) super.setMultipartFormData(new MultipartFormData(
                FileType.FILE,
                "chat_photo",
                chatPhoto
        ));
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
