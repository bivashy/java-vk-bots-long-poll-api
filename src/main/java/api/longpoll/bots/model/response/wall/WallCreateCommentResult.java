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

        public Response setCommentId(Integer commentId) {
            this.commentId = commentId;
            return this;
        }

        public List<Integer> getParentStack() {
            return parentStack;
        }

        public Response setParentStack(List<Integer> parentStack) {
            this.parentStack = parentStack;
            return this;
        }
    }

    public Response getResponse() {
        return response;
    }

    public WallCreateCommentResult setResponse(Response response) {
        this.response = response;
        return this;
    }
}
