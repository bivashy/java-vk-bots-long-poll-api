package api.longpoll.bots.methods.impl.docs;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.GenericResponseBody;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>docs.getMessagesUploadServer</b> method.
 * <p>
 * Returns the server address for document upload.
 *
 * @see <a href="https://vk.com/dev/docs.getMessagesUploadServer">https://vk.com/dev/docs.getMessagesUploadServer</a>
 */
public class GetMessagesUploadServer extends VkMethod<GetMessagesUploadServer.ResponseBody> {
    public GetMessagesUploadServer(String accessToken) {
        super(property("docs.getMessagesUploadServer"), accessToken);
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
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
    public static class ResponseBody extends GenericResponseBody<ResponseBody.Response> {
        /**
         * Response object.
         */
        public static class Response {
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
                return "Response{" +
                        "uploadUrl='" + uploadUrl + '\'' +
                        '}';
            }
        }
    }
}
