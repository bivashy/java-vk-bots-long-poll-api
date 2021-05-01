package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.IntegerResult;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>groups.setCallbackSettings</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.setCallbackSettings">https://vk.com/dev/groups.setCallbackSettings</a>
 */
public class GroupsSetCallbackSettings extends VkApiGetMethod<IntegerResult> {
    /**
     * Community ID.
     */
    private Integer groupId;

    /**
     * Server ID.
     */
    private Integer serverId;

    /**
     * API version.
     */
    private String apiVersion;

    /**
     * A new incoming message has been received.
     */
    private Boolean messageNew;

    /**
     * A new outcoming message has been sent.
     */
    private Boolean messageReply;

    /**
     * A new user consent to messages sending has been received.
     */
    private Boolean messageAllow;

    /**
     * Message was edited.
     */
    private Boolean messageEdit;

    /**
     * A new user prohibition to messages sending has been received.
     */
    private Boolean messageDeny;

    /**
     * Message is typing.
     */
    private Boolean messageTypingState;

    /**
     * A new photo has been added.
     */
    private Boolean photoNew;

    /**
     * A new audio has been added.
     */
    private Boolean audioNew;

    /**
     * A new video has been added.
     */
    private Boolean videoNew;

    /**
     * A new wall comment has been added.
     */
    private Boolean wallReplyNew;

    /**
     * A wall comment has been edited.
     */
    private Boolean wallReplyEdit;

    /**
     * A wall comment has been deleted.
     */
    private Boolean wallReplyDelete;

    /**
     * A wall comment has been restored.
     */
    private Boolean wallReplyRestore;

    /**
     * A new post on wall has been added.
     */
    private Boolean wallPostNew;

    /**
     * A new repost form the community wall has been done.
     */
    private Boolean wallPostRepost;

    /**
     * A new board post has been added.
     */
    private Boolean boardPostNew;

    /**
     * A board post has been edited.
     */
    private Boolean boardPostEdit;

    /**
     * A board post has been restored
     */
    private Boolean boardPostRestore;

    /**
     * A board post has been deleted.
     */
    private Boolean boardPostDelete;

    /**
     * A new photo comment has been added.
     */
    private Boolean photoCommentNew;

    /**
     * A photo comment has been edited.
     */
    private Boolean photoCommentEdit;

    /**
     * A photo comment has been deleted.
     */
    private Boolean photoCommentDelete;

    /**
     * A photo comment has been restored.
     */
    private Boolean photoCommentRestore;

    /**
     * A new video comment has been added.
     */
    private Boolean videoCommentNew;

    /**
     * A video comment has been edited.
     */
    private Boolean videoCommentEdit;

    /**
     * A video comment has been deleted.
     */
    private Boolean videoCommentDelete;

    /**
     * A video comment has been restored.
     */
    private Boolean videoCommentRestore;

    /**
     * A new market comment has been added.
     */
    private Boolean marketCommentNew;

    /**
     * A market comment has been edited.
     */
    private Boolean marketCommentEdit;

    /**
     * A market comment has been deleted.
     */
    private Boolean marketCommentDelete;

    /**
     * A market comment has been restored.
     */
    private Boolean marketCommentRestore;

    /**
     * A vote in a public poll has been added.
     */
    private Boolean pollVoteNew;

    /**
     * A new member has been joined the community.
     */
    private Boolean groupJoin;

    /**
     * A member has been left the community.
     */
    private Boolean groupLeave;

    /**
     * Community settings have been changed.
     */
    private Boolean groupChangeSettings;

    /**
     * Community main photo has been changed.
     */
    private Boolean groupChangePhoto;

    /**
     * Community officers list has been changed.
     */
    private Boolean groupOfficersEdit;

    /**
     * A new user in the community's blacklist.
     */
    private Boolean userBlock;

    /**
     * A user has been deleted from the community's blacklist.
     */
    private Boolean userUnblock;

    /**
     * Form filled.
     */
    private Boolean leadFormsNew;

    /**
     * Like added.
     */
    private Boolean likeAdd;

    /**
     * Like removed.
     */
    private Boolean likeRemove;

