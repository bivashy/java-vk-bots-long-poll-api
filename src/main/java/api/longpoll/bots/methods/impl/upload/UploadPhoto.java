package api.longpoll.bots.methods.impl.upload;

import api.longpoll.bots.model.objects.media.FileType;
import com.google.gson.annotations.SerializedName;

import java.io.InputStream;

/**
 * Implements uploading photo in VK API.
 */
public class UploadPhoto extends UploadMethod<UploadPhoto.Response> {
    public UploadPhoto(String uri, String filename, InputStream inputStream) {
        super(uri, FileType.PHOTO, filename, inputStream);
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    /**
     * Response to photo upload.
     */
    public static class Response {
        /**
         * Server ID.
         */
        @SerializedName("server")
        private Integer server;

        /**
         * Uploaded photo.
         */
        @SerializedName("photo")
        private String photo;

        /**
         * Hash.
         */
        @SerializedName("hash")
        private String hash;

        public Integer getServer() {
            return server;
        }

        public void setServer(Integer server) {
            this.server = server;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "server=" + server +
                    ", photo='" + photo + '\'' +
                    ", hash='" + hash + '\'' +
                    '}';
        }
    }
}
