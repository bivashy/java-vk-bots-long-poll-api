package api.longpoll.bots.model.response.photos;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>photos.getMessagesUploadServer</b> request.
 */
public class PhotosGetMessagesUploadServerResult {
    /**
     * Response object.
     */
    @SerializedName("response")
    private Response response;

    /**
     * Describes response.
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
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
