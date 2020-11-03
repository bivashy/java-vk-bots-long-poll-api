package api.longpoll.bots.model.response.groups;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>groups.getOnlineStatus</b> request.
 */
public class GroupsGetOnlineStatusResponse {
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
}
