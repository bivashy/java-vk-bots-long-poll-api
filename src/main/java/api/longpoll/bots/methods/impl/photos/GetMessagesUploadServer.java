package api.longpoll.bots.methods.impl.photos;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.GenericResponseBody;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>photos.getMessagesUploadServer</b> method.
 * <p>
 * Returns the server address for photo upload in a private message for a user.
 *
 * @see <a href="https://vk.com/dev/photos.getMessagesUploadServer">https://vk.com/dev/photos.getMessagesUploadServer</a>
 */
public class GetMessagesUploadServer extends VkMethod<GetMessagesUploadServer.ResponseBody> {
    public GetMessagesUploadServer(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUri() {
        return property("photos.getMessagesUploadServer");
    }

    @Override
    protected Class<ResponseBody> getResponseType() {
        return ResponseBody.class;
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
    public static class ResponseBody extends GenericResponseBody<ResponseBody.Response> {
        /**
         * Response object.
         */
        public static class Response {
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
                return "Response{" +
                        "uploadUrl='" + uploadUrl + '\'' +
                        ", albumId=" + albumId +
                        ", groupId=" + groupId +
                        '}';
            }
        }
    }
}
