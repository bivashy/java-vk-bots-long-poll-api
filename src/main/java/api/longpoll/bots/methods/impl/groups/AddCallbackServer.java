package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.GenericResponseBody;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>groups.addCallbackServer</b> method.
 * <p>
 * Adds Callback API server to the community.
 *
 * @see <a href="https://vk.com/dev/groups.addCallbackServer">https://vk.com/dev/groups.addCallbackServer</a>
 */
public class AddCallbackServer extends VkMethod<AddCallbackServer.ResponseBody> {
    public AddCallbackServer(String accessToken) {
        super(property("groups.addCallbackServer"), accessToken);
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    public AddCallbackServer setUrl(String url) {
        return addParam("url", url);
    }

    public AddCallbackServer setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public AddCallbackServer setTitle(String title) {
        return addParam("title", title);
    }

    public AddCallbackServer setSecretKey(String secretKey) {
        return addParam("secret_key", secretKey);
    }

    @Override
    public AddCallbackServer addParam(String key, Object value) {
        return (AddCallbackServer) super.addParam(key, value);
    }

    /**
     * Response to <b>groups.addCallbackServer</b> request.
     */
    public static class ResponseBody extends GenericResponseBody<ResponseBody.Response> {
        /**
         * Response object.
         */
        public static class Response {
            /**
             * Server ID.
             */
            @SerializedName("server_id")
            private Integer serverId;

            public Integer getServerId() {
                return serverId;
            }

            public void setServerId(Integer serverId) {
                this.serverId = serverId;
            }

            @Override
            public String toString() {
                return "Response{" +
                        "serverId=" + serverId +
                        '}';
            }
        }
    }
}
