package api.longpoll.bots;

import api.longpoll.bots.methods.VkBotsMethods;
import api.longpoll.bots.model.events.Update;
import api.longpoll.bots.model.events.boards.BoardPost;
import api.longpoll.bots.model.events.boards.BoardPostDelete;
import api.longpoll.bots.model.events.likes.Like;
import api.longpoll.bots.model.events.market.MarketComment;
import api.longpoll.bots.model.events.market.MarketCommentDelete;
import api.longpoll.bots.model.events.messages.*;
import api.longpoll.bots.model.events.other.AppPayload;
import api.longpoll.bots.model.events.other.GroupChangePhoto;
import api.longpoll.bots.model.events.other.GroupChangeSettings;
import api.longpoll.bots.model.events.other.VkpayTransaction;
import api.longpoll.bots.model.events.photos.PhotoComment;
import api.longpoll.bots.model.events.photos.PhotoCommentDelete;
import api.longpoll.bots.model.events.poll.PollVoteNew;
import api.longpoll.bots.model.events.users.GroupJoin;
import api.longpoll.bots.model.events.users.GroupLeave;
import api.longpoll.bots.model.events.users.UserBlock;
import api.longpoll.bots.model.events.users.UserUnblock;
import api.longpoll.bots.model.events.video.VideoComment;
import api.longpoll.bots.model.events.video.VideoCommentDelete;
import api.longpoll.bots.model.events.wall.comments.WallReply;
import api.longpoll.bots.model.events.wall.comments.WallReplyDelete;
import api.longpoll.bots.model.objects.basic.MarketOrder;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.objects.basic.WallPost;
import api.longpoll.bots.model.objects.media.Audio;
import api.longpoll.bots.model.objects.media.Photo;
import api.longpoll.bots.model.objects.media.Video;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * VK bot.
 */
public abstract class VkBot {
    /**
     * {@link Logger} object.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(VkBot.class);

    /**
     * VK Bots API methods.
     */
    protected VkBotsMethods vk = new VkBotsMethods(this::getAccessToken);

    /**
     * Gets bot access token.
     *
     * @return access token.
     */
    public abstract String getAccessToken();

