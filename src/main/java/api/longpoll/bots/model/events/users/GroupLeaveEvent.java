package api.longpoll.bots.model.events.users;

import api.longpoll.bots.adapters.deserializers.BoolIntDeserializer;
import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>group_leave</b> event objects.
 */
public class GroupLeaveEvent implements EventObject {
    /**
     * User ID.
     */
    @SerializedName("user_id")
    private Integer userId;

    /**
     * <b>true</b>, if a user has left on his own.
     */
    @SerializedName("self")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean self;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getSelf() {
        return self;
    }

    public void setSelf(Boolean self) {
        this.self = self;
    }

    @Override
    public String toString() {
        return "GroupLeaveEvent{" +
                "userId=" + userId +
                ", self=" + self +
                '}';
    }
}
