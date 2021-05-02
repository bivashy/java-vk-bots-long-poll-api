package api.longpoll.bots.model.response.stories;

import api.longpoll.bots.adapters.deserializers.StoriesGetViewersResultDeserializer;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>stories.getViewers</b>.
 */
@JsonAdapter(StoriesGetViewersResultDeserializer.class)
public class StoriesGetViewersResult extends GenericResult<VkList<Object>> {
    /**
     * Response item.
     */
    public static class Response {
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
            return "Response{" +
                    "isLiked=" + isLiked +
                    ", userId=" + userId +
                    '}';
        }
    }
}