    /**
     * Handles list of VK updates.
     *
     * @param updates list of VK updates.
     */
    public void handle(List<Update> updates) {
        updates.forEach(update -> {
            Update.Type updateType = update.getType();
            switch (updateType) {
                case MESSAGE_NEW:
                    onMessageNew((MessageNew) update.getObject());
                    break;

                case MESSAGE_REPLY:
                    onMessageReply((Message) update.getObject());
                    break;

                case MESSAGE_EDIT:
                    onMessageEdit((Message) update.getObject());
                    break;

                case MESSAGE_EVENT:
                    onMessageEvent((MessageEvent) update.getObject());
                    break;

                case PHOTO_NEW:
                    onPhotoNew((Photo) update.getObject());
                    break;

                case PHOTO_COMMENT_NEW:
                    onPhotoCommentNew((PhotoComment) update.getObject());
                    break;

                case PHOTO_COMMENT_EDIT:
                    onPhotoCommentEdit((PhotoComment) update.getObject());
                    break;

                case PHOTO_COMMENT_DELETE:
                    onPhotoCommentDelete((PhotoCommentDelete) update.getObject());
                    break;

                case PHOTO_COMMENT_RESTORE:
                    onPhotoCommentRestore((PhotoComment) update.getObject());
                    break;

                case AUDIO_NEW:
                    onAudioNew((Audio) update.getObject());
                    break;

                case VIDEO_NEW:
                    onVideoNew((Video) update.getObject());
                    break;

                case VIDEO_COMMENT_NEW:
                    onVideoCommentNew((VideoComment) update.getObject());
                    break;

                case VIDEO_COMMENT_EDIT:
                    onVideoCommentEdit((VideoComment) update.getObject());
                    break;

                case VIDEO_COMMENT_DELETE:
                    onVideoCommentDelete((VideoCommentDelete) update.getObject());
                    break;

                case VIDEO_COMMENT_RESTORE:
                    onVideoCommentRestore((VideoComment) update.getObject());
                    break;

                case WALL_POST_NEW:
                    onWallPostNew((WallPost) update.getObject());
                    break;

                case WALL_REPOST:
                    onWallRepost((WallPost) update.getObject());
                    break;

                case LIKE_ADD:
                    onLikeAdd((Like) update.getObject());
                    break;

                case LIKE_REMOVE:
                    onLikeRemove((Like) update.getObject());
                    break;

                case WALL_REPLY_NEW:
                    onWallReplyNew((WallReply) update.getObject());
                    break;

                case WALL_REPLY_EDIT:
                    onWallReplyEdit((WallReply) update.getObject());
                    break;

                case WALL_REPLY_DELETE:
                    onWallReplyDelete((WallReplyDelete) update.getObject());
                    break;

                case WALL_REPLY_RESTORE:
                    onWallReplyRestore((WallReply) update.getObject());
                    break;

                case BOARD_POST_NEW:
                    onBoardPostNew((BoardPost) update.getObject());
                    break;

                case BOARD_POST_EDIT:
                    onBoardPostEdit((BoardPost) update.getObject());
                    break;

                case BOARD_POST_DELETE:
                    onBoardPostDelete((BoardPostDelete) update.getObject());
                    break;

                case BOARD_POST_RESTORE:
                    onBoardPostRestore((BoardPost) update.getObject());
                    break;

                case MARKET_COMMENT_NEW:
                    onMarketCommentNew((MarketComment) update.getObject());
                    break;

                case MARKET_COMMENT_EDIT:
                    onMarketCommentEdit((MarketComment) update.getObject());
                    break;

                case MARKET_COMMENT_RESTORE:
                    onMarketCommentRestore((MarketComment) update.getObject());
                    break;

                case MARKET_COMMENT_DELETE:
                    onMarketCommentDelete((MarketCommentDelete) update.getObject());
                    break;

                case MARKET_ORDER_NEW:
                    onMarketOrderNew((MarketOrder) update.getObject());
                    break;

                case MARKET_ORDER_EDIT:
                    onMarketOrderEdit((MarketOrder) update.getObject());
                    break;

                case GROUP_LEAVE:
                    onGroupLeave((GroupLeave) update.getObject());
                    break;

                case GROUP_JOIN:
                    onGroupJoin((GroupJoin) update.getObject());
                    break;

                case USER_BLOCK:
                    onUserBlock((UserBlock) update.getObject());
                    break;

                case USER_UNBLOCK:
                    onUserUnblock((UserUnblock) update.getObject());
                    break;

                case GROUP_CHANGE_SETTINGS:
                    onGroupChangeSettings((GroupChangeSettings) update.getObject());
                    break;

                case GROUP_CHANGE_PHOTO:
                    onGroupChangePhoto((GroupChangePhoto) update.getObject());
                    break;

                case VKPAY_TRANSACTION:
                    onVkpayTransaction((VkpayTransaction) update.getObject());
                    break;

                case APP_PAYLOAD:
                    onAppPayload((AppPayload) update.getObject());
                    break;

                case MESSAGE_TYPING_STATE:
                    onMessageTypingState((MessageTypingState) update.getObject());
                    break;

                case MESSAGE_ALLOW:
                    onMessageAllow((MessageAllow) update.getObject());
                    break;

                case MESSAGE_DENY:
                    onMessageDeny((MessageDeny) update.getObject());
                    break;

                case POLL_VOTE_NEW:
                    onPollVoteNew((PollVoteNew) update.getObject());
                    break;

                default:
                    LOGGER.warn("No update handler found update updateType: {}", updateType);
                    break;
            }
        });
    }

