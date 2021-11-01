package api.longpoll.bots.methods.impl.photos;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.objects.additional.PhotoSize;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Implements <b>photos.saveMessagesPhoto</b> method.
 * <p>
 * Saves a photo after being successfully uploaded. URL obtained with photos.getMessagesUploadServer method.
 *
 * @see <a href="https://vk.com/dev/photos.saveMessagesPhoto">https://vk.com/dev/photos.saveMessagesPhoto</a>
 */
public class SaveMessagesPhoto extends AuthorizedVkApiMethod<SaveMessagesPhoto.Response> {
    public SaveMessagesPhoto(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("photos.saveMessagesPhoto");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public SaveMessagesPhoto setPhoto(String photo) {
        return addParam("photo", photo);
    }

    public SaveMessagesPhoto setServer(Integer server) {
        return addParam("server", server);
    }

    public SaveMessagesPhoto setHash(String hash) {
        return addParam("hash", hash);
    }

    @Override
    public SaveMessagesPhoto addParam(String key, Object value) {
        return (SaveMessagesPhoto) super.addParam(key, value);
    }

    /**
     * Response to <b>photos.saveMessagesPhoto</b> request.
     */
    public static class Response extends GenericResponse<List<Response.ResponseObject>> {
        /**
         * Response object.
         */
        public static class ResponseObject {
            /**
             * Album ID.
             */
            @SerializedName("album_id")
            private Integer albumId;

            /**
             * Saved date.
             */
            @SerializedName("date")
            private Integer date;

            /**
             * Photo ID.
             */
            @SerializedName("id")
            private Integer id;

            /**
             * Photo owner ID.
             */
            @SerializedName("owner_id")
            private Integer ownerId;

            /**
             * <b>true</b> if photo has tags.
             */
            @SerializedName("has_tags")
            private Boolean hasTags;

            /**
             * Access key.
             */
            @SerializedName("access_key")
            private String accessKey;

            /**
             * Photo copies.
             */
            @SerializedName("photoSizes")
            private List<PhotoSize> photoSizes;

            public Integer getAlbumId() {
                return albumId;
            }

            public void setAlbumId(Integer albumId) {
                this.albumId = albumId;
            }

            public Integer getDate() {
                return date;
            }

            public void setDate(Integer date) {
                this.date = date;
            }

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getOwnerId() {
                return ownerId;
            }

            public void setOwnerId(Integer ownerId) {
                this.ownerId = ownerId;
            }

            public Boolean getHasTags() {
                return hasTags;
            }

            public void setHasTags(Boolean hasTags) {
                this.hasTags = hasTags;
            }

            public String getAccessKey() {
                return accessKey;
            }

            public void setAccessKey(String accessKey) {
                this.accessKey = accessKey;
            }

            public List<PhotoSize> getPhotoSizes() {
                return photoSizes;
            }

            public void setPhotoSizes(List<PhotoSize> photoSizes) {
                this.photoSizes = photoSizes;
            }

            @Override
            public String toString() {
                return "ResponseObject{" +
                        "albumId=" + albumId +
                        ", date=" + date +
                        ", id=" + id +
                        ", ownerId=" + ownerId +
                        ", hasTags=" + hasTags +
                        ", accessKey='" + accessKey + '\'' +
                        ", photoSizes=" + photoSizes +
                        '}';
            }
        }
    }
}
