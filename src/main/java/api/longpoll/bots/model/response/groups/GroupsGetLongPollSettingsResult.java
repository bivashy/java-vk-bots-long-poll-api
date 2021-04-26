package api.longpoll.bots.model.response.groups;

import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>groups.getLongPollSettings</b> request.
 */
public class GroupsGetLongPollSettingsResult extends GenericResult<GroupsGetLongPollSettingsResult.Response> {
    /**
     * Response object.
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

        @Override
        public String toString() {
            return "Response{" +
                    "enabled=" + enabled +
                    "} " + super.toString();
        }
    }
}
