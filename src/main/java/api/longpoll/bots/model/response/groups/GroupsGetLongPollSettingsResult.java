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
