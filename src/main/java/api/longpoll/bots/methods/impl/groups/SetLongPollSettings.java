package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>groups.setLongPollSettings</b> method.
 * <p>
 * Allows setting Bots Long Poll API configuration in the community.
 *
 * @see <a href="https://vk.com/dev/groups.setLongPollSettings">https://vk.com/dev/groups.setLongPollSettings</a>
 */
public class SetLongPollSettings extends AuthorizedVkApiMethod<IntegerResponse> {
    public SetLongPollSettings(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("groups.setLongPollSettings");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
    }

    public SetLongPollSettings setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public SetLongPollSettings setEnabled(boolean enabled) {
        return addParam("enabled", new BoolInt(enabled));
    }

    public SetLongPollSettings setApiVersion(String apiVersion) {
        return addParam("api_version", apiVersion);
    }

    public SetLongPollSettings setMessageNew(boolean messageNew) {
        return addParam("message_new", messageNew);
    }

    public SetLongPollSettings setMessageReply(boolean messageReply) {
        return addParam("message_reply", messageReply);
    }

    public SetLongPollSettings setMessageAllow(boolean messageAllow) {
        return addParam("message_allow", messageAllow);
    }

    public SetLongPollSettings setMessageEdit(boolean messageEdit) {
        return addParam("message_edit", messageEdit);
    }

    public SetLongPollSettings setMessageDeny(boolean messageDeny) {
        return addParam("message_deny", messageDeny);
    }

    public SetLongPollSettings setMessageTypingState(boolean messageTypingState) {
        return addParam("message_typing_state", messageTypingState);
    }

    public SetLongPollSettings setPhotoNew(boolean photoNew) {
        return addParam("photo_new", photoNew);
    }

    public SetLongPollSettings setAudioNew(boolean audioNew) {
        return addParam("audio_new", audioNew);
    }

    public SetLongPollSettings setVideoNew(boolean videoNew) {
        return addParam("video_new", videoNew);
    }

    public SetLongPollSettings setWallReplyNew(boolean wallReplyNew) {
        return addParam("wall_reply_new", wallReplyNew);
    }

    public SetLongPollSettings setWallReplyEdit(boolean wallReplyEdit) {
        return addParam("wall_reply_edit", wallReplyEdit);
    }

    public SetLongPollSettings setWallReplyDelete(boolean wallReplyDelete) {
        return addParam("wall_reply_delete", wallReplyDelete);
    }

    public SetLongPollSettings setWallReplyRestore(boolean wallReplyRestore) {
        return addParam("wall_reply_restore", wallReplyRestore);
    }

    public SetLongPollSettings setWallPostNew(boolean wallPostNew) {
        return addParam("wall_post_new", wallPostNew);
    }

    public SetLongPollSettings setWallPostRepost(boolean wallPostRepost) {
        return addParam("wall_repost", wallPostRepost);
    }

    public SetLongPollSettings setBoardPostNew(boolean boardPostNew) {
        return addParam("board_post_new", boardPostNew);
    }

    public SetLongPollSettings setBoardPostEdit(boolean boardPostEdit) {
        return addParam("board_post_edit", boardPostEdit);
    }

    public SetLongPollSettings setBoardPostRestore(boolean boardPostRestore) {
        return addParam("board_post_restore", boardPostRestore);
    }

    public SetLongPollSettings setBoardPostDelete(boolean boardPostDelete) {
        return addParam("board_post_delete", boardPostDelete);
    }

    public SetLongPollSettings setPhotoCommentNew(boolean photoCommentNew) {
        return addParam("photo_comment_new", photoCommentNew);
    }

    public SetLongPollSettings setPhotoCommentEdit(boolean photoCommentEdit) {
        return addParam("photo_comment_edit", photoCommentEdit);
    }

    public SetLongPollSettings setPhotoCommentDelete(boolean photoCommentDelete) {
        return addParam("photo_comment_delete", photoCommentDelete);
    }

    public SetLongPollSettings setPhotoCommentRestore(boolean photoCommentRestore) {
        return addParam("photo_comment_restore", photoCommentRestore);
    }

    public SetLongPollSettings setVideoCommentNew(boolean videoCommentNew) {
        return addParam("video_comment_new", videoCommentNew);
    }

    public SetLongPollSettings setVideoCommentEdit(boolean videoCommentEdit) {
        return addParam("video_comment_edit", videoCommentEdit);
    }

    public SetLongPollSettings setVideoCommentDelete(boolean videoCommentDelete) {
        return addParam("video_comment_delete", videoCommentDelete);
    }

    public SetLongPollSettings setVideoCommentRestore(boolean videoCommentRestore) {
        return addParam("video_comment_restore", videoCommentRestore);
    }

    public SetLongPollSettings setMarketCommentNew(boolean marketCommentNew) {
        return addParam("market_comment_new", marketCommentNew);
    }

    public SetLongPollSettings setMarketCommentEdit(boolean marketCommentEdit) {
        return addParam("market_comment_edit", marketCommentEdit);
    }

    public SetLongPollSettings setMarketCommentDelete(boolean marketCommentDelete) {
        return addParam("market_comment_delete", marketCommentDelete);
    }

    public SetLongPollSettings setMarketCommentRestore(boolean marketCommentRestore) {
        return addParam("market_comment_restore", marketCommentRestore);
    }

    public SetLongPollSettings setPollVoteNew(boolean pollVoteNew) {
        return addParam("poll_vote_new", pollVoteNew);
    }

    public SetLongPollSettings setGroupJoin(boolean groupJoin) {
        return addParam("group_join", groupJoin);
    }

    public SetLongPollSettings setGroupLeave(boolean groupLeave) {
        return addParam("group_leave", groupLeave);
    }

    public SetLongPollSettings setGroupChangeSettings(boolean groupChangeSettings) {
        return addParam("group_change_settings", groupChangeSettings);
    }

    public SetLongPollSettings setGroupChangePhoto(boolean groupChangePhoto) {
        return addParam("group_change_photo", groupChangePhoto);
    }

    public SetLongPollSettings setGroupOfficersEdit(boolean groupOfficersEdit) {
        return addParam("group_officers_edit", groupOfficersEdit);
    }

    public SetLongPollSettings setUserBlock(boolean userBlock) {
        return addParam("user_block", userBlock);
    }

    public SetLongPollSettings setUserUnblock(boolean userUnblock) {
        return addParam("user_unblock", userUnblock);
    }

    public SetLongPollSettings setLeadFormsNew(boolean leadFormsNew) {
        return addParam("lead_forms_new", leadFormsNew);
    }

    public SetLongPollSettings setLikeAdd(boolean likeAdd) {
        return addParam("like_add", likeAdd);
    }

    public SetLongPollSettings setLikeRemove(boolean likeRemove) {
        return addParam("like_remove", likeRemove);
    }

    @Override
    public SetLongPollSettings addParam(String key, Object value) {
        return (SetLongPollSettings) super.addParam(key, value);
    }
}
