package api.longpoll.bots.model.response.groups;

import com.google.gson.annotations.SerializedName;

public class GroupsGetLongPollSettingsResult {
    @SerializedName("response")
    private Response response;

    public static class Response extends GroupsGetCallbackSettingsResult.Response {
        @SerializedName("is_enabled")
        private Boolean enabled;

        public Boolean getEnabled() {
            return enabled;
        }

        public Response setEnabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }
    }

    public Response getResponse() {
        return response;
    }

    public GroupsGetLongPollSettingsResult setResponse(Response response) {
        this.response = response;
        return this;
    }
}
