package api.longpoll.bots.model.objects.basic;

import api.longpoll.bots.adapters.deserializers.BoolIntDeserializer;
import api.longpoll.bots.model.objects.additional.Geo;
import api.longpoll.bots.model.objects.media.Attachable;
import api.longpoll.bots.model.objects.media.Attachment;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Describes post on the wall.
 *
 * @see <a href="https://vk.com/dev/objects/post">Wall Post</a>
 */
public class WallPost implements Attachable {
    /**
     * Post ID on the wall.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Wall owner ID.
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * ID of the author.
     */
    @SerializedName("from_id")
    private Integer fromId;

    /**
     * ID of the administrator who posted the post (for communities only, returns for the requests with administrator's access token).
     */
    @SerializedName("created_by")
    private Integer createdBy;

    /**
     * Date (in Unixtime) the post has been added.
     */
    @SerializedName("date")
    private Integer date;

    /**
     * Post text.
     */
    @SerializedName("text")
    private String text;

    /**
     * Replied post's owner id.
     */
    @SerializedName("reply_owner_id")
    private Integer replyOwnerId;

    /**
     * Replied post's id.
     */
    @SerializedName("reply_post_id")
    private Integer replyPostId;

    /**
     * <b>true</b> if a post is marked "Friends only".
     */
    @SerializedName("friends_only")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean friendsOnly;

    /**
     * Post comments info.
     */
    @SerializedName("comments")
    private Comments comments;

    /**
     * Post likes info.
     */
    @SerializedName("likes")
    private Likes likes;

    /**
     * Information about reposts (Share with friends).
     */
    @SerializedName("reposts")
    private Reposts reposts;

    /**
     * Views info.
     */
    @SerializedName("views")
    private Views views;

    /**
     * Type of the post, can be: post, copy, reply, postpone, suggest.
     */
    @SerializedName("post_type")
    private String postType;

    /**
     * Information about location.
     */
    @SerializedName("geo")
    private Geo geo;

    /**
     * Author ID (if the post has been published by the community name with the author sign).
     */
    @SerializedName("signer_id")
    private Integer signerId;

    /**
     * An array containing reposts history for current post.
     */
    @SerializedName("copy_history")
    private List<WallPost> copyHistory;

    /**
     * <b>true</b> if current user can pin a post.
     */
    @SerializedName("can_pin")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean canPin;

    /**
     * <b>true</b> if current user can delete the post.
     */
    @SerializedName("can_delete")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean canDelete;

    /**
     * <b>true</b> if current user can edit the post.
     */
    @SerializedName("can_edit")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean canEdit;

    /**
     * <b>true</b> if the post is pinned.
     */
    @SerializedName("is_pinned")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean pinned;

    /**
     * Whether the post is marked as ads.
     */
    @SerializedName("marked_as_ads")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean markedAsAds;

    /**
     * <b>true</b> if object is added to favorites by current users.
     */
    @SerializedName("is_favorite")
    private Boolean favourite;

    /**
     * Postponed post ID.
     */
    @SerializedName("postponed_id")
    private Integer postponedId;
    @SerializedName("can_archive")
    private Boolean canArchive;

    /**
     * <b>true</b> if post archived.
     */
    @SerializedName("is_archived")
    private Boolean archived;
    @SerializedName("post_source")
    private PostSource postSource;

    /**
     * List of attachments in the comments (photos, links, etc.)
     */
    @SerializedName("attachments")
    private List<Attachment> attachments;

    /**
     * Describes post comments info.
     */
    public static class Comments {
        /**
         * Comments count.
         */
        @SerializedName("count")
        private Integer count;

        /**
         * <b>true</b> if current user can comment the post.
         */
        @SerializedName("can_post")
        @JsonAdapter(BoolIntDeserializer.class)
        private Boolean canPost;

        /**
         * Whether communities can comment this post.
         */
        @SerializedName("groups_can_post")
        @JsonAdapter(BoolIntDeserializer.class)
        private Boolean groupsCanPost;

        /**
         * <b>true</b> if current user can close comments.
         */
        @SerializedName("can_close")
        private Boolean canClose;

        /**
         * <b>true</b> if current user can open comments.
         */
        @SerializedName("can_open")
        private Boolean canOpen;

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

        public Boolean getGroupsCanPost() {
            return groupsCanPost;
        }

        public void setGroupsCanPost(Boolean groupsCanPost) {
            this.groupsCanPost = groupsCanPost;
        }

        public Boolean getCanClose() {
            return canClose;
        }

        public void setCanClose(Boolean canClose) {
            this.canClose = canClose;
        }

        public Boolean getCanOpen() {
            return canOpen;
        }

        public void setCanOpen(Boolean canOpen) {
            this.canOpen = canOpen;
        }

        @Override
        public String toString() {
            return "Comments{" +
                    "count=" + count +
                    ", canPost=" + canPost +
                    ", groupsCanPost=" + groupsCanPost +
                    ", canClose=" + canClose +
                    ", canOpen=" + canOpen +
                    '}';
        }
    }

