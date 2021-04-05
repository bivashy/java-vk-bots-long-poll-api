package api.longpoll.bots.model.events.boards;

import api.longpoll.bots.model.objects.basic.TopicComment;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>board_post_new</b>, <b>board_post_edit</b> and <b>board_post_restore</b> event objects.
 */
public class BoardPostEvent extends TopicComment {
    /**
     * Topic ID.
     */
    @SerializedName("topic_id")
    private Integer topicId;

    /**
     * Topic owner ID.
     */
    @SerializedName("topic_owner_id")
    private Integer topicOwnerId;

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getTopicOwnerId() {
        return topicOwnerId;
    }

    public void setTopicOwnerId(Integer topicOwnerId) {
        this.topicOwnerId = topicOwnerId;
    }


    @Override
    public String toString() {
        return "BoardPostEvent{" +
                "topicId=" + topicId +
                ", topicOwnerId=" + topicOwnerId +
                "} " + super.toString();
    }
}
