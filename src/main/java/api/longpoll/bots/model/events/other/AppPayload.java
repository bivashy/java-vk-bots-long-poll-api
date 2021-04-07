package api.longpoll.bots.model.events.other;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>app_payload</b> event objects.
 */
public class AppPayload implements EventObject {
    /**
     * User ID whose action in the application triggered the event.
     */
    @SerializedName("user_id")
    private Integer userId;

    /**
     * Application ID from which the event was dispatched.
     */
    @SerializedName("app_id")
    private Integer appId;

    /**
     * Transmitted payload.
     */
    @SerializedName("payload")
    private String payload;

    /**
     * Group ID to which the notification was sent.
     */
    @SerializedName("group_id")
    private Integer groupId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "AppPayload{" +
                "userId=" + userId +
                ", appId=" + appId +
                ", payload='" + payload + '\'' +
                ", groupId=" + groupId +
                '}';
    }
}
