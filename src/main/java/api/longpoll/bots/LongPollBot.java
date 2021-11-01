package api.longpoll.bots;

import api.longpoll.bots.methods.impl.VkBotsApi;
import api.longpoll.bots.model.events.boards.BoardPostDeleteEvent;
import api.longpoll.bots.model.events.boards.BoardPostEvent;
import api.longpoll.bots.model.events.likes.LikeEvent;
import api.longpoll.bots.model.events.market.MarketCommentDeleteEvent;
import api.longpoll.bots.model.events.market.MarketCommentEvent;
import api.longpoll.bots.model.events.messages.MessageAllowEvent;
import api.longpoll.bots.model.events.messages.MessageDenyEvent;
import api.longpoll.bots.model.events.messages.MessageEvent;
import api.longpoll.bots.model.events.messages.MessageNewEvent;
import api.longpoll.bots.model.events.messages.MessageTypingStateEvent;
import api.longpoll.bots.model.events.other.AppPayload;
import api.longpoll.bots.model.events.other.GroupChangePhotoEvent;
import api.longpoll.bots.model.events.other.GroupChangeSettingsEvent;
import api.longpoll.bots.model.events.other.VkpayTransaction;
import api.longpoll.bots.model.events.photos.PhotoCommentDeleteEvent;
import api.longpoll.bots.model.events.photos.PhotoCommentEvent;
import api.longpoll.bots.model.events.users.GroupJoinEvent;
import api.longpoll.bots.model.events.users.GroupLeaveEvent;
import api.longpoll.bots.model.events.users.UserBlockEvent;
import api.longpoll.bots.model.events.users.UserUnblockEvent;
import api.longpoll.bots.model.events.video.VideoCommentDeleteEvent;
import api.longpoll.bots.model.events.video.VideoCommentEvent;
import api.longpoll.bots.model.events.wall.comments.WallReplyDeleteEvent;
import api.longpoll.bots.model.events.wall.comments.WallReplyEvent;
import api.longpoll.bots.model.objects.basic.MarketOrder;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.objects.basic.WallPost;
import api.longpoll.bots.model.objects.media.Audio;
import api.longpoll.bots.model.objects.media.Photo;
import api.longpoll.bots.model.objects.media.Video;

/**
 * Abstract bot to handle VK events.
 */
public abstract class LongPollBot {
    /**
     * VK Bots API methods.
     */
    protected VkBotsApi vkBotsApi = new VkBotsApi(getAccessToken());

    /**
     * Gets bot access token.
     *
     * @return access token.
     */
    public abstract String getAccessToken();

    /**
     * Get bot group ID.
     *
     * @return group ID.
     */
    public abstract int getGroupId();

    /**
     * Handles <b>message_new</b> events.
     *
     * @param messageNewEvent event object.
     */
    public void onMessageNew(MessageNewEvent messageNewEvent) {
    }

    /**
     * Handles <b>message_reply</b> events.
     *
     * @param message event object.
     */
    public void onMessageReply(Message message) {
    }

    /**
     * Handles <b>message_edit</b> events.
     *
     * @param message event object.
     */
    public void onMessageEdit(Message message) {
    }

    /**
     * Handles <b>message_event</b> events.
     *
     * @param messageEvent event object.
     */
    public void onMessageEvent(MessageEvent messageEvent) {
    }

    /**
     * Handles <b>photo_new</b> events.
     *
     * @param photo event object.
     */
    public void onPhotoNew(Photo photo) {
    }

    /**
     * Handles <b>photo_comment_new</b> events.
     *
     * @param photoCommentEvent event object.
     */
    public void onPhotoCommentNew(PhotoCommentEvent photoCommentEvent) {
    }

    /**
     * Handles <b>photo_comment_edit</b> events.
     *
     * @param photoCommentEvent event object.
     */
    public void onPhotoCommentEdit(PhotoCommentEvent photoCommentEvent) {
    }

    /**
     * Handles <b>photo_comment_delete</b> events.
     *
     * @param photoCommentDeleteEvent event object.
     */
    public void onPhotoCommentDelete(PhotoCommentDeleteEvent photoCommentDeleteEvent) {
    }

    /**
     * Handles <b>photo_comment_restore</b> events.
     *
     * @param photoCommentEvent event object.
     */
    public void onPhotoCommentRestore(PhotoCommentEvent photoCommentEvent) {
    }

    /**
     * Handles <b>video_new</b> events.
     *
     * @param video event object.
     */
    public void onVideoNew(Video video) {
    }

    /**
     * Handles <b>audio_new</b> events.
     *
     * @param audio event object.
     */
    public void onAudioNew(Audio audio) {
    }

    /**
     * Handles <b>video_comment_new</b> events.
     *
     * @param videoCommentEvent event object.
     */
    public void onVideoCommentNew(VideoCommentEvent videoCommentEvent) {
    }

    /**
     * Handles <b>video_comment_edit</b> events.
     *
     * @param videoCommentEvent event object.
     */
    public void onVideoCommentEdit(VideoCommentEvent videoCommentEvent) {
    }

    /**
     * Handles <b>video_comment_delete</b> events.
     *
     * @param videoCommentDeleteEvent event object.
     */
    public void onVideoCommentDelete(VideoCommentDeleteEvent videoCommentDeleteEvent) {
    }

    /**
     * Handles <b>video_comment_restore</b> events.
     *
     * @param videoCommentEvent event object.
     */
    public void onVideoCommentRestore(VideoCommentEvent videoCommentEvent) {
    }

    /**
     * Handles <b>wall_post_new</b> events.
     *
     * @param wallPost event object.
     */
    public void onWallPostNew(WallPost wallPost) {
    }

