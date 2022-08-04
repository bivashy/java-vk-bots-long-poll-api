package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.GenericResponseBody;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>groups.getLongPollServer</b> method.
 * <p>
 * Returns data for Bots Long Poll API connection.
 *
 * @see <a href="https://vk.com/dev/groups.getLongPollServer">https://vk.com/dev/groups.getLongPollServer</a>
 */
public class GetLongPollServer extends VkMethod<GetLongPollServer.ResponseBody> {
    public GetLongPollServer(String accessToken) {
        super(accessToken);
    }

    @Override
    protected Class<ResponseBody> getResponseType() {
        return ResponseBody.class;
    }

    @Override
    public String getUri() {
        return VK_METHODS.getProperty("groups.getLongPollServer");
    }

    public GetLongPollServer setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public GetLongPollServer addParam(String key, Object value) {
        return (GetLongPollServer) super.addParam(key, value);
    }

    /**
     * Response to <b>groups.getLongPollServer</b> request.
     */
    public static class ResponseBody extends GenericResponseBody<ResponseBody.Response> {
        /**
         * Response object.
         */
        public static class Response {
            /**
             * Key.
             */
            @SerializedName("key")
            private String key;

            /**
             * Server URL.
             */
            @SerializedName("server")
            private String server;

            /**
             * Timestamp.
             */
            @SerializedName("ts")
            private Integer ts;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getServer() {
                return server;
            }

            public void setServer(String server) {
                this.server = server;
            }

            public Integer getTs() {
                return ts;
            }

            public void setTs(Integer ts) {
                this.ts = ts;
            }

            @Override
            public String toString() {
                return "Response{" +
                        "key='" + key + '\'' +
                        ", server='" + server + '\'' +
                        ", ts=" + ts +
                        '}';
            }
        }
    }
}
