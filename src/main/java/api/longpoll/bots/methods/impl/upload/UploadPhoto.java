package api.longpoll.bots.methods.impl.upload;

import api.longpoll.bots.model.objects.media.UploadTypes;
import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.io.InputStream;

/**
 * Implements uploading photo in VK API.
 */
public class UploadPhoto extends UploadMethod<UploadPhoto.ResponseBody> {
    public UploadPhoto(String uploadUrl, String filename, InputStream photo) {
        super(uploadUrl, UploadTypes.PHOTO, filename, photo);
    }

    public UploadPhoto(String uploadUrl, String filename, byte[] photo) {
        super(uploadUrl, UploadTypes.PHOTO, filename, photo);
    }

    public UploadPhoto(String uploadUrl, File photo) {
        super(uploadUrl, UploadTypes.PHOTO, photo);
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    /**
     * Response to photo upload.
     */
    public static class ResponseBody {
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