    /**
     * Handles <b>message_new</b> events.
     *
     * @param messageNew event object.
     */
    public void onMessageNew(MessageNew messageNew) {
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
     * @param photoComment event object.
     */
    public void onPhotoCommentNew(PhotoComment photoComment) {
    }

    /**
     * Handles <b>photo_comment_edit</b> events.
     *
     * @param photoComment event object.
     */
    public void onPhotoCommentEdit(PhotoComment photoComment) {
    }

    /**
     * Handles <b>photo_comment_delete</b> events.
     *
     * @param photoCommentDelete event object.
     */
    public void onPhotoCommentDelete(PhotoCommentDelete photoCommentDelete) {
    }

    /**
     * Handles <b>photo_comment_restore</b> events.
     *
     * @param photoComment event object.
     */
    public void onPhotoCommentRestore(PhotoComment photoComment) {
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
     * @param videoComment event object.
     */
    public void onVideoCommentNew(VideoComment videoComment) {
    }

    /**
     * Handles <b>video_comment_edit</b> events.
     *
     * @param videoComment event object.
     */
    public void onVideoCommentEdit(VideoComment videoComment) {
    }

    /**
     * Handles <b>video_comment_delete</b> events.
     *
     * @param videoCommentDelete event object.
     */
    public void onVideoCommentDelete(VideoCommentDelete videoCommentDelete) {
    }

    /**
     * Handles <b>video_comment_restore</b> events.
     *
     * @param videoComment event object.
     */
    public void onVideoCommentRestore(VideoComment videoComment) {
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
     * @param like event object.
     */
    public void onLikeAdd(Like like) {
    }

    /**
     * Handles <b>like_remove</b> events.
     *
     * @param like event object.
     */
    public void onLikeRemove(Like like) {
    }

    /**
     * Handles <b>wall_reply_new</b> events.
     *
     * @param wallReply event object.
     */
    public void onWallReplyNew(WallReply wallReply) {
    }

    /**
     * Handles <b>wall_reply_edit</b> events.
     *
     * @param wallReply event object.
     */
    public void onWallReplyEdit(WallReply wallReply) {
    }

    /**
     * Handles <b>wall_reply_delete</b> events.
     *
     * @param wallReplyDelete event object.
     */
    public void onWallReplyDelete(WallReplyDelete wallReplyDelete) {
    }

    /**
     * Handles <b>wall_reply_restore</b> events.
     *
     * @param wallReply event object.
     */
    public void onWallReplyRestore(WallReply wallReply) {
    }

    /**
     * Handles <b>board_post_new</b> events.
     *
     * @param boardPost event object.
     */
    public void onBoardPostNew(BoardPost boardPost) {
    }

    /**
     * Handles <b>board_post_edit</b> events.
     *
     * @param boardPost event object.
     */
    public void onBoardPostEdit(BoardPost boardPost) {
    }

    /**
     * Handles <b>board_post_delete</b> events.
     *
     * @param boardPostDelete event object.
     */
    public void onBoardPostDelete(BoardPostDelete boardPostDelete) {
    }

    /**
     * Handles <b>board_post_restore</b> events.
     *
     * @param boardPost event object.
     */
    public void onBoardPostRestore(BoardPost boardPost) {
    }

    /**
     * Handles <b>market_comment_new</b> events.
     *
     * @param marketComment event object.
     */
    public void onMarketCommentNew(MarketComment marketComment) {
    }

    /**
     * Handles <b>market_comment_edit</b> events.
     *
     * @param marketComment event object.
     */
    public void onMarketCommentEdit(MarketComment marketComment) {
    }

    /**
     * Handles <b>market_comment_restore</b> events.
     *
     * @param marketComment event object.
     */
    public void onMarketCommentRestore(MarketComment marketComment) {
    }

    /**
     * Handles <b>market_comment_delete</b> events.
     *
     * @param marketCommentDelete event object.
     */
    public void onMarketCommentDelete(MarketCommentDelete marketCommentDelete) {
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
     * @param groupLeave event object.
     */
    public void onGroupLeave(GroupLeave groupLeave) {
    }

    /**
     * Handles <b>group_join</b> events.
     *
     * @param groupJoin event object.
     */
    public void onGroupJoin(GroupJoin groupJoin) {
    }

    /**
     * Handles <b>user_block</b> events.
     *
     * @param userBlock event object.
     */
    public void onUserBlock(UserBlock userBlock) {
    }

    /**
     * Handles <b>user_unblock</b> events.
     *
     * @param userUnblock event object.
     */
    public void onUserUnblock(UserUnblock userUnblock) {
    }

    /**
     * Handles <b>group_change_settings</b> events.
     *
     * @param groupChangeSettings event object.
     */
    public void onGroupChangeSettings(GroupChangeSettings groupChangeSettings) {
    }

    /**
     * Handles <b>group_change_photo</b> events.
     *
     * @param groupChangePhoto event object.
     */
    public void onGroupChangePhoto(GroupChangePhoto groupChangePhoto) {
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
     * @param messageTypingState event object.
     */
    public void onMessageTypingState(MessageTypingState messageTypingState) {
    }

    /**
     * Handles <b>message_allow</b> events.
     *
     * @param messageAllow event object.
     */
    public void onMessageAllow(MessageAllow messageAllow) {
    }

    /**
     * Handles <b>message_deny</b> events.
     *
     * @param messageDeny event object.
     */
    public void onMessageDeny(MessageDeny messageDeny) {
    }

    /**
     * Handles <b>poll_vote_new</b> events.
     *
     * @param pollVoteNew event object.
     */
    public void onPollVoteNew(PollVoteNew pollVoteNew) {
    }
}
