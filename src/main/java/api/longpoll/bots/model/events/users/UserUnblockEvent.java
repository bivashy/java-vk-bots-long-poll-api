package api.longpoll.bots.model.events.users;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>user_unblock</b> event objects.
 */
public class UserUnblockEvent implements EventObject {
    /**
     * Administrator ID.
     */
    @SerializedName("admin_id")
    private Integer adminId;

    /**
     * User ID.
     */
    @SerializedName("user_id")
    private Integer userId;

    /**
     * Unblocking date.
     */
    @SerializedName("by_end_date")
    private Integer byEndDate;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getByEndDate() {
        return byEndDate;
    }

    public void setByEndDate(Integer byEndDate) {
        this.byEndDate = byEndDate;
    }

    @Override
    public String toString() {
        return "UserUnblockEvent{" +
                "adminId=" + adminId +
                ", userId=" + userId +
                ", byEndDate=" + byEndDate +
                '}';
    }
}
