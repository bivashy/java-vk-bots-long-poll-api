package api.longpoll.bots.methods.impl.photos;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>photos.getMessagesUploadServer</b> method.
 * <p>
 * Returns the server address for photo upload in a private message for a user.
 *
 * @see <a href="https://vk.com/dev/photos.getMessagesUploadServer">https://vk.com/dev/photos.getMessagesUploadServer</a>
 */
public class GetMessagesUploadServer extends AuthorizedVkApiMethod<GetMessagesUploadServer.Response> {
    public GetMessagesUploadServer(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("photos.getMessagesUploadServer");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetMessagesUploadServer setPeerId(int peerId) {
        return addParam("peer_id", peerId);
    }

    @Override
    public GetMessagesUploadServer addParam(String key, Object value) {
        return (GetMessagesUploadServer) super.addParam(key, value);
    }

    /**
     * Response to <b>photos.getMessagesUploadServer</b> request.
     */
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject {
            /**
             * Photo upload URL.
             */
            @SerializedName("upload_url")
            private String uploadUrl;

            /**
             * Album ID.
             */
            @SerializedName("album_id")
            private Integer albumId;

            /**
             * Group ID.
             */
            @SerializedName("group_id")
            private Integer groupId;

            public String getUploadUrl() {
                return uploadUrl;
            }

            public void setUploadUrl(String uploadUrl) {
                this.uploadUrl = uploadUrl;
            }

            public Integer getAlbumId() {
                return albumId;
            }

            public void setAlbumId(Integer albumId) {
                this.albumId = albumId;
            }

            public Integer getGroupId() {
                return groupId;
            }

            public void setGroupId(Integer groupId) {
                this.groupId = groupId;
            }

            @Override
            public String toString() {
                return "ResponseObject{" +
                        "uploadUrl='" + uploadUrl + '\'' +
                        ", albumId=" + albumId +
                        ", groupId=" + groupId +
                        '}';
            }
        }
    }
}
