package api.longpoll.bots.methods.impl.wall;

import api.longpoll.bots.http.params.AttachableParam;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>wall.createComment</b> method.
 * <p>
 * Adds a comment to a post on a user wall or community wall.
 *
 * @see <a href="https://vk.com/dev/wall.createComment">https://vk.com/dev/wall.createComment</a>
 */
public class CreateComment extends AuthorizedVkApiMethod<CreateComment.Response> {
    public CreateComment(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("wall.createComment");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public CreateComment setAttachments(AttachableParam... attachments) {
        return setAttachments(Arrays.asList(attachments));
    }

    public CreateComment setAttachments(List<AttachableParam> attachments) {
        addParam("attachment", attachments);
        return this;
    }

    public CreateComment setOwnerId(int ownerId) {
        addParam("owner_id", ownerId);
        return this;
    }

    public CreateComment setPostId(int postId) {
        addParam("post_id", postId);
        return this;
    }

    public CreateComment setFromGroupId(int fromGroupId) {
        addParam("from_group", fromGroupId);
        return this;
    }

    public CreateComment setMessage(String message) {
        addParam("message", message);
        return this;
    }

    public CreateComment setReplyToComment(int replyToComment) {
        addParam("reply_to_comment", replyToComment);
        return this;
    }

    public CreateComment setStickerId(int stickerId) {
        addParam("sticker_id", stickerId);
        return this;
    }

    public CreateComment setGuid(String guid) {
        addParam("guid", guid);
        return this;
    }

    /**
     * Response to <b>wall.createComment</b> request.
     */
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject {
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
                return "ResponseObject{" +
                        "commentId=" + commentId +
                        ", parentStack=" + parentStack +
                        '}';
            }
        }
    }
}
