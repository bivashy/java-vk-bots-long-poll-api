package api.longpoll.bots.methods.impl.docs;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>docs.getMessagesUploadServer</b> method.
 * <p>
 * Returns the server address for document upload.
 *
 * @see <a href="https://vk.com/dev/docs.getMessagesUploadServer">https://vk.com/dev/docs.getMessagesUploadServer</a>
 */
public class GetMessagesUploadServer extends AuthorizedVkApiMethod<GetMessagesUploadServer.Response> {
    public GetMessagesUploadServer(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("docs.getMessagesUploadServer");
    }

    @Override
    protected Class<GetMessagesUploadServer.Response> getResponseType() {
        return GetMessagesUploadServer.Response.class;
    }

    public GetMessagesUploadServer setType(String type) {
        return addParam("type", type);
    }

    public GetMessagesUploadServer setPeerId(int peerId) {
        return addParam("peer_id", peerId);
    }

    @Override
    public GetMessagesUploadServer addParam(String key, Object value) {
        return (GetMessagesUploadServer) super.addParam(key, value);
    }

    /**
     * Response to <b>docs.getMessagesUploadServer</b> request.
     */
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject {
            /**
             * Link to which the document can be uploaded.
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
