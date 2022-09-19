package api.longpoll.bots.model.events.poll;

import api.longpoll.bots.model.events.Update;
import com.google.gson.annotations.SerializedName;

/**
 * A new vote in a public poll.
 */
public class PollVoteNew implements Update.Object {
    /**
     * Poll owner ID.
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Poll ID.
     */
    @SerializedName("poll_id")
    private Integer pollId;

    /**
     * Poll option ID.
     */
    @SerializedName("option_id")
    private Integer optionId;

    /**
     * User ID.
     */
    @SerializedName("user_id")
    private Integer userId;

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getPollId() {
        return pollId;
    }

    public void setPollId(Integer pollId) {
        this.pollId = pollId;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PollVoteNew{" +
                "ownerId=" + ownerId +
                ", pollId=" + pollId +
                ", optionId=" + optionId +
                ", userId=" + userId +
                '}';
    }
}
