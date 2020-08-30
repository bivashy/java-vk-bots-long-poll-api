package api.longpoll.bots.model.response.groups;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>groups.getLongPollSettings</b> request.
 */
public class GroupsGetLongPollSettingsResult {
    /**
     * Response object.
     */
    @SerializedName("response")
    private Response response;

    /**
     * Describes response object.
     */
    public static class Response extends GroupsGetCallbackSettingsResult.Response {
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
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
