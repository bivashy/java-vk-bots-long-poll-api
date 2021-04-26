package api.longpoll.bots.methods.groups;

import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.IntegerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>groups.setCallbackSettings</b> method.
 *
 * @see <a href="https://vk.com/dev/groups.setCallbackSettings">https://vk.com/dev/groups.setCallbackSettings</a>
 */
public class GroupsSetCallbackSettings extends GetMethod<IntegerResult> {
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

    public Integer getGroupId() {
        return groupId;
    }

    public GroupsSetCallbackSettings setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public Integer getServerId() {
        return serverId;
    }

    public GroupsSetCallbackSettings setServerId(Integer serverId) {
        this.serverId = serverId;
        return this;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public GroupsSetCallbackSettings setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    public Boolean getMessageNew() {
        return messageNew;
    }

    public GroupsSetCallbackSettings setMessageNew(Boolean messageNew) {
        this.messageNew = messageNew;
        return this;
    }

    public Boolean getMessageReply() {
        return messageReply;
    }

    public GroupsSetCallbackSettings setMessageReply(Boolean messageReply) {
        this.messageReply = messageReply;
        return this;
    }

    public Boolean getMessageAllow() {
        return messageAllow;
    }

    public GroupsSetCallbackSettings setMessageAllow(Boolean messageAllow) {
        this.messageAllow = messageAllow;
        return this;
    }

    public Boolean getMessageEdit() {
        return messageEdit;
    }

    public GroupsSetCallbackSettings setMessageEdit(Boolean messageEdit) {
        this.messageEdit = messageEdit;
        return this;
    }

    public Boolean getMessageDeny() {
        return messageDeny;
    }

    public GroupsSetCallbackSettings setMessageDeny(Boolean messageDeny) {
        this.messageDeny = messageDeny;
        return this;
    }

    public Boolean getMessageTypingState() {
        return messageTypingState;
    }

    public GroupsSetCallbackSettings setMessageTypingState(Boolean messageTypingState) {
        this.messageTypingState = messageTypingState;
        return this;
    }

    public Boolean getPhotoNew() {
        return photoNew;
    }

    public GroupsSetCallbackSettings setPhotoNew(Boolean photoNew) {
        this.photoNew = photoNew;
        return this;
    }

    public Boolean getAudioNew() {
        return audioNew;
    }

    public GroupsSetCallbackSettings setAudioNew(Boolean audioNew) {
        this.audioNew = audioNew;
        return this;
    }

    public Boolean getVideoNew() {
        return videoNew;
    }

    public GroupsSetCallbackSettings setVideoNew(Boolean videoNew) {
        this.videoNew = videoNew;
        return this;
    }

    public Boolean getWallReplyNew() {
        return wallReplyNew;
    }

    public GroupsSetCallbackSettings setWallReplyNew(Boolean wallReplyNew) {
        this.wallReplyNew = wallReplyNew;
        return this;
    }

    public Boolean getWallReplyEdit() {
        return wallReplyEdit;
    }

    public GroupsSetCallbackSettings setWallReplyEdit(Boolean wallReplyEdit) {
        this.wallReplyEdit = wallReplyEdit;
        return this;
    }

    public Boolean getWallReplyDelete() {
        return wallReplyDelete;
    }

    public GroupsSetCallbackSettings setWallReplyDelete(Boolean wallReplyDelete) {
        this.wallReplyDelete = wallReplyDelete;
        return this;
    }

    public Boolean getWallReplyRestore() {
        return wallReplyRestore;
    }

    public GroupsSetCallbackSettings setWallReplyRestore(Boolean wallReplyRestore) {
        this.wallReplyRestore = wallReplyRestore;
        return this;
    }

    public Boolean getWallPostNew() {
        return wallPostNew;
    }

    public GroupsSetCallbackSettings setWallPostNew(Boolean wallPostNew) {
        this.wallPostNew = wallPostNew;
        return this;
    }

    public Boolean getWallPostRepost() {
        return wallPostRepost;
    }

    public GroupsSetCallbackSettings setWallPostRepost(Boolean wallPostRepost) {
        this.wallPostRepost = wallPostRepost;
        return this;
    }

    public Boolean getBoardPostNew() {
        return boardPostNew;
    }

    public GroupsSetCallbackSettings setBoardPostNew(Boolean boardPostNew) {
        this.boardPostNew = boardPostNew;
        return this;
    }

    public Boolean getBoardPostEdit() {
        return boardPostEdit;
    }

    public GroupsSetCallbackSettings setBoardPostEdit(Boolean boardPostEdit) {
        this.boardPostEdit = boardPostEdit;
        return this;
    }

    public Boolean getBoardPostRestore() {
        return boardPostRestore;
    }

    public GroupsSetCallbackSettings setBoardPostRestore(Boolean boardPostRestore) {
        this.boardPostRestore = boardPostRestore;
        return this;
    }

    public Boolean getBoardPostDelete() {
        return boardPostDelete;
    }

    public GroupsSetCallbackSettings setBoardPostDelete(Boolean boardPostDelete) {
        this.boardPostDelete = boardPostDelete;
        return this;
    }

    public Boolean getPhotoCommentNew() {
        return photoCommentNew;
    }

    public GroupsSetCallbackSettings setPhotoCommentNew(Boolean photoCommentNew) {
        this.photoCommentNew = photoCommentNew;
        return this;
    }

    public Boolean getPhotoCommentEdit() {
        return photoCommentEdit;
    }

    public GroupsSetCallbackSettings setPhotoCommentEdit(Boolean photoCommentEdit) {
        this.photoCommentEdit = photoCommentEdit;
        return this;
    }

    public Boolean getPhotoCommentDelete() {
        return photoCommentDelete;
    }

    public GroupsSetCallbackSettings setPhotoCommentDelete(Boolean photoCommentDelete) {
        this.photoCommentDelete = photoCommentDelete;
        return this;
    }

    public Boolean getPhotoCommentRestore() {
        return photoCommentRestore;
    }

    public GroupsSetCallbackSettings setPhotoCommentRestore(Boolean photoCommentRestore) {
        this.photoCommentRestore = photoCommentRestore;
        return this;
    }

    public Boolean getVideoCommentNew() {
        return videoCommentNew;
    }

    public GroupsSetCallbackSettings setVideoCommentNew(Boolean videoCommentNew) {
        this.videoCommentNew = videoCommentNew;
        return this;
    }

    public Boolean getVideoCommentEdit() {
        return videoCommentEdit;
    }

    public GroupsSetCallbackSettings setVideoCommentEdit(Boolean videoCommentEdit) {
        this.videoCommentEdit = videoCommentEdit;
        return this;
    }

    public Boolean getVideoCommentDelete() {
        return videoCommentDelete;
    }

    public GroupsSetCallbackSettings setVideoCommentDelete(Boolean videoCommentDelete) {
        this.videoCommentDelete = videoCommentDelete;
        return this;
    }

    public Boolean getVideoCommentRestore() {
        return videoCommentRestore;
    }

    public GroupsSetCallbackSettings setVideoCommentRestore(Boolean videoCommentRestore) {
        this.videoCommentRestore = videoCommentRestore;
        return this;
    }

    public Boolean getMarketCommentNew() {
        return marketCommentNew;
    }

    public GroupsSetCallbackSettings setMarketCommentNew(Boolean marketCommentNew) {
        this.marketCommentNew = marketCommentNew;
        return this;
    }

    public Boolean getMarketCommentEdit() {
        return marketCommentEdit;
    }

    public GroupsSetCallbackSettings setMarketCommentEdit(Boolean marketCommentEdit) {
        this.marketCommentEdit = marketCommentEdit;
        return this;
    }

    public Boolean getMarketCommentDelete() {
        return marketCommentDelete;
    }

    public GroupsSetCallbackSettings setMarketCommentDelete(Boolean marketCommentDelete) {
        this.marketCommentDelete = marketCommentDelete;
        return this;
    }

    public Boolean getMarketCommentRestore() {
        return marketCommentRestore;
    }

    public GroupsSetCallbackSettings setMarketCommentRestore(Boolean marketCommentRestore) {
        this.marketCommentRestore = marketCommentRestore;
        return this;
    }

    public Boolean getPollVoteNew() {
        return pollVoteNew;
    }

    public GroupsSetCallbackSettings setPollVoteNew(Boolean pollVoteNew) {
        this.pollVoteNew = pollVoteNew;
        return this;
    }

    public Boolean getGroupJoin() {
        return groupJoin;
    }

    public GroupsSetCallbackSettings setGroupJoin(Boolean groupJoin) {
        this.groupJoin = groupJoin;
        return this;
    }

    public Boolean getGroupLeave() {
        return groupLeave;
    }

    public GroupsSetCallbackSettings setGroupLeave(Boolean groupLeave) {
        this.groupLeave = groupLeave;
        return this;
    }

    public Boolean getGroupChangeSettings() {
        return groupChangeSettings;
    }

    public GroupsSetCallbackSettings setGroupChangeSettings(Boolean groupChangeSettings) {
        this.groupChangeSettings = groupChangeSettings;
        return this;
    }

    public Boolean getGroupChangePhoto() {
        return groupChangePhoto;
    }

    public GroupsSetCallbackSettings setGroupChangePhoto(Boolean groupChangePhoto) {
        this.groupChangePhoto = groupChangePhoto;
        return this;
    }

    public Boolean getGroupOfficersEdit() {
        return groupOfficersEdit;
    }

    public GroupsSetCallbackSettings setGroupOfficersEdit(Boolean groupOfficersEdit) {
        this.groupOfficersEdit = groupOfficersEdit;
        return this;
    }

    public Boolean getUserBlock() {
        return userBlock;
    }

    public GroupsSetCallbackSettings setUserBlock(Boolean userBlock) {
        this.userBlock = userBlock;
        return this;
    }

    public Boolean getUserUnblock() {
        return userUnblock;
    }

    public GroupsSetCallbackSettings setUserUnblock(Boolean userUnblock) {
        this.userUnblock = userUnblock;
        return this;
    }

    public Boolean getLeadFormsNew() {
        return leadFormsNew;
    }

    public GroupsSetCallbackSettings setLeadFormsNew(Boolean leadFormsNew) {
        this.leadFormsNew = leadFormsNew;
        return this;
    }

    public Boolean getLikeAdd() {
        return likeAdd;
    }

    public GroupsSetCallbackSettings setLikeAdd(Boolean likeAdd) {
        this.likeAdd = likeAdd;
        return this;
    }

    public Boolean getLikeRemove() {
        return likeRemove;
    }

    public GroupsSetCallbackSettings setLikeRemove(Boolean likeRemove) {
        this.likeRemove = likeRemove;
        return this;
    }
}