    /**
     * Handles <b>wall_repost</b> events.
     *
     * @param wallPost event object.
     */
    public void onWallRepost(WallPost wallPost) {
    }

    /**
     * Handles <b>like_add</b> events.
     *
     * @param likeEvent event object.
     */
    public void onLikeAdd(LikeEvent likeEvent) {
    }

    /**
     * Handles <b>like_remove</b> events.
     *
     * @param likeEvent event object.
     */
    public void onLikeRemove(LikeEvent likeEvent) {
    }

    /**
     * Handles <b>wall_reply_new</b> events.
     *
     * @param wallReplyEvent event object.
     */
    public void onWallReplyNew(WallReplyEvent wallReplyEvent) {
    }

    /**
     * Handles <b>wall_reply_edit</b> events.
     *
     * @param wallReplyEvent event object.
     */
    public void onWallReplyEdit(WallReplyEvent wallReplyEvent) {
    }

    /**
     * Handles <b>wall_reply_delete</b> events.
     *
     * @param wallReplyDeleteEvent event object.
     */
    public void onWallReplyDelete(WallReplyDeleteEvent wallReplyDeleteEvent) {
    }

    /**
     * Handles <b>wall_reply_restore</b> events.
     *
     * @param wallReplyEvent event object.
     */
    public void onWallReplyRestore(WallReplyEvent wallReplyEvent) {
    }

    /**
     * Handles <b>board_post_new</b> events.
     *
     * @param boardPostEvent event object.
     */
    public void onBoardPostNew(BoardPostEvent boardPostEvent) {
    }

    /**
     * Handles <b>board_post_edit</b> events.
     *
     * @param boardPostEvent event object.
     */
    public void onBoardPostEdit(BoardPostEvent boardPostEvent) {
    }

    /**
     * Handles <b>board_post_delete</b> events.
     *
     * @param boardPostDeleteEvent event object.
     */
    public void onBoardPostDelete(BoardPostDeleteEvent boardPostDeleteEvent) {
    }

    /**
     * Handles <b>board_post_restore</b> events.
     *
     * @param boardPostEvent event object.
     */
    public void onBoardPostRestore(BoardPostEvent boardPostEvent) {
    }

    /**
     * Handles <b>market_comment_new</b> events.
     *
     * @param marketCommentEvent event object.
     */
    public void onMarketCommentNew(MarketCommentEvent marketCommentEvent) {
    }

    /**
     * Handles <b>market_comment_edit</b> events.
     *
     * @param marketCommentEvent event object.
     */
    public void onMarketCommentEdit(MarketCommentEvent marketCommentEvent) {
    }

    /**
     * Handles <b>market_comment_restore</b> events.
     *
     * @param marketCommentEvent event object.
     */
    public void onMarketCommentRestore(MarketCommentEvent marketCommentEvent) {
    }

    /**
     * Handles <b>market_comment_delete</b> events.
     *
     * @param marketCommentDeleteEvent event object.
     */
    public void onMarketCommentDelete(MarketCommentDeleteEvent marketCommentDeleteEvent) {
    }

    /**
     * Handles <b>market_order_new</b> events.
     *
     * @param marketOrder event object.
     */
    public void onMarketOrderNew(MarketOrder marketOrder) {
    }

    /**
     * Handles <b>market_order_edit</b> events.
     *
     * @param marketOrder event object.
     */
    public void onMarketOrderEdit(MarketOrder marketOrder) {
    }

    /**
     * Handles <b>group_leave</b> events.
     *
     * @param groupLeaveEvent event object.
     */
    public void onGroupLeave(GroupLeaveEvent groupLeaveEvent) {
    }

    /**
     * Handles <b>group_join</b> events.
     *
     * @param groupJoinEvent event object.
     */
    public void onGroupJoin(GroupJoinEvent groupJoinEvent) {
    }

    /**
     * Handles <b>user_block</b> events.
     *
     * @param userBlockEvent event object.
     */
    public void onUserBlock(UserBlockEvent userBlockEvent) {
    }

    /**
     * Handles <b>user_unblock</b> events.
     *
     * @param userUnblockEvent event object.
     */
    public void onUserUnblock(UserUnblockEvent userUnblockEvent) {
    }

    /**
     * Handles <b>group_change_settings</b> events.
     *
     * @param groupChangeSettingsEvent event object.
     */
    public void onGroupChangeSettings(GroupChangeSettingsEvent groupChangeSettingsEvent) {
    }

    /**
     * Handles <b>group_change_photo</b> events.
     *
     * @param groupChangePhotoEvent event object.
     */
    public void onGroupChangePhoto(GroupChangePhotoEvent groupChangePhotoEvent) {
    }

    /**
     * Handles <b>vkpay_transaction</b> events.
     *
     * @param vkpayTransaction event object.
     */
    public void onVkpayTransaction(VkpayTransaction vkpayTransaction) {
    }

    /**
     * Handles <b>app_payload</b> events.
     *
     * @param appPayload event object.
     */
    public void onAppPayload(AppPayload appPayload) {
    }

    /**
     * Handles <b>message_typing_state</b> events.
     *
     * @param messageTypingStateEvent event object.
     */
    public void onMessageTypingState(MessageTypingStateEvent messageTypingStateEvent) {
    }

    /**
     * Handles <b>message_allow</b> events.
     *
     * @param messageAllowEvent event object.
     */
    public void onMessageAllow(MessageAllowEvent messageAllowEvent) {
    }

    /**
     * Handles <b>message_deny</b> events.
     *
     * @param messageDenyEvent event object.
     */
    public void onMessageDeny(MessageDenyEvent messageDenyEvent) {
    }
}