    public GroupsSetCallbackSettings(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsSetCallbackSettings();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("group_id", groupId),
                param("server_id", serverId),
                param("api_version", apiVersion),
                param("message_new", messageNew),
                param("message_reply", messageReply),
                param("message_allow", messageAllow),
                param("message_edit", messageEdit),
                param("message_deny", messageDeny),
                param("message_typing_state", messageTypingState),
                param("photo_new", photoNew),
                param("audio_new", audioNew),
                param("video_new", videoNew),
                param("wall_reply_new", wallReplyNew),
                param("wall_reply_edit", wallReplyEdit),
                param("wall_reply_delete", wallReplyDelete),
                param("wall_reply_restore", wallReplyRestore),
                param("wall_post_new", wallPostNew),
                param("wall_repost", wallPostRepost),
                param("board_post_new", boardPostNew),
                param("board_post_edit", boardPostEdit),
                param("board_post_restore", boardPostRestore),
                param("board_post_delete", boardPostDelete),
                param("photo_comment_new", photoCommentNew),
                param("photo_comment_edit", photoCommentEdit),
                param("photo_comment_delete", photoCommentDelete),
                param("photo_comment_restore", photoCommentRestore),
                param("video_comment_new", videoCommentNew),
                param("video_comment_edit", videoCommentEdit),
                param("video_comment_delete", videoCommentDelete),
                param("video_comment_restore", videoCommentRestore),
                param("market_comment_new", marketCommentNew),
                param("market_comment_edit", marketCommentEdit),
                param("market_comment_delete", marketCommentDelete),
                param("market_comment_restore", marketCommentRestore),
                param("poll_vote_new", pollVoteNew),
                param("group_join", groupJoin),
                param("group_leave", groupLeave),
                param("group_change_settings", groupChangeSettings),
                param("group_change_photo", groupChangePhoto),
                param("group_officers_edit", groupOfficersEdit),
                param("user_block", userBlock),
                param("user_unblock", userUnblock),
                param("lead_forms_new", leadFormsNew),
                param("like_add", likeAdd),
                param("like_remove", likeRemove)
        );
    }

    @Override
    protected Class<? extends IntegerResult> getResultType() {
        return IntegerResult.class;
    }

    public GroupsSetCallbackSettings setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public GroupsSetCallbackSettings setServerId(Integer serverId) {
        this.serverId = serverId;
        return this;
    }

    public GroupsSetCallbackSettings setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    public GroupsSetCallbackSettings setMessageNew(Boolean messageNew) {
        this.messageNew = messageNew;
        return this;
    }

    public GroupsSetCallbackSettings setMessageReply(Boolean messageReply) {
        this.messageReply = messageReply;
        return this;
    }

    public GroupsSetCallbackSettings setMessageAllow(Boolean messageAllow) {
        this.messageAllow = messageAllow;
        return this;
    }

    public GroupsSetCallbackSettings setMessageEdit(Boolean messageEdit) {
        this.messageEdit = messageEdit;
        return this;
    }

    public GroupsSetCallbackSettings setMessageDeny(Boolean messageDeny) {
        this.messageDeny = messageDeny;
        return this;
    }

    public GroupsSetCallbackSettings setMessageTypingState(Boolean messageTypingState) {
        this.messageTypingState = messageTypingState;
        return this;
    }

    public GroupsSetCallbackSettings setPhotoNew(Boolean photoNew) {
        this.photoNew = photoNew;
        return this;
    }

    public GroupsSetCallbackSettings setAudioNew(Boolean audioNew) {
        this.audioNew = audioNew;
        return this;
    }

    public GroupsSetCallbackSettings setVideoNew(Boolean videoNew) {
        this.videoNew = videoNew;
        return this;
    }

    public GroupsSetCallbackSettings setWallReplyNew(Boolean wallReplyNew) {
        this.wallReplyNew = wallReplyNew;
        return this;
    }

    public GroupsSetCallbackSettings setWallReplyEdit(Boolean wallReplyEdit) {
        this.wallReplyEdit = wallReplyEdit;
        return this;
    }

    public GroupsSetCallbackSettings setWallReplyDelete(Boolean wallReplyDelete) {
        this.wallReplyDelete = wallReplyDelete;
        return this;
    }

    public GroupsSetCallbackSettings setWallReplyRestore(Boolean wallReplyRestore) {
        this.wallReplyRestore = wallReplyRestore;
        return this;
    }

    public GroupsSetCallbackSettings setWallPostNew(Boolean wallPostNew) {
        this.wallPostNew = wallPostNew;
        return this;
    }

    public GroupsSetCallbackSettings setWallPostRepost(Boolean wallPostRepost) {
        this.wallPostRepost = wallPostRepost;
        return this;
    }

    public GroupsSetCallbackSettings setBoardPostNew(Boolean boardPostNew) {
        this.boardPostNew = boardPostNew;
        return this;
    }

    public GroupsSetCallbackSettings setBoardPostEdit(Boolean boardPostEdit) {
        this.boardPostEdit = boardPostEdit;
        return this;
    }

    public GroupsSetCallbackSettings setBoardPostRestore(Boolean boardPostRestore) {
        this.boardPostRestore = boardPostRestore;
        return this;
    }

    public GroupsSetCallbackSettings setBoardPostDelete(Boolean boardPostDelete) {
        this.boardPostDelete = boardPostDelete;
        return this;
    }

    public GroupsSetCallbackSettings setPhotoCommentNew(Boolean photoCommentNew) {
        this.photoCommentNew = photoCommentNew;
        return this;
    }

    public GroupsSetCallbackSettings setPhotoCommentEdit(Boolean photoCommentEdit) {
        this.photoCommentEdit = photoCommentEdit;
        return this;
    }

    public GroupsSetCallbackSettings setPhotoCommentDelete(Boolean photoCommentDelete) {
        this.photoCommentDelete = photoCommentDelete;
        return this;
    }

    public GroupsSetCallbackSettings setPhotoCommentRestore(Boolean photoCommentRestore) {
        this.photoCommentRestore = photoCommentRestore;
        return this;
    }

    public GroupsSetCallbackSettings setVideoCommentNew(Boolean videoCommentNew) {
        this.videoCommentNew = videoCommentNew;
        return this;
    }

    public GroupsSetCallbackSettings setVideoCommentEdit(Boolean videoCommentEdit) {
        this.videoCommentEdit = videoCommentEdit;
        return this;
    }

    public GroupsSetCallbackSettings setVideoCommentDelete(Boolean videoCommentDelete) {
        this.videoCommentDelete = videoCommentDelete;
        return this;
    }

    public GroupsSetCallbackSettings setVideoCommentRestore(Boolean videoCommentRestore) {
        this.videoCommentRestore = videoCommentRestore;
        return this;
    }

    public GroupsSetCallbackSettings setMarketCommentNew(Boolean marketCommentNew) {
        this.marketCommentNew = marketCommentNew;
        return this;
    }

    public GroupsSetCallbackSettings setMarketCommentEdit(Boolean marketCommentEdit) {
        this.marketCommentEdit = marketCommentEdit;
        return this;
    }

    public GroupsSetCallbackSettings setMarketCommentDelete(Boolean marketCommentDelete) {
        this.marketCommentDelete = marketCommentDelete;
        return this;
    }

    public GroupsSetCallbackSettings setMarketCommentRestore(Boolean marketCommentRestore) {
        this.marketCommentRestore = marketCommentRestore;
        return this;
    }

    public GroupsSetCallbackSettings setPollVoteNew(Boolean pollVoteNew) {
        this.pollVoteNew = pollVoteNew;
        return this;
    }

    public GroupsSetCallbackSettings setGroupJoin(Boolean groupJoin) {
        this.groupJoin = groupJoin;
        return this;
    }

    public GroupsSetCallbackSettings setGroupLeave(Boolean groupLeave) {
        this.groupLeave = groupLeave;
        return this;
    }

    public GroupsSetCallbackSettings setGroupChangeSettings(Boolean groupChangeSettings) {
        this.groupChangeSettings = groupChangeSettings;
        return this;
    }

    public GroupsSetCallbackSettings setGroupChangePhoto(Boolean groupChangePhoto) {
        this.groupChangePhoto = groupChangePhoto;
        return this;
    }

    public GroupsSetCallbackSettings setGroupOfficersEdit(Boolean groupOfficersEdit) {
        this.groupOfficersEdit = groupOfficersEdit;
        return this;
    }

    public GroupsSetCallbackSettings setUserBlock(Boolean userBlock) {
        this.userBlock = userBlock;
        return this;
    }

    public GroupsSetCallbackSettings setUserUnblock(Boolean userUnblock) {
        this.userUnblock = userUnblock;
        return this;
    }

    public GroupsSetCallbackSettings setLeadFormsNew(Boolean leadFormsNew) {
        this.leadFormsNew = leadFormsNew;
        return this;
    }

    public GroupsSetCallbackSettings setLikeAdd(Boolean likeAdd) {
        this.likeAdd = likeAdd;
        return this;
    }

    public GroupsSetCallbackSettings setLikeRemove(Boolean likeRemove) {
        this.likeRemove = likeRemove;
        return this;
    }
}
