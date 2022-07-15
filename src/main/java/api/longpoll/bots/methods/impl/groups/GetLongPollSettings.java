package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.GenericResponseBody;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>groups.getLongPollSettings</b> method.
 * <p>
 * Returns Bots Long Poll API settings.
 *
 * @see <a href="https://vk.com/dev/groups.getLongPollSettings">https://vk.com/dev/groups.getLongPollSettings</a>
 */
public class GetLongPollSettings extends VkMethod<GetLongPollSettings.ResponseBody> {
    public GetLongPollSettings(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUrl() {
        return VK_METHODS.getProperty("groups.getLongPollSettings");
    }

    @Override
    protected Class<ResponseBody> getResponseType() {
        return ResponseBody.class;
    }

    public GetLongPollSettings setGroupId(Integer groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public GetLongPollSettings addParam(String key, Object value) {
        return (GetLongPollSettings) super.addParam(key, value);
    }

    /**
     * Response to <b>groups.getLongPollSettings</b> request.
     */
    public static class ResponseBody extends GenericResponseBody<ResponseBody.Response> {
        /**
         * Response object.
         */
        public static class Response extends GetCallbackSettings.ResponseBody.Response {
            /**
             * <b>true</b> if Bots Long Poll API is enabled.
             */
            @SerializedName("is_enabled")
            private Boolean enabled;

            public Boolean getEnabled() {
                return enabled;
            }

            public void setEnabled(Boolean enabled) {
                this.enabled = enabled;
            }

            @Override
            public String toString() {
                return "Response{" +
                        "enabled=" + enabled +
                        "} " + super.toString();
            }
        }
    }
}
