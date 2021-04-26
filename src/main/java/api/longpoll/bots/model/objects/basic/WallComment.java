package api.longpoll.bots.model.objects.basic;

import api.longpoll.bots.adapters.deserializers.BoolIntDeserializer;
import api.longpoll.bots.model.objects.media.Attachable;
import api.longpoll.bots.model.objects.media.Attachment;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Describes Wall Comment.
 *
 * @see <a href="https://vk.com/dev/objects/comment">Wall Comment</a>
 */
public class WallComment implements Attachable {
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
     * ID of the user or community to whom the reply is addressed (if the comment is a reply to another comment).
     */
    @SerializedName("reply_to_user")
    private Integer replyToUser;

    /**
     * ID of the comment the reply to which is represented by the current comment (if the comment is a reply to another comment).
     */
    @SerializedName("reply_to_comment")
    private Integer replyToComment;

    /**
     * Parent comments IDs.
     */
    @SerializedName("parents_stack")
    private List<Integer> parentsStack;

    /**
     * Thread info.
     */
    @SerializedName("thread")
    private Thread thread;

    /**
     * Wall post ID.
     */
    @SerializedName("post_id")
    private Integer postId;

    /**
     * Post owner ID.
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Likes info.
     */
    @SerializedName("likes")
    private Likes likes;

    /**
     * List of attachments in the comments (photos, links, etc.)
     */
    @SerializedName("attachments")
    private List<Attachment> attachments;

    /**
     * Describes thread.
     */
    public static class Thread {
        /**
         * Number of comments.
         */
        @SerializedName("count")
        private Integer count;

        /**
         * <b>true</b> if current user can post comments in this thread.
         */
        @SerializedName("can_post")
        @JsonAdapter(BoolIntDeserializer.class)
        private Boolean canPost;

        /**
         * <b>true</b> if it is recommended to display "reply" button.
         */
        @SerializedName("show_reply_button")
        @JsonAdapter(BoolIntDeserializer.class)
        private Boolean showReplyButton;

        /**
         * <b>true</b> if groups can post comments in this thread.
         */
        @SerializedName("groups_can_post")
        @JsonAdapter(BoolIntDeserializer.class)
        private Boolean groupsCanPost;

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Boolean getCanPost() {
            return canPost;
        }

        public void setCanPost(Boolean canPost) {
            this.canPost = canPost;
        }

        public Boolean getShowReplyButton() {
            return showReplyButton;
        }

        public void setShowReplyButton(Boolean showReplyButton) {
            this.showReplyButton = showReplyButton;
        }

        public Boolean getGroupsCanPost() {
            return groupsCanPost;
        }

        public void setGroupsCanPost(Boolean groupsCanPost) {
            this.groupsCanPost = groupsCanPost;
        }

        @Override
        public String toString() {
            return "Thread{" +
                    "count=" + count +
                    ", canPost=" + canPost +
                    ", showReplyButton=" + showReplyButton +
                    ", groupsCanPost=" + groupsCanPost +
                    '}';
        }
    }

    /**
     * Describes likes info.
     */
    public static class Likes {
        /**
         * Number of likes.
         */
        @SerializedName("count")
        private Integer count;

        /**
         * <b>true</b> if current user likes the post.
         */
        @SerializedName("user_likes")
        @JsonAdapter(BoolIntDeserializer.class)
        private Boolean userLikes;

        /**
         * <b>true</b> if current user can add like to the post.
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

    public Integer getReplyToUser() {
        return replyToUser;
    }

    public void setReplyToUser(Integer replyToUser) {
        this.replyToUser = replyToUser;
    }

    public Integer getReplyToComment() {
        return replyToComment;
    }

    public void setReplyToComment(Integer replyToComment) {
        this.replyToComment = replyToComment;
    }

    public List<Integer> getParentsStack() {
        return parentsStack;
    }

    public void setParentsStack(List<Integer> parentsStack) {
        this.parentsStack = parentsStack;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "WallComment{" +
                "id=" + id +
                ", fromId=" + fromId +
                ", date=" + date +
                ", text='" + text + '\'' +
                ", replyToUser=" + replyToUser +
                ", replyToComment=" + replyToComment +
                ", parentsStack=" + parentsStack +
                ", thread=" + thread +
                ", postId=" + postId +
                ", ownerId=" + ownerId +
                ", likes=" + likes +
                ", attachments=" + attachments +
                '}';
    }
}
