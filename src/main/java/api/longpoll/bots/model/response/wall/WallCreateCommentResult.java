package api.longpoll.bots.model.response.wall;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WallCreateCommentResult {
    @SerializedName("response")
    private Response response;

    public static class Response {
        @SerializedName("comment_id")
        private Integer commentId;
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
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
