package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.IntegerResult;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>groups.setLongPollSettings</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.setLongPollSettings">https://vk.com/dev/groups.setLongPollSettings</a>
 */
public class GroupsSetLongPollSettings extends VkApiGetMethod<IntegerResult> {
    /**
     * Community ID.
     */
    private Integer groupId;

    /**
     * Whether Bots Long Poll API enabled.
     */
    private Boolean enabled;
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

    public GroupsSetLongPollSettings(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().groupsSetLongPollSettings();
    }

    @Override
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("group_id", groupId),
                param("enabled", enabled, true),
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

    public GroupsSetLongPollSettings setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public GroupsSetLongPollSettings setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public GroupsSetLongPollSettings setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    public GroupsSetLongPollSettings setMessageNew(Boolean messageNew) {
        this.messageNew = messageNew;
        return this;
    }

    public GroupsSetLongPollSettings setMessageReply(Boolean messageReply) {
        this.messageReply = messageReply;
        return this;
    }

    public GroupsSetLongPollSettings setMessageAllow(Boolean messageAllow) {
        this.messageAllow = messageAllow;
        return this;
    }

    public GroupsSetLongPollSettings setMessageEdit(Boolean messageEdit) {
        this.messageEdit = messageEdit;
        return this;
    }

    public GroupsSetLongPollSettings setMessageDeny(Boolean messageDeny) {
        this.messageDeny = messageDeny;
        return this;
    }

    public GroupsSetLongPollSettings setMessageTypingState(Boolean messageTypingState) {
        this.messageTypingState = messageTypingState;
        return this;
    }

    public GroupsSetLongPollSettings setPhotoNew(Boolean photoNew) {
        this.photoNew = photoNew;
        return this;
    }

    public GroupsSetLongPollSettings setAudioNew(Boolean audioNew) {
        this.audioNew = audioNew;
        return this;
    }

    public GroupsSetLongPollSettings setVideoNew(Boolean videoNew) {
        this.videoNew = videoNew;
        return this;
    }

    public GroupsSetLongPollSettings setWallReplyNew(Boolean wallReplyNew) {
        this.wallReplyNew = wallReplyNew;
        return this;
    }

    public GroupsSetLongPollSettings setWallReplyEdit(Boolean wallReplyEdit) {
        this.wallReplyEdit = wallReplyEdit;
        return this;
    }

    public GroupsSetLongPollSettings setWallReplyDelete(Boolean wallReplyDelete) {
        this.wallReplyDelete = wallReplyDelete;
        return this;
    }

    public GroupsSetLongPollSettings setWallReplyRestore(Boolean wallReplyRestore) {
        this.wallReplyRestore = wallReplyRestore;
        return this;
    }

    public GroupsSetLongPollSettings setWallPostNew(Boolean wallPostNew) {
        this.wallPostNew = wallPostNew;
        return this;
    }

    public GroupsSetLongPollSettings setWallPostRepost(Boolean wallPostRepost) {
        this.wallPostRepost = wallPostRepost;
        return this;
    }

    public GroupsSetLongPollSettings setBoardPostNew(Boolean boardPostNew) {
        this.boardPostNew = boardPostNew;
        return this;
    }

    public GroupsSetLongPollSettings setBoardPostEdit(Boolean boardPostEdit) {
        this.boardPostEdit = boardPostEdit;
        return this;
    }

    public GroupsSetLongPollSettings setBoardPostRestore(Boolean boardPostRestore) {
        this.boardPostRestore = boardPostRestore;
        return this;
    }

    public GroupsSetLongPollSettings setBoardPostDelete(Boolean boardPostDelete) {
        this.boardPostDelete = boardPostDelete;
        return this;
    }

    public GroupsSetLongPollSettings setPhotoCommentNew(Boolean photoCommentNew) {
        this.photoCommentNew = photoCommentNew;
        return this;
    }

    public GroupsSetLongPollSettings setPhotoCommentEdit(Boolean photoCommentEdit) {
        this.photoCommentEdit = photoCommentEdit;
        return this;
    }

    public GroupsSetLongPollSettings setPhotoCommentDelete(Boolean photoCommentDelete) {
        this.photoCommentDelete = photoCommentDelete;
        return this;
    }

    public GroupsSetLongPollSettings setPhotoCommentRestore(Boolean photoCommentRestore) {
        this.photoCommentRestore = photoCommentRestore;
        return this;
    }

    public GroupsSetLongPollSettings setVideoCommentNew(Boolean videoCommentNew) {
        this.videoCommentNew = videoCommentNew;
        return this;
    }

    public GroupsSetLongPollSettings setVideoCommentEdit(Boolean videoCommentEdit) {
        this.videoCommentEdit = videoCommentEdit;
        return this;
    }

    public GroupsSetLongPollSettings setVideoCommentDelete(Boolean videoCommentDelete) {
        this.videoCommentDelete = videoCommentDelete;
        return this;
    }

    public GroupsSetLongPollSettings setVideoCommentRestore(Boolean videoCommentRestore) {
        this.videoCommentRestore = videoCommentRestore;
        return this;
    }

    public GroupsSetLongPollSettings setMarketCommentNew(Boolean marketCommentNew) {
        this.marketCommentNew = marketCommentNew;
        return this;
    }

    public GroupsSetLongPollSettings setMarketCommentEdit(Boolean marketCommentEdit) {
        this.marketCommentEdit = marketCommentEdit;
        return this;
    }

    public GroupsSetLongPollSettings setMarketCommentDelete(Boolean marketCommentDelete) {
        this.marketCommentDelete = marketCommentDelete;
        return this;
    }

    public GroupsSetLongPollSettings setMarketCommentRestore(Boolean marketCommentRestore) {
        this.marketCommentRestore = marketCommentRestore;
        return this;
    }

    public GroupsSetLongPollSettings setPollVoteNew(Boolean pollVoteNew) {
        this.pollVoteNew = pollVoteNew;
        return this;
    }

    public GroupsSetLongPollSettings setGroupJoin(Boolean groupJoin) {
        this.groupJoin = groupJoin;
        return this;
    }

    public GroupsSetLongPollSettings setGroupLeave(Boolean groupLeave) {
        this.groupLeave = groupLeave;
        return this;
    }

    public GroupsSetLongPollSettings setGroupChangeSettings(Boolean groupChangeSettings) {
        this.groupChangeSettings = groupChangeSettings;
        return this;
    }

    public GroupsSetLongPollSettings setGroupChangePhoto(Boolean groupChangePhoto) {
        this.groupChangePhoto = groupChangePhoto;
        return this;
    }

    public GroupsSetLongPollSettings setGroupOfficersEdit(Boolean groupOfficersEdit) {
        this.groupOfficersEdit = groupOfficersEdit;
        return this;
    }

    public GroupsSetLongPollSettings setUserBlock(Boolean userBlock) {
        this.userBlock = userBlock;
        return this;
    }

    public GroupsSetLongPollSettings setUserUnblock(Boolean userUnblock) {
        this.userUnblock = userUnblock;
        return this;
    }

    public GroupsSetLongPollSettings setLeadFormsNew(Boolean leadFormsNew) {
        this.leadFormsNew = leadFormsNew;
        return this;
    }

    public GroupsSetLongPollSettings setLikeAdd(Boolean likeAdd) {
        this.likeAdd = likeAdd;
        return this;
    }

    public GroupsSetLongPollSettings setLikeRemove(Boolean likeRemove) {
        this.likeRemove = likeRemove;
        return this;
    }
}
