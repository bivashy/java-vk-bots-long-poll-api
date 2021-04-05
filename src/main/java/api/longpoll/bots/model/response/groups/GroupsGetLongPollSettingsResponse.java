package api.longpoll.bots.model.response.groups;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>groups.getLongPollSettings</b> request.
 */
public class GroupsGetLongPollSettingsResponse extends GroupsGetCallbackSettingsResponse {
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
        return "GroupsGetLongPollSettingsResponse{" +
                "enabled=" + enabled +
                "} " + super.toString();
    }
}
