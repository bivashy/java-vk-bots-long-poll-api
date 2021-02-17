package api.longpoll.bots.model.response.stories;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Response to <b>stories.getPhotoUploadServer</b> and <b>stories.getVideoUploadServer</b>
 */
public class StoriesGetUploadServerResponse {
    /**
     * Upload URL.
     */
    @SerializedName("upload_url")
    private Integer uploadUrl;

    /**
     * Users ID who can to see story.
     */
    @SerializedName("user_ids")
    private List<Integer> userIds;

    public Integer getUploadUrl() {
        return uploadUrl;
    }

    public void setUploadUrl(Integer uploadUrl) {
        this.uploadUrl = uploadUrl;
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }
}
