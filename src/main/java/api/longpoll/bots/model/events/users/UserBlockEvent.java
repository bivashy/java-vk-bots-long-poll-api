package api.longpoll.bots.model.events.users;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>user_block</b> event objects.
 */
public class UserBlockEvent implements EventObject {
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
     * Date when the user will be unblocked.
     */
    @SerializedName("unblock_date")
    private Integer unblockDate;

    /**
     * Ban reason.
     */
    @SerializedName("reason")
    private Integer reason;

    /**
     * Text of the comment to the ban.
     */
    @SerializedName("comment")
    private Integer comment;

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

    public Integer getUnblockDate() {
        return unblockDate;
    }

    public void setUnblockDate(Integer unblockDate) {
        this.unblockDate = unblockDate;
    }

    public Integer getReason() {
        return reason;
    }

    public void setReason(Integer reason) {
        this.reason = reason;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "UserBlockEvent{" +
                "adminId=" + adminId +
                ", userId=" + userId +
                ", unblockDate=" + unblockDate +
                ", reason=" + reason +
                ", comment=" + comment +
                '}';
    }
}
