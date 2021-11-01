package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>groups.getCallbackServers</b> method.
 * <p>
 * Receives a list of Callback API servers from the community.
 *
 * @see <a href="https://vk.com/dev/groups.getCallbackServers">https://vk.com/dev/groups.getCallbackServers</a>
 */
public class GetCallbackServers extends AuthorizedVkApiMethod<GetCallbackServers.Response> {
    public GetCallbackServers(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("groups.getCallbackServers");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetCallbackServers setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public GetCallbackServers setServerIds(Integer... serverIds) {
        return setServerIds(Arrays.asList(serverIds));
    }

    public GetCallbackServers setServerIds(List<Integer> serverIds) {
        return addParam("server_ids", serverIds);
    }

    @Override
    public GetCallbackServers addParam(String key, Object value) {
        return (GetCallbackServers) super.addParam(key, value);
    }

    /**
     * Response to <b>groups.getCallbackServers</b> request.
     */
    public static class Response extends GenericResponse<VkList<Response.Item>> {
        /**
         * Response item.
         */
        public static class Item {
            /**
             * Server ID.
             */
            @SerializedName("id")
            private Integer id;

            /**
             * Server title.
             */
            @SerializedName("title")
            private String title;

            /**
             * ID of the user who had added the server.
             */
            @SerializedName("creator_id")
            private Integer creatorId;

            /**
             * Server URL.
             */
            @SerializedName("url")
            private String url;

            /**
             * Server secret key.
             */
            @SerializedName("secret_key")
            private String secretKey;

            /**
             * Server status.
             */
            @SerializedName("status")
            private String status;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Integer getCreatorId() {
                return creatorId;
            }

            public void setCreatorId(Integer creatorId) {
                this.creatorId = creatorId;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getSecretKey() {
                return secretKey;
            }

            public void setSecretKey(String secretKey) {
                this.secretKey = secretKey;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            @Override
            public String toString() {
                return "Item{" +
                        "id=" + id +
                        ", title='" + title + '\'' +
                        ", creatorId=" + creatorId +
                        ", url='" + url + '\'' +
                        ", secretKey='" + secretKey + '\'' +
                        ", status='" + status + '\'' +
                        '}';
            }
        }
    }
}
