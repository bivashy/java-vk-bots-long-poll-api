package api.longpoll.bots.model.response.wall;

import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Response to <b>wall.createComment</b> request.
 */
public class WallCreateCommentResult extends GenericResult<WallCreateCommentResult.Response> {
    /**
     * Response object.
     */
    public static class Response {
        /**
         * Added comment ID.
         */
        @SerializedName("comment_id")
        private Integer commentId;

        /**
         * List of parent comments.
         */
        @SerializedName("parent_stack")
        private List<Integer> parentStack;

        public Integer getCommentId() {
            return commentId;
        }

        public void setCommentId(Integer commentId) {
            this.commentId = commentId;
        }

        public List<Integer> getParentStack() {
            return parentStack;
        }

        public void setParentStack(List<Integer> parentStack) {
            this.parentStack = parentStack;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "commentId=" + commentId +
                    ", parentStack=" + parentStack +
                    '}';
        }
    }
}