    /**
     * Describes post likes info.
     */
    public static class Likes extends WallComment.Likes {
        /**
         * Whether the user can repost.
         */
        @SerializedName("can_publish")
        @JsonAdapter(BoolIntDeserializer.class)
        private Boolean canPublish;

        public Boolean getCanPublish() {
            return canPublish;
        }

        public void setCanPublish(Boolean canPublish) {
            this.canPublish = canPublish;
        }


        @Override
        public String toString() {
            return "Likes{" +
                    "canPublish=" + canPublish +
                    "} " + super.toString();
        }
    }

    /**
     * Describes reposts.
     */
    public static class Reposts {
        /**
         * Number of users who copied the post.
         */
        @SerializedName("count")
        private Integer count;

        /**
         * Whether the user reposted the post.
         */
        @SerializedName("user_reposted")
        @JsonAdapter(BoolIntDeserializer.class)
        private Boolean userReposted;

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Boolean getUserReposted() {
            return userReposted;
        }

        public void setUserReposted(Boolean userReposted) {
            this.userReposted = userReposted;
        }

        @Override
        public String toString() {
            return "Reposts{" +
                    "count=" + count +
                    ", userReposted=" + userReposted +
                    '}';
        }
    }

    /**
     * Describes post views.
     */
    public static class Views {
        /**
         * Number of views.
         */
        @SerializedName("count")
        private Integer count;

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return "Views{" +
                    "count=" + count +
                    '}';
        }
    }

    /**
     * Describes way of posting on the wall.
     */
    public static class PostSource {
        /**
         * Source type.
         */
        @SerializedName("type")
        private String type;

        /**
         * Platform name.
         */
        @SerializedName("platform")
        private String platform;

        /**
         * Action type.
         */
        @SerializedName("data")
        private String data;

        /**
         * Resource URL.
         */
        @SerializedName("url")
        private String url;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "PostSource{" +
                    "type='" + type + '\'' +
                    ", platform='" + platform + '\'' +
                    ", data='" + data + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
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

    public Integer getReplyOwnerId() {
        return replyOwnerId;
    }

    public void setReplyOwnerId(Integer replyOwnerId) {
        this.replyOwnerId = replyOwnerId;
    }

    public Integer getReplyPostId() {
        return replyPostId;
    }

    public void setReplyPostId(Integer replyPostId) {
        this.replyPostId = replyPostId;
    }

    public Boolean getFriendsOnly() {
        return friendsOnly;
    }

    public void setFriendsOnly(Boolean friendsOnly) {
        this.friendsOnly = friendsOnly;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    public Reposts getReposts() {
        return reposts;
    }

    public void setReposts(Reposts reposts) {
        this.reposts = reposts;
    }

    public Views getViews() {
        return views;
    }

    public void setViews(Views views) {
        this.views = views;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public Integer getSignerId() {
        return signerId;
    }

    public void setSignerId(Integer signerId) {
        this.signerId = signerId;
    }

    public List<WallPost> getCopyHistory() {
        return copyHistory;
    }

    public void setCopyHistory(List<WallPost> copyHistory) {
        this.copyHistory = copyHistory;
    }

    public Boolean getCanPin() {
        return canPin;
    }

    public void setCanPin(Boolean canPin) {
        this.canPin = canPin;
    }

    public Boolean getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(Boolean canDelete) {
        this.canDelete = canDelete;
    }

    public Boolean getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(Boolean canEdit) {
        this.canEdit = canEdit;
    }

    public Boolean getPinned() {
        return pinned;
    }

    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }

    public Boolean getMarkedAsAds() {
        return markedAsAds;
    }

    public void setMarkedAsAds(Boolean markedAsAds) {
        this.markedAsAds = markedAsAds;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }

    public Integer getPostponedId() {
        return postponedId;
    }

    public void setPostponedId(Integer postponedId) {
        this.postponedId = postponedId;
    }

    public Boolean getCanArchive() {
        return canArchive;
    }

    public void setCanArchive(Boolean canArchive) {
        this.canArchive = canArchive;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public PostSource getPostSource() {
        return postSource;
    }

    public void setPostSource(PostSource postSource) {
        this.postSource = postSource;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "WallPost{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", fromId=" + fromId +
                ", createdBy=" + createdBy +
                ", date=" + date +
                ", text='" + text + '\'' +
                ", replyOwnerId=" + replyOwnerId +
                ", replyPostId=" + replyPostId +
                ", friendsOnly=" + friendsOnly +
                ", comments=" + comments +
                ", likes=" + likes +
                ", reposts=" + reposts +
                ", views=" + views +
                ", postType='" + postType + '\'' +
                ", geo=" + geo +
                ", signerId=" + signerId +
                ", copyHistory=" + copyHistory +
                ", canPin=" + canPin +
                ", canDelete=" + canDelete +
                ", canEdit=" + canEdit +
                ", pinned=" + pinned +
                ", markedAsAds=" + markedAsAds +
                ", favourite=" + favourite +
                ", postponedId=" + postponedId +
                ", canArchive=" + canArchive +
                ", archived=" + archived +
                ", postSource=" + postSource +
                ", attachments=" + attachments +
                '}';
    }
}
