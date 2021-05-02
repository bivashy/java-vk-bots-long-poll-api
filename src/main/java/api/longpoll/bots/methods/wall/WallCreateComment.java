package api.longpoll.bots.methods.wall;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.media.Doc;
import api.longpoll.bots.model.objects.media.Photo;
import api.longpoll.bots.model.response.wall.WallCreateCommentResult;
import api.longpoll.bots.utils.methods.AttachmentsUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>wall.createComment</b> method.
 *
 * @see <a href="https://vk.com/dev/wall.createComment">https://vk.com/dev/wall.createComment</a>
 */
public class WallCreateComment extends VkApiGetMethod<WallCreateCommentResult> {
    /**
     * User ID or community ID.
     */
    private Integer ownerId;

    /**
     * Post ID.
     */
    private Integer postId;

    /**
     * ID of the community from which name the comment will be created.
     */
    private Integer fromGroupId;

    /**
     * Text of the comment.
     */
    private String message;

    /**
     * ID of comment to reply.
     */
    private Integer replyToComment;

    /**
     * List of media objects attached to the comment.
     */
    private List<String> attachments;

    /**
     * Sticker ID.
     */
    private Integer stickerId;

    /**
     * Unique identifier to avoid repeated comments.
     */
    private String guid;

    public WallCreateComment(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().wallCreateComment();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("owner_id", ownerId),
                param("post_id", postId),
                param("from_group", fromGroupId),
                param("message", message),
                param("reply_to_comment", replyToComment),
                param("attachments", attachments),
                param("sticker_id", stickerId),
                param("guid", guid)
        );
    }

    @Override
    protected Class<? extends WallCreateCommentResult> getResultType() {
        return WallCreateCommentResult.class;
    }

    private WallCreateComment attach(String attachment) {
        if (attachments == null) {
            attachments = new ArrayList<>();
        }
        attachments.add(attachment);
        return this;
    }

    public WallCreateComment attachPhoto(Photo photo) {
        return attach(AttachmentsUtil.toAttachment(photo));
    }

    public WallCreateComment attachDoc(Doc doc) {
        return attach(AttachmentsUtil.toAttachment(doc));
    }

    public WallCreateComment setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public WallCreateComment setPostId(Integer postId) {
        this.postId = postId;
        return this;
    }

    public WallCreateComment setFromGroupId(Integer fromGroupId) {
        this.fromGroupId = fromGroupId;
        return this;
    }

    public WallCreateComment setMessage(String message) {
        this.message = message;
        return this;
    }

    public WallCreateComment setReplyToComment(Integer replyToComment) {
        this.replyToComment = replyToComment;
        return this;
    }

    public WallCreateComment setAttachments(List<String> attachments) {
        this.attachments = attachments;
        return this;
    }

    public WallCreateComment setStickerId(Integer stickerId) {
        this.stickerId = stickerId;
        return this;
    }

    public WallCreateComment setGuid(String guid) {
        this.guid = guid;
        return this;
    }
}
