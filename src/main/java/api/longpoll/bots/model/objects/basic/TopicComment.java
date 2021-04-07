package api.longpoll.bots.model.objects.basic;

import api.longpoll.bots.adapters.deserializers.BoolIntDeserializer;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.objects.media.Attachment;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Describes topic comment.
 *
 * @see <a href="https://vk.com/dev/objects/comment_board">Topic Comment</a>
 */
public class TopicComment implements EventObject {
    /**
     * Comment ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Comment author ID.
     */
    @SerializedName("from_id")
    private Integer fromId;

    /**
     * Date when the comment has been added in Unixtime.
     */
    @SerializedName("date")
    private Integer date;

    /**
     * Comment text.
     */
    @SerializedName("text")
    private String text;

    /**
     * Information about attachments in the comments (photos, links, etc).
     */
    @SerializedName("attachments")
    private List<Attachment> attachments;

    /**
     * Information about likes.
     */
    @SerializedName("likes")
    private Likes likes;

    /**
     * Describes topic comment likes.
     */
    public static class Likes {
        /**
         * Likes count.
         */
        @SerializedName("count")
        private Integer count;

        /**
         * <b>true</b>, if current user likes the comment.
         */
        @SerializedName("user_likes")
        @JsonAdapter(BoolIntDeserializer.class)
        private Boolean userLikes;

        /**
         * <b>true</b>, if current user can like the comment.
         */
        @SerializedName("can_like")
        @JsonAdapter(BoolIntDeserializer.class)
        private Boolean canLike;

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Boolean getUserLikes() {
            return userLikes;
        }

        public void setUserLikes(Boolean userLikes) {
            this.userLikes = userLikes;
        }

        public Boolean getCanLike() {
            return canLike;
        }

        public void setCanLike(Boolean canLike) {
            this.canLike = canLike;
        }

        @Override
        public String toString() {
            return "Likes{" +
                    "count=" + count +
                    ", userLikes=" + userLikes +
                    ", canLike=" + canLike +
                    '}';
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "TopicComment{" +
                "id=" + id +
                ", fromId=" + fromId +
                ", date=" + date +
                ", text='" + text + '\'' +
                ", attachments=" + attachments +
                ", likes=" + likes +
                '}';
    }
}
