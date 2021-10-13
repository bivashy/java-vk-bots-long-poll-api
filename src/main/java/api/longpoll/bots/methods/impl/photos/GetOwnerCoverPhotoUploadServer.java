package api.longpoll.bots.methods.impl.photos;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>photos.getOwnerCoverPhotoUploadServer</b> method.
 * <p>
 * Receives server address for uploading community cover.
 *
 * @see <a href="https://vk.com/dev/photos.getOwnerCoverPhotoUploadServer">https://vk.com/dev/photos.getOwnerCoverPhotoUploadServer</a>
 */
public class GetOwnerCoverPhotoUploadServer extends AuthorizedVkApiMethod<GetOwnerCoverPhotoUploadServer.Response> {
    public GetOwnerCoverPhotoUploadServer(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("photos.getOwnerCoverPhotoUploadServer");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetOwnerCoverPhotoUploadServer setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public GetOwnerCoverPhotoUploadServer setCropX(int cropX) {
        return addParam("crop_x", cropX);
    }

    public GetOwnerCoverPhotoUploadServer setCropY(int cropY) {
        return addParam("crop_y", cropY);
    }

    public GetOwnerCoverPhotoUploadServer setCropX2(int cropX2) {
        return addParam("crop_x2", cropX2);
    }

    public GetOwnerCoverPhotoUploadServer setCropY2(int cropY2) {
        return addParam("crop_y2", cropY2);
    }

    @Override
    public GetOwnerCoverPhotoUploadServer addParam(String key, Object value) {
        return (GetOwnerCoverPhotoUploadServer) super.addParam(key, value);
    }

    /**
     * Response to <b>photos.getOwnerCoverPhotoUploadServer</b> request.
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

            public String getUploadUrl() {
                return uploadUrl;
            }

            public void setUploadUrl(String uploadUrl) {
                this.uploadUrl = uploadUrl;
            }

            @Override
            public String toString() {
                return "ResponseObject{" +
                        "uploadUrl='" + uploadUrl + '\'' +
                        '}';
            }
        }
    }
}
