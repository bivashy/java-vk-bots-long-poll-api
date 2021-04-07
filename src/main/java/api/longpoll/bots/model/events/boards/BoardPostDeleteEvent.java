package api.longpoll.bots.model.events.boards;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>board_post_delete</b> event objects.
 */
public class BoardPostDeleteEvent implements EventObject {
    /**
     * Topic owner ID.
     */
    @SerializedName("topic_owner_id")
    private Integer topicOwnerId;

    /**
     * Comment ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Topic ID.
     */
    @SerializedName("topic_id")
    private Integer topicId;

    public Integer getTopicOwnerId() {
        return topicOwnerId;
    }

    public void setTopicOwnerId(Integer topicOwnerId) {
        this.topicOwnerId = topicOwnerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    @Override
    public String toString() {
        return "BoardPostDeleteEvent{" +
                "topicOwnerId=" + topicOwnerId +
                ", id=" + id +
                ", topicId=" + topicId +
                '}';
    }
}
