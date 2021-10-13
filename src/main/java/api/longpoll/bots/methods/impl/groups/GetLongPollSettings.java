package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>groups.getLongPollSettings</b> method.
 * <p>
 * Returns Bots Long Poll API settings.
 *
 * @see <a href="https://vk.com/dev/groups.getLongPollSettings">https://vk.com/dev/groups.getLongPollSettings</a>
 */
public class GetLongPollSettings extends AuthorizedVkApiMethod<GetLongPollSettings.Response> {
    public GetLongPollSettings(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("groups.getLongPollSettings");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
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
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject extends GetCallbackSettings.Response.ResponseObject {
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
                return "ResponseObject{" +
                        "enabled=" + enabled +
                        "} " + super.toString();
            }
        }
    }
}
