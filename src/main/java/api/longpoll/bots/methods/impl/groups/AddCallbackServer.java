package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>groups.addCallbackServer</b> method.
 * <p>
 * Adds Callback API server to the community.
 *
 * @see <a href="https://vk.com/dev/groups.addCallbackServer">https://vk.com/dev/groups.addCallbackServer</a>
 */
public class AddCallbackServer extends AuthorizedVkApiMethod<AddCallbackServer.Response> {
    public AddCallbackServer(String accessToken) {
        super(accessToken);
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("groups.addCallbackServer");
    }

    public AddCallbackServer setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }

    public AddCallbackServer setUrl(String url) {
        addParam("url", url);
        return this;
    }

    public AddCallbackServer setTitle(String title) {
        addParam("title", title);
        return this;
    }

    public AddCallbackServer setSecretKey(String secretKey) {
        addParam("secret_key", secretKey);
        return this;
    }

    /**
     * Response to <b>groups.addCallbackServer</b> request.
     */
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject {
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
                return "ResponseObject{" +
                        "serverId=" + serverId +
                        '}';
            }
        }
    }
}
