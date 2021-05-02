package api.longpoll.bots.model.response.photos;

import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>photos.getMessagesUploadServer</b> request.
 */
public class PhotosGetMessagesUploadServerResult extends GenericResult<PhotosGetMessagesUploadServerResult.Response> {
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
