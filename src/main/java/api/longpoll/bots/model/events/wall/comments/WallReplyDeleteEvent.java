package api.longpoll.bots.model.events.wall.comments;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>wall_reply_delete</b> event objects.
 */
public class WallReplyDeleteEvent implements EventObject {
    /**
     * Wall owner ID.
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Comment ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * ID of the user who deleted a comment.
     */
    @SerializedName("deleter_id")
    private Integer deleterId;

    /**
     * Post ID.
     */
    @SerializedName("post_id")
    private Integer postId;

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeleterId() {
        return deleterId;
    }

    public void setDeleterId(Integer deleterId) {
        this.deleterId = deleterId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "WallReplyDeleteEvent{" +
                "ownerId=" + ownerId +
                ", id=" + id +
                ", deleterId=" + deleterId +
                ", postId=" + postId +
                '}';
    }
}
