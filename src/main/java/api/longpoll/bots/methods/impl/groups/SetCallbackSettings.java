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
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public SetCallbackSettings setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public SetCallbackSettings setServerId(int serverId) {
        return addParam("server_id", serverId);
    }

    public SetCallbackSettings setApiVersion(String apiVersion) {
        return addParam("api_version", apiVersion);
    }

    public SetCallbackSettings setMessageNew(boolean messageNew) {
        return addParam("message_new", messageNew);
    }

    public SetCallbackSettings setMessageReply(boolean messageReply) {
        return addParam("message_reply", messageReply);
    }

    public SetCallbackSettings setMessageAllow(boolean messageAllow) {
        return addParam("message_allow", messageAllow);
    }

    public SetCallbackSettings setMessageEdit(boolean messageEdit) {
        return addParam("message_edit", messageEdit);
    }

    public SetCallbackSettings setMessageDeny(boolean messageDeny) {
        return addParam("message_deny", messageDeny);
    }

    public SetCallbackSettings setMessageTypingState(boolean messageTypingState) {
        return addParam("message_typing_state", messageTypingState);
    }

    public SetCallbackSettings setPhotoNew(boolean photoNew) {
        return addParam("photo_new", photoNew);
    }

    public SetCallbackSettings setAudioNew(boolean audioNew) {
        return addParam("audio_new", audioNew);
    }

    public SetCallbackSettings setVideoNew(boolean videoNew) {
        return addParam("video_new", videoNew);
    }

    public SetCallbackSettings setWallReplyNew(boolean wallReplyNew) {
        return addParam("wall_reply_new", wallReplyNew);
    }

    public SetCallbackSettings setWallReplyEdit(boolean wallReplyEdit) {
        return addParam("wall_reply_edit", wallReplyEdit);
    }

    public SetCallbackSettings setWallReplyDelete(boolean wallReplyDelete) {
        return addParam("wall_reply_delete", wallReplyDelete);
    }

    public SetCallbackSettings setWallReplyRestore(boolean wallReplyRestore) {
        return addParam("wall_reply_restore", wallReplyRestore);
    }

    public SetCallbackSettings setWallPostNew(boolean wallPostNew) {
        return addParam("wall_post_new", wallPostNew);
    }

    public SetCallbackSettings setWallPostRepost(boolean wallPostRepost) {
        return addParam("wall_repost", wallPostRepost);
    }

    public SetCallbackSettings setBoardPostNew(boolean boardPostNew) {
        return addParam("board_post_new", boardPostNew);
    }

    public SetCallbackSettings setBoardPostEdit(boolean boardPostEdit) {
        return addParam("board_post_edit", boardPostEdit);
    }

    public SetCallbackSettings setBoardPostRestore(boolean boardPostRestore) {
        return addParam("board_post_restore", boardPostRestore);
    }

    public SetCallbackSettings setBoardPostDelete(boolean boardPostDelete) {
        return addParam("board_post_delete", boardPostDelete);
    }

    public SetCallbackSettings setPhotoCommentNew(boolean photoCommentNew) {
        return addParam("photo_comment_new", photoCommentNew);
    }

    public SetCallbackSettings setPhotoCommentEdit(boolean photoCommentEdit) {
        return addParam("photo_comment_edit", photoCommentEdit);
    }

    public SetCallbackSettings setPhotoCommentDelete(boolean photoCommentDelete) {
        return addParam("photo_comment_delete", photoCommentDelete);
    }

    public SetCallbackSettings setPhotoCommentRestore(boolean photoCommentRestore) {
        return addParam("photo_comment_restore", photoCommentRestore);
    }

    public SetCallbackSettings setVideoCommentNew(boolean videoCommentNew) {
        return addParam("video_comment_new", videoCommentNew);
    }

    public SetCallbackSettings setVideoCommentEdit(boolean videoCommentEdit) {
        return addParam("video_comment_edit", videoCommentEdit);
    }

    public SetCallbackSettings setVideoCommentDelete(boolean videoCommentDelete) {
        return addParam("video_comment_delete", videoCommentDelete);
    }

    public SetCallbackSettings setVideoCommentRestore(boolean videoCommentRestore) {
        return addParam("video_comment_restore", videoCommentRestore);
    }

    public SetCallbackSettings setMarketCommentNew(boolean marketCommentNew) {
        return addParam("market_comment_new", marketCommentNew);
    }

    public SetCallbackSettings setMarketCommentEdit(boolean marketCommentEdit) {
        return addParam("market_comment_edit", marketCommentEdit);
    }

    public SetCallbackSettings setMarketCommentDelete(boolean marketCommentDelete) {
        return addParam("market_comment_delete", marketCommentDelete);
    }

    public SetCallbackSettings setMarketCommentRestore(boolean marketCommentRestore) {
        return addParam("market_comment_restore", marketCommentRestore);
    }

    public SetCallbackSettings setPollVoteNew(boolean pollVoteNew) {
        return addParam("poll_vote_new", pollVoteNew);
    }

    public SetCallbackSettings setGroupJoin(boolean groupJoin) {
        return addParam("group_join", groupJoin);
    }

    public SetCallbackSettings setGroupLeave(boolean groupLeave) {
        return addParam("group_leave", groupLeave);
    }

    public SetCallbackSettings setGroupChangeSettings(boolean groupChangeSettings) {
        return addParam("group_change_settings", groupChangeSettings);
    }

    public SetCallbackSettings setGroupChangePhoto(boolean groupChangePhoto) {
        return addParam("group_change_photo", groupChangePhoto);
    }

    public SetCallbackSettings setGroupOfficersEdit(boolean groupOfficersEdit) {
        return addParam("group_officers_edit", groupOfficersEdit);
    }

    public SetCallbackSettings setUserBlock(boolean userBlock) {
        return addParam("user_block", userBlock);
    }

    public SetCallbackSettings setUserUnblock(boolean userUnblock) {
        return addParam("user_unblock", userUnblock);
    }

    public SetCallbackSettings setLeadFormsNew(boolean leadFormsNew) {
        return addParam("lead_forms_new", leadFormsNew);
    }

    public SetCallbackSettings setLikeAdd(boolean likeAdd) {
        return addParam("like_add", likeAdd);
    }

    public SetCallbackSettings setLikeRemove(boolean likeRemove) {
        return addParam("like_remove", likeRemove);
    }

    @Override
    public SetCallbackSettings addParam(String key, Object value) {
        return (SetCallbackSettings) super.addParam(key, value);
    }
}
