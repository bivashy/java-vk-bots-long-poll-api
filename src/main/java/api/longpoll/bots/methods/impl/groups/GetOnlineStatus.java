package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>groups.getOnlineStatus</b> method.
 * <p>
 * Returns a community's online status.
 *
 * @see <a href="https://vk.com/dev/groups.getOnlineStatus">https://vk.com/dev/groups.getOnlineStatus</a>
 */
public class GetOnlineStatus extends AuthorizedVkApiMethod<GetOnlineStatus.Response> {

    public GetOnlineStatus(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("groups.getOnlineStatus");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetOnlineStatus setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public GetOnlineStatus addParam(String key, Object value) {
        return (GetOnlineStatus) super.addParam(key, value);
    }

    /**
     * Response to <b>groups.getOnlineStatus</b> request.
     */
    public static class Response extends GenericResponse<Response.ResponseObjects> {
        /**
         * Response object.
         */
        public static class ResponseObjects {
            /**
             * Community's status.
             */
            @SerializedName("status")
            private String status;

            /**
             * Estimated time in minutes (for status = answer_mark).
             */
            @SerializedName("minutes")
            private Integer minutes;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public Integer getMinutes() {
                return minutes;
            }

            public void setMinutes(Integer minutes) {
                this.minutes = minutes;
            }

            @Override
            public String toString() {
                return "ResponseObjects{" +
                        "status='" + status + '\'' +
                        ", minutes=" + minutes +
                        '}';
            }
        }
    }
}
