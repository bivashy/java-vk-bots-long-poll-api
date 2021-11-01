package api.longpoll.bots.model.events.users;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>group_join</b> event objects.
 */
public class GroupJoinEvent implements EventObject {
    /**
     * User ID.
     */
    @SerializedName("user_id")
    private Integer userId;

    /**
     * Shows how exactly the user has joined.
     */
    @SerializedName("join_type")
    private String joinType;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getJoinType() {
        return joinType;
    }

    public void setJoinType(String joinType) {
        this.joinType = joinType;
    }

    @Override
    public String toString() {
        return "GroupJoinEvent{" +
                "userId=" + userId +
                ", joinType='" + joinType + '\'' +
                '}';
    }
}
