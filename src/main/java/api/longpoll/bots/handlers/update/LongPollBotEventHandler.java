package api.longpoll.bots.handlers.update;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.model.events.VkEvent;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.events.boards.BoardPost;
import api.longpoll.bots.model.events.boards.BoardPostDelete;
import api.longpoll.bots.model.events.likes.Like;
import api.longpoll.bots.model.events.market.MarketCommentDelete;
import api.longpoll.bots.model.events.market.MarketComment;
import api.longpoll.bots.model.events.messages.MessageAllow;
import api.longpoll.bots.model.events.messages.MessageDeny;
import api.longpoll.bots.model.events.messages.MessageEvent;
import api.longpoll.bots.model.events.messages.MessageNew;
import api.longpoll.bots.model.events.messages.MessageTypingState;
import api.longpoll.bots.model.events.other.AppPayload;
import api.longpoll.bots.model.events.other.GroupChangePhoto;
import api.longpoll.bots.model.events.other.GroupChangeSettings;
import api.longpoll.bots.model.events.other.VkpayTransaction;
import api.longpoll.bots.model.events.photos.PhotoComment;
import api.longpoll.bots.model.events.photos.PhotoCommentDelete;
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
 * Handles VK updates using Long Poll Bot.
 */
public class LongPollBotEventHandler implements VkEventHandler {
    /**
     * Logger object.
     */
    private static final Logger log = LoggerFactory.getLogger(LongPollBotEventHandler.class);

    /**
     * Bot which processes updates.
     */
    private final LongPollBot bot;

    public LongPollBotEventHandler(LongPollBot bot) {
        this.bot = bot;
    }

    @Override
    public void handle(List<VkEvent> events) {
        for (VkEvent event : events) {
            EventType eventType = event.getType();

            switch (eventType) {
                case MESSAGE_NEW:
                    bot.onMessageNew((MessageNew) event.getObject());
                    break;

                case MESSAGE_REPLY:
                    bot.onMessageReply((Message) event.getObject());
                    break;

                case MESSAGE_EDIT:
                    bot.onMessageEdit((Message) event.getObject());
                    break;

                case MESSAGE_EVENT:
                    bot.onMessageEvent((MessageEvent) event.getObject());
                    break;

                case PHOTO_NEW:
                    bot.onPhotoNew((Photo) event.getObject());
                    break;

                case PHOTO_COMMENT_NEW:
                    bot.onPhotoCommentNew((PhotoComment) event.getObject());
                    break;

                case PHOTO_COMMENT_EDIT:
                    bot.onPhotoCommentEdit((PhotoComment) event.getObject());
                    break;

                case PHOTO_COMMENT_DELETE:
                    bot.onPhotoCommentDelete((PhotoCommentDelete) event.getObject());
                    break;

                case PHOTO_COMMENT_RESTORE:
                    bot.onPhotoCommentRestore((PhotoComment) event.getObject());
                    break;

                case AUDIO_NEW:
                    bot.onAudioNew((Audio) event.getObject());
                    break;

                case VIDEO_NEW:
                    bot.onVideoNew((Video) event.getObject());
                    break;

                case VIDEO_COMMENT_NEW:
                    bot.onVideoCommentNew((VideoComment) event.getObject());
                    break;

                case VIDEO_COMMENT_EDIT:
                    bot.onVideoCommentEdit((VideoComment) event.getObject());
                    break;

                case VIDEO_COMMENT_DELETE:
                    bot.onVideoCommentDelete((VideoCommentDelete) event.getObject());
                    break;

                case VIDEO_COMMENT_RESTORE:
                    bot.onVideoCommentRestore((VideoComment) event.getObject());
                    break;

                case WALL_POST_NEW:
                    bot.onWallPostNew((WallPost) event.getObject());
                    break;

                case WALL_REPOST:
                    bot.onWallRepost((WallPost) event.getObject());
                    break;

                case LIKE_ADD:
                    bot.onLikeAdd((Like) event.getObject());
                    break;

                case LIKE_REMOVE:
                    bot.onLikeRemove((Like) event.getObject());
                    break;

                case WALL_REPLY_NEW:
                    bot.onWallReplyNew((WallReply) event.getObject());
                    break;

                case WALL_REPLY_EDIT:
                    bot.onWallReplyEdit((WallReply) event.getObject());
                    break;

                case WALL_REPLY_DELETE:
                    bot.onWallReplyDelete((WallReplyDelete) event.getObject());
                    break;

                case WALL_REPLY_RESTORE:
                    bot.onWallReplyRestore((WallReply) event.getObject());
                    break;

                case BOARD_POST_NEW:
                    bot.onBoardPostNew((BoardPost) event.getObject());
                    break;

                case BOARD_POST_EDIT:
                    bot.onBoardPostEdit((BoardPost) event.getObject());
                    break;

                case BOARD_POST_DELETE:
                    bot.onBoardPostDelete((BoardPostDelete) event.getObject());
                    break;

                case BOARD_POST_RESTORE:
                    bot.onBoardPostRestore((BoardPost) event.getObject());
                    break;

                case MARKET_COMMENT_NEW:
                    bot.onMarketCommentNew((MarketComment) event.getObject());
                    break;

                case MARKET_COMMENT_EDIT:
                    bot.onMarketCommentEdit((MarketComment) event.getObject());
                    break;

                case MARKET_COMMENT_RESTORE:
                    bot.onMarketCommentRestore((MarketComment) event.getObject());
                    break;

                case MARKET_COMMENT_DELETE:
                    bot.onMarketCommentDelete((MarketCommentDelete) event.getObject());
                    break;

                case MARKET_ORDER_NEW:
                    bot.onMarketOrderNew((MarketOrder) event.getObject());
                    break;

                case MARKET_ORDER_EDIT:
                    bot.onMarketOrderEdit((MarketOrder) event.getObject());
                    break;

                case GROUP_LEAVE:
                    bot.onGroupLeave((GroupLeave) event.getObject());
                    break;

                case GROUP_JOIN:
                    bot.onGroupJoin((GroupJoin) event.getObject());
                    break;

                case USER_BLOCK:
                    bot.onUserBlock((UserBlock) event.getObject());
                    break;

                case USER_UNBLOCK:
                    bot.onUserUnblock((UserUnblock) event.getObject());
                    break;

                case GROUP_CHANGE_SETTINGS:
                    bot.onGroupChangeSettings((GroupChangeSettings) event.getObject());
                    break;

                case GROUP_CHANGE_PHOTO:
                    bot.onGroupChangePhoto((GroupChangePhoto) event.getObject());
                    break;

                case VKPAY_TRANSACTION:
                    bot.onVkpayTransaction((VkpayTransaction) event.getObject());
                    break;

                case APP_PAYLOAD:
                    bot.onAppPayload((AppPayload) event.getObject());
                    break;

                case MESSAGE_TYPING_STATE:
                    bot.onMessageTypingState((MessageTypingState) event.getObject());
                    break;

                case MESSAGE_ALLOW:
                    bot.onMessageAllow((MessageAllow) event.getObject());
                    break;

                case MESSAGE_DENY:
                    bot.onMessageDeny((MessageDeny) event.getObject());
                    break;

                default:
                    log.warn("No event handler found event type: {}", eventType);
                    break;
            }
        }
    }
}
