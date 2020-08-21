package api.longpoll.bots.methods.wall;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.media.Doc;
import api.longpoll.bots.model.objects.media.Photo;
import api.longpoll.bots.model.response.wall.WallCreateCommentResult;
import org.jsoup.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class WallCreateComment extends GetMethod<WallCreateCommentResult> {
    private Integer ownerId;
    private Integer postId;
    private Integer fromGroupId;
    private String message;
    private Integer replyToComment;
    private List<String> attachments;
    private Integer stickerId;
    private String guid;

    public WallCreateComment(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.Wall.CREATE_COMMENT;
    }

    @Override
    protected JsonToPojoConverter<WallCreateCommentResult> getConverter() {
        return GenericConverterFactory.get(WallCreateCommentResult.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return null;
    }

    private String attachment(String type, Integer ownerId, Integer mediaId, String accessKey) {
        return type + ownerId + "_" + mediaId + (accessKey == null ? "" : "_" + accessKey);
    }

    private WallCreateComment attach(String type, Integer ownerId, Integer mediaId, String accessKey) {
        if (attachments == null) {
            attachments = new ArrayList<>();
        }
        attachments.add(attachment(type, ownerId, mediaId, accessKey));
        return this;
    }

    public WallCreateComment attachPhoto(Photo photo) {
        return attach("photo", photo.getOwnerId(), photo.getId(), photo.getAccessKey());
    }

    public WallCreateComment attachDoc(Doc doc) {
        return attach("doc", doc.getOwnerId(), doc.getId(), doc.getAccessKey());
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
