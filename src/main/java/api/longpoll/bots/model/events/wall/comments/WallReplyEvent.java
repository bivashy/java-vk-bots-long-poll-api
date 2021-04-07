package api.longpoll.bots.model.events.wall.comments;

import api.longpoll.bots.model.objects.basic.WallComment;
import com.google.gson.annotations.SerializedName;

/**
 * Describes <b>wall_reply_new</b>, <b>wall_reply_edit</b> and <b>wall_reply_restore</b> event objects.
 */
public class WallReplyEvent extends WallComment {
    /**
     * Post owner ID.
     */
    @SerializedName("post_owner_id")
    private Integer postOwnerId;

    public Integer getPostOwnerId() {
        return postOwnerId;
    }

    public void setPostOwnerId(Integer postOwnerId) {
        this.postOwnerId = postOwnerId;
    }


    @Override
    public String toString() {
        return "WallReplyEvent{" +
                "postOwnerId=" + postOwnerId +
                "} " + super.toString();
    }
}
