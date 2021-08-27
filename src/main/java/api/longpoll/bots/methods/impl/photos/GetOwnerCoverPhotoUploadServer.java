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
    protected Class<Response> getResultType() {
        return Response.class;
    }

    public GetOwnerCoverPhotoUploadServer setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }

    public GetOwnerCoverPhotoUploadServer setCropX(int cropX) {
        addParam("crop_x", cropX);
        return this;
    }

    public GetOwnerCoverPhotoUploadServer setCropY(int cropY) {
        addParam("crop_y", cropY);
        return this;
    }

    public GetOwnerCoverPhotoUploadServer setCropX2(int cropX2) {
        addParam("crop_x2", cropX2);
        return this;
    }

    public GetOwnerCoverPhotoUploadServer setCropY2(int cropY2) {
        addParam("crop_y2", cropY2);
        return this;
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
