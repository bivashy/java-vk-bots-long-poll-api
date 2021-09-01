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
        addParam("group_id", groupId);
        return this;
    }

    public SetLongPollSettings setEnabled(boolean enabled) {
        addParam("enabled", new BoolInt(enabled));
        return this;
    }

    public SetLongPollSettings setApiVersion(String apiVersion) {
        addParam("api_version", apiVersion);
        return this;
    }

    public SetLongPollSettings setMessageNew(boolean messageNew) {
        addParam("message_new", messageNew);
        return this;
    }

    public SetLongPollSettings setMessageReply(boolean messageReply) {
        addParam("message_reply", messageReply);
        return this;
    }

    public SetLongPollSettings setMessageAllow(boolean messageAllow) {
        addParam("message_allow", messageAllow);
        return this;
    }

    public SetLongPollSettings setMessageEdit(boolean messageEdit) {
        addParam("message_edit", messageEdit);
        return this;
    }

    public SetLongPollSettings setMessageDeny(boolean messageDeny) {
        addParam("message_deny", messageDeny);
        return this;
    }

    public SetLongPollSettings setMessageTypingState(boolean messageTypingState) {
        addParam("message_typing_state", messageTypingState);
        return this;
    }

    public SetLongPollSettings setPhotoNew(boolean photoNew) {
        addParam("photo_new", photoNew);
        return this;
    }

    public SetLongPollSettings setAudioNew(boolean audioNew) {
        addParam("audio_new", audioNew);
        return this;
    }

    public SetLongPollSettings setVideoNew(boolean videoNew) {
        addParam("video_new", videoNew);
        return this;
    }

    public SetLongPollSettings setWallReplyNew(boolean wallReplyNew) {
        addParam("wall_reply_new", wallReplyNew);
        return this;
    }

    public SetLongPollSettings setWallReplyEdit(boolean wallReplyEdit) {
        addParam("wall_reply_edit", wallReplyEdit);
        return this;
    }

    public SetLongPollSettings setWallReplyDelete(boolean wallReplyDelete) {
        addParam("wall_reply_delete", wallReplyDelete);
        return this;
    }

    public SetLongPollSettings setWallReplyRestore(boolean wallReplyRestore) {
        addParam("wall_reply_restore", wallReplyRestore);
        return this;
    }

    public SetLongPollSettings setWallPostNew(boolean wallPostNew) {
        addParam("wall_post_new", wallPostNew);
        return this;
    }

    public SetLongPollSettings setWallPostRepost(boolean wallPostRepost) {
        addParam("wall_repost", wallPostRepost);
        return this;
    }

    public SetLongPollSettings setBoardPostNew(boolean boardPostNew) {
        addParam("board_post_new", boardPostNew);
        return this;
    }

    public SetLongPollSettings setBoardPostEdit(boolean boardPostEdit) {
        addParam("board_post_edit", boardPostEdit);
        return this;
    }

    public SetLongPollSettings setBoardPostRestore(boolean boardPostRestore) {
        addParam("board_post_restore", boardPostRestore);
        return this;
    }

    public SetLongPollSettings setBoardPostDelete(boolean boardPostDelete) {
        addParam("board_post_delete", boardPostDelete);
        return this;
    }

    public SetLongPollSettings setPhotoCommentNew(boolean photoCommentNew) {
        addParam("photo_comment_new", photoCommentNew);
        return this;
    }

    public SetLongPollSettings setPhotoCommentEdit(boolean photoCommentEdit) {
        addParam("photo_comment_edit", photoCommentEdit);
        return this;
    }

    public SetLongPollSettings setPhotoCommentDelete(boolean photoCommentDelete) {
        addParam("photo_comment_delete", photoCommentDelete);
        return this;
    }

    public SetLongPollSettings setPhotoCommentRestore(boolean photoCommentRestore) {
        addParam("photo_comment_restore", photoCommentRestore);
        return this;
    }

    public SetLongPollSettings setVideoCommentNew(boolean videoCommentNew) {
        addParam("video_comment_new", videoCommentNew);
        return this;
    }

    public SetLongPollSettings setVideoCommentEdit(boolean videoCommentEdit) {
        addParam("video_comment_edit", videoCommentEdit);
        return this;
    }

    public SetLongPollSettings setVideoCommentDelete(boolean videoCommentDelete) {
        addParam("video_comment_delete", videoCommentDelete);
        return this;
    }

    public SetLongPollSettings setVideoCommentRestore(boolean videoCommentRestore) {
        addParam("video_comment_restore", videoCommentRestore);
        return this;
    }

    public SetLongPollSettings setMarketCommentNew(boolean marketCommentNew) {
        addParam("market_comment_new", marketCommentNew);
        return this;
    }

    public SetLongPollSettings setMarketCommentEdit(boolean marketCommentEdit) {
        addParam("market_comment_edit", marketCommentEdit);
        return this;
    }

    public SetLongPollSettings setMarketCommentDelete(boolean marketCommentDelete) {
        addParam("market_comment_delete", marketCommentDelete);
        return this;
    }

    public SetLongPollSettings setMarketCommentRestore(boolean marketCommentRestore) {
        addParam("market_comment_restore", marketCommentRestore);
        return this;
    }

    public SetLongPollSettings setPollVoteNew(boolean pollVoteNew) {
        addParam("poll_vote_new", pollVoteNew);
        return this;
    }

    public SetLongPollSettings setGroupJoin(boolean groupJoin) {
        addParam("group_join", groupJoin);
        return this;
    }

    public SetLongPollSettings setGroupLeave(boolean groupLeave) {
        addParam("group_leave", groupLeave);
        return this;
    }

    public SetLongPollSettings setGroupChangeSettings(boolean groupChangeSettings) {
        addParam("group_change_settings", groupChangeSettings);
        return this;
    }

    public SetLongPollSettings setGroupChangePhoto(boolean groupChangePhoto) {
        addParam("group_change_photo", groupChangePhoto);
        return this;
    }

    public SetLongPollSettings setGroupOfficersEdit(boolean groupOfficersEdit) {
        addParam("group_officers_edit", groupOfficersEdit);
        return this;
    }

    public SetLongPollSettings setUserBlock(boolean userBlock) {
        addParam("user_block", userBlock);
        return this;
    }

    public SetLongPollSettings setUserUnblock(boolean userUnblock) {
        addParam("user_unblock", userUnblock);
        return this;
    }

    public SetLongPollSettings setLeadFormsNew(boolean leadFormsNew) {
        addParam("lead_forms_new", leadFormsNew);
        return this;
    }

    public SetLongPollSettings setLikeAdd(boolean likeAdd) {
        addParam("like_add", likeAdd);
        return this;
    }

    public SetLongPollSettings setLikeRemove(boolean likeRemove) {
        addParam("like_remove", likeRemove);
        return this;
    }
}
