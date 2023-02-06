package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.GenericResponseBody;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>groups.getOnlineStatus</b> method.
 * <p>
 * Returns a community's online status.
 *
 * @see <a href="https://vk.com/dev/groups.getOnlineStatus">https://vk.com/dev/groups.getOnlineStatus</a>
 */
public class GetOnlineStatus extends VkMethod<GetOnlineStatus.ResponseBody> {

    public GetOnlineStatus(String accessToken) {
        super(property("groups.getOnlineStatus"), accessToken);
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
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
    public static class ResponseBody extends GenericResponseBody<ResponseBody.Response> {
        /**
         * Response object.
         */
        public static class Response {
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
                return "Response{" +
                        "status='" + status + '\'' +
                        ", minutes=" + minutes +
                        '}';
            }
        }
    }
}
