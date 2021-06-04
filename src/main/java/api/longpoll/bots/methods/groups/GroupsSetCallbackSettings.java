package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.IntegerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>groups.setCallbackSettings</b> method.
 *
 * Allow to set notifications settings for Callback API.
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
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("group_id", groupId),
                keyVal("server_id", serverId),
                keyVal("api_version", apiVersion),
                keyVal("message_new", messageNew),
                keyVal("message_reply", messageReply),
                keyVal("message_allow", messageAllow),
                keyVal("message_edit", messageEdit),
                keyVal("message_deny", messageDeny),
                keyVal("message_typing_state", messageTypingState),
                keyVal("photo_new", photoNew),
                keyVal("audio_new", audioNew),
                keyVal("video_new", videoNew),
                keyVal("wall_reply_new", wallReplyNew),
                keyVal("wall_reply_edit", wallReplyEdit),
                keyVal("wall_reply_delete", wallReplyDelete),
                keyVal("wall_reply_restore", wallReplyRestore),
                keyVal("wall_post_new", wallPostNew),
                keyVal("wall_repost", wallPostRepost),
                keyVal("board_post_new", boardPostNew),
                keyVal("board_post_edit", boardPostEdit),
                keyVal("board_post_restore", boardPostRestore),
                keyVal("board_post_delete", boardPostDelete),
                keyVal("photo_comment_new", photoCommentNew),
                keyVal("photo_comment_edit", photoCommentEdit),
                keyVal("photo_comment_delete", photoCommentDelete),
                keyVal("photo_comment_restore", photoCommentRestore),
                keyVal("video_comment_new", videoCommentNew),
                keyVal("video_comment_edit", videoCommentEdit),
                keyVal("video_comment_delete", videoCommentDelete),
                keyVal("video_comment_restore", videoCommentRestore),
                keyVal("market_comment_new", marketCommentNew),
                keyVal("market_comment_edit", marketCommentEdit),
                keyVal("market_comment_delete", marketCommentDelete),
                keyVal("market_comment_restore", marketCommentRestore),
                keyVal("poll_vote_new", pollVoteNew),
                keyVal("group_join", groupJoin),
                keyVal("group_leave", groupLeave),
                keyVal("group_change_settings", groupChangeSettings),
                keyVal("group_change_photo", groupChangePhoto),
                keyVal("group_officers_edit", groupOfficersEdit),
                keyVal("user_block", userBlock),
                keyVal("user_unblock", userUnblock),
                keyVal("lead_forms_new", leadFormsNew),
                keyVal("like_add", likeAdd),
                keyVal("like_remove", likeRemove)
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
