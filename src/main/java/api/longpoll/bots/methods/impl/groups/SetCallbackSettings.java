package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>groups.setCallbackSettings</b> method.
 * <p>
 * Allows setting notifications configuration for Callback API.
 *
 * @see <a href="https://vk.com/dev/groups.setCallbackSettings">https://vk.com/dev/groups.setCallbackSettings</a>
 */
public class SetCallbackSettings extends AuthorizedVkApiMethod<IntegerResponse> {
    public SetCallbackSettings(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("groups.setCallbackSettings");
    }

    @Override
    protected Class<IntegerResponse> getResultType() {
        return IntegerResponse.class;
    }

    public SetCallbackSettings setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }

    public SetCallbackSettings setServerId(int serverId) {
        addParam("server_id", serverId);
        return this;
    }

    public SetCallbackSettings setApiVersion(String apiVersion) {
        addParam("api_version", apiVersion);
        return this;
    }

    public SetCallbackSettings setMessageNew(boolean messageNew) {
        addParam("message_new", messageNew);
        return this;
    }

    public SetCallbackSettings setMessageReply(boolean messageReply) {
        addParam("message_reply", messageReply);
        return this;
    }

    public SetCallbackSettings setMessageAllow(boolean messageAllow) {
        addParam("message_allow", messageAllow);
        return this;
    }

    public SetCallbackSettings setMessageEdit(boolean messageEdit) {
        addParam("message_edit", messageEdit);
        return this;
    }

    public SetCallbackSettings setMessageDeny(boolean messageDeny) {
        addParam("message_deny", messageDeny);
        return this;
    }

    public SetCallbackSettings setMessageTypingState(boolean messageTypingState) {
        addParam("message_typing_state", messageTypingState);
        return this;
    }

    public SetCallbackSettings setPhotoNew(boolean photoNew) {
        addParam("photo_new", photoNew);
        return this;
    }

    public SetCallbackSettings setAudioNew(boolean audioNew) {
        addParam("audio_new", audioNew);
        return this;
    }

    public SetCallbackSettings setVideoNew(boolean videoNew) {
        addParam("video_new", videoNew);
        return this;
    }

    public SetCallbackSettings setWallReplyNew(boolean wallReplyNew) {
        addParam("wall_reply_new", wallReplyNew);
        return this;
    }

    public SetCallbackSettings setWallReplyEdit(boolean wallReplyEdit) {
        addParam("wall_reply_edit", wallReplyEdit);
        return this;
    }

    public SetCallbackSettings setWallReplyDelete(boolean wallReplyDelete) {
        addParam("wall_reply_delete", wallReplyDelete);
        return this;
    }

    public SetCallbackSettings setWallReplyRestore(boolean wallReplyRestore) {
        addParam("wall_reply_restore", wallReplyRestore);
        return this;
    }

    public SetCallbackSettings setWallPostNew(boolean wallPostNew) {
        addParam("wall_post_new", wallPostNew);
        return this;
    }

    public SetCallbackSettings setWallPostRepost(boolean wallPostRepost) {
        addParam("wall_repost", wallPostRepost);
        return this;
    }

    public SetCallbackSettings setBoardPostNew(boolean boardPostNew) {
        addParam("board_post_new", boardPostNew);
        return this;
    }

    public SetCallbackSettings setBoardPostEdit(boolean boardPostEdit) {
        addParam("board_post_edit", boardPostEdit);
        return this;
    }

    public SetCallbackSettings setBoardPostRestore(boolean boardPostRestore) {
        addParam("board_post_restore", boardPostRestore);
        return this;
    }

    public SetCallbackSettings setBoardPostDelete(boolean boardPostDelete) {
        addParam("board_post_delete", boardPostDelete);
        return this;
    }

    public SetCallbackSettings setPhotoCommentNew(boolean photoCommentNew) {
        addParam("photo_comment_new", photoCommentNew);
        return this;
    }

    public SetCallbackSettings setPhotoCommentEdit(boolean photoCommentEdit) {
        addParam("photo_comment_edit", photoCommentEdit);
        return this;
    }

    public SetCallbackSettings setPhotoCommentDelete(boolean photoCommentDelete) {
        addParam("photo_comment_delete", photoCommentDelete);
        return this;
    }

    public SetCallbackSettings setPhotoCommentRestore(boolean photoCommentRestore) {
        addParam("photo_comment_restore", photoCommentRestore);
        return this;
    }

    public SetCallbackSettings setVideoCommentNew(boolean videoCommentNew) {
        addParam("video_comment_new", videoCommentNew);
        return this;
    }

    public SetCallbackSettings setVideoCommentEdit(boolean videoCommentEdit) {
        addParam("video_comment_edit", videoCommentEdit);
        return this;
    }

    public SetCallbackSettings setVideoCommentDelete(boolean videoCommentDelete) {
        addParam("video_comment_delete", videoCommentDelete);
        return this;
    }

    public SetCallbackSettings setVideoCommentRestore(boolean videoCommentRestore) {
        addParam("video_comment_restore", videoCommentRestore);
        return this;
    }

    public SetCallbackSettings setMarketCommentNew(boolean marketCommentNew) {
        addParam("market_comment_new", marketCommentNew);
        return this;
    }

    public SetCallbackSettings setMarketCommentEdit(boolean marketCommentEdit) {
        addParam("market_comment_edit", marketCommentEdit);
        return this;
    }

    public SetCallbackSettings setMarketCommentDelete(boolean marketCommentDelete) {
        addParam("market_comment_delete", marketCommentDelete);
        return this;
    }

    public SetCallbackSettings setMarketCommentRestore(boolean marketCommentRestore) {
        addParam("market_comment_restore", marketCommentRestore);
        return this;
    }

    public SetCallbackSettings setPollVoteNew(boolean pollVoteNew) {
        addParam("poll_vote_new", pollVoteNew);
        return this;
    }

    public SetCallbackSettings setGroupJoin(boolean groupJoin) {
        addParam("group_join", groupJoin);
        return this;
    }

    public SetCallbackSettings setGroupLeave(boolean groupLeave) {
        addParam("group_leave", groupLeave);
        return this;
    }

    public SetCallbackSettings setGroupChangeSettings(boolean groupChangeSettings) {
        addParam("group_change_settings", groupChangeSettings);
        return this;
    }

    public SetCallbackSettings setGroupChangePhoto(boolean groupChangePhoto) {
        addParam("group_change_photo", groupChangePhoto);
        return this;
    }

    public SetCallbackSettings setGroupOfficersEdit(boolean groupOfficersEdit) {
        addParam("group_officers_edit", groupOfficersEdit);
        return this;
    }

    public SetCallbackSettings setUserBlock(boolean userBlock) {
        addParam("user_block", userBlock);
        return this;
    }

    public SetCallbackSettings setUserUnblock(boolean userUnblock) {
        addParam("user_unblock", userUnblock);
        return this;
    }

    public SetCallbackSettings setLeadFormsNew(boolean leadFormsNew) {
        addParam("lead_forms_new", leadFormsNew);
        return this;
    }

    public SetCallbackSettings setLikeAdd(boolean likeAdd) {
        addParam("like_add", likeAdd);
        return this;
    }

    public SetCallbackSettings setLikeRemove(boolean likeRemove) {
        addParam("like_remove", likeRemove);
        return this;
    }
}
