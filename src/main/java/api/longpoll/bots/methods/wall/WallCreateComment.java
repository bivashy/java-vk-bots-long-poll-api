package api.longpoll.bots.methods.wall;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.CachedConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.media.Doc;
import api.longpoll.bots.model.objects.media.Photo;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.wall.WallCreateCommentResponse;
import api.longpoll.bots.utils.methods.AttachmentsUtil;
import org.jsoup.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>wall.createComment</b> method.
 *
 * @see <a href="https://vk.com/dev/wall.createComment">https://vk.com/dev/wall.createComment</a>
 */
public class WallCreateComment extends GetMethod<GenericResult<WallCreateCommentResponse>> {
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

    public WallCreateComment(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().wallCreateComment();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<WallCreateCommentResponse>> getConverter() {
        return CachedConverterFactory.getConverter(GenericResult.class, WallCreateCommentResponse.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return null;
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

    public Integer getOwnerId() {
        return ownerId;
    }

    public WallCreateComment setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public Integer getPostId() {
        return postId;
    }

    public WallCreateComment setPostId(Integer postId) {
        this.postId = postId;
        return this;
    }

    public Integer getFromGroupId() {
        return fromGroupId;
    }

    public WallCreateComment setFromGroupId(Integer fromGroupId) {
        this.fromGroupId = fromGroupId;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public WallCreateComment setMessage(String message) {
        this.message = message;
        return this;
    }

    public Integer getReplyToComment() {
        return replyToComment;
    }

    public WallCreateComment setReplyToComment(Integer replyToComment) {
        this.replyToComment = replyToComment;
        return this;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public WallCreateComment setAttachments(List<String> attachments) {
        this.attachments = attachments;
        return this;
    }

    public Integer getStickerId() {
        return stickerId;
    }

    public WallCreateComment setStickerId(Integer stickerId) {
        this.stickerId = stickerId;
        return this;
    }

    public String getGuid() {
        return guid;
    }

    public WallCreateComment setGuid(String guid) {
        this.guid = guid;
        return this;
    }
}
