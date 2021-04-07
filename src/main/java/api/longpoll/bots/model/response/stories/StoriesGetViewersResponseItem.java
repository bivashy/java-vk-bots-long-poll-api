package api.longpoll.bots.model.response.stories;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>stories.getViewers</b>.
 */
public class StoriesGetViewersResponseItem {
    /**
     * Whether the story is liked.
     */
    @SerializedName("is_liked")
    private Boolean isLiked;

    /**
     * User ID.
     */
    @SerializedName("user_id")
    private Integer userId;

    public Boolean getLiked() {
        return isLiked;
    }

    public void setLiked(Boolean liked) {
        isLiked = liked;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "StoriesGetViewersResponseItem{" +
                "isLiked=" + isLiked +
                ", userId=" + userId +
                '}';
    }
}
