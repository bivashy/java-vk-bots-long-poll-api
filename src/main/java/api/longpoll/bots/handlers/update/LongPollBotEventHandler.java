package api.longpoll.bots.handlers.update;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.model.events.VkEvent;
import api.longpoll.bots.model.events.EventType;
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
    private LongPollBot bot;

    public LongPollBotEventHandler(LongPollBot bot) {
        this.bot = bot;
    }

    @Override
    public void handle(List<VkEvent> events) {
        for (VkEvent event : events) {
            EventType eventType = event.getType();

            switch (eventType) {
                case MESSAGE_NEW:
                    bot.onMessageNew((MessageNewEvent) event.getObject());
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
                    bot.onPhotoCommentNew((PhotoCommentEvent) event.getObject());
                    break;

                case PHOTO_COMMENT_EDIT:
                    bot.onPhotoCommentEdit((PhotoCommentEvent) event.getObject());
                    break;

                case PHOTO_COMMENT_DELETE:
                    bot.onPhotoCommentDelete((PhotoCommentDeleteEvent) event.getObject());
                    break;

                case PHOTO_COMMENT_RESTORE:
                    bot.onPhotoCommentRestore((PhotoCommentEvent) event.getObject());
                    break;

                case AUDIO_NEW:
                    bot.onAudioNew((Audio) event.getObject());
                    break;

                case VIDEO_NEW:
                    bot.onVideoNew((Video) event.getObject());
                    break;

                case VIDEO_COMMENT_NEW:
                    bot.onVideoCommentNew((VideoCommentEvent) event.getObject());
                    break;

                case VIDEO_COMMENT_EDIT:
                    bot.onVideoCommentEdit((VideoCommentEvent) event.getObject());
                    break;

                case VIDEO_COMMENT_DELETE:
                    bot.onVideoCommentDelete((VideoCommentDeleteEvent) event.getObject());
                    break;

                case VIDEO_COMMENT_RESTORE:
                    bot.onVideoCommentRestore((VideoCommentEvent) event.getObject());
                    break;

                case WALL_POST_NEW:
                    bot.onWallPostNew((WallPost) event.getObject());
                    break;

                case WALL_REPOST:
                    bot.onWallRepost((WallPost) event.getObject());
                    break;

                case LIKE_ADD:
                    bot.onLikeAdd((LikeEvent) event.getObject());
                    break;

                case LIKE_REMOVE:
                    bot.onLikeRemove((LikeEvent) event.getObject());
                    break;

                case WALL_REPLY_NEW:
                    bot.onWallReplyNew((WallReplyEvent) event.getObject());
                    break;

                case WALL_REPLY_EDIT:
                    bot.onWallReplyEdit((WallReplyEvent) event.getObject());
                    break;

                case WALL_REPLY_DELETE:
                    bot.onWallReplyDelete((WallReplyDeleteEvent) event.getObject());
                    break;

                case WALL_REPLY_RESTORE:
                    bot.onWallReplyRestore((WallReplyEvent) event.getObject());
                    break;

                case BOARD_POST_NEW:
                    bot.onBoardPostNew((BoardPostEvent) event.getObject());
                    break;

                case BOARD_POST_EDIT:
                    bot.onBoardPostEdit((BoardPostEvent) event.getObject());
                    break;

                case BOARD_POST_DELETE:
                    bot.onBoardPostDelete((BoardPostDeleteEvent) event.getObject());
                    break;

                case BOARD_POST_RESTORE:
                    bot.onBoardPostRestore((BoardPostEvent) event.getObject());
                    break;

                case MARKET_COMMENT_NEW:
                    bot.onMarketCommentNew((MarketCommentEvent) event.getObject());
                    break;

                case MARKET_COMMENT_EDIT:
                    bot.onMarketCommentEdit((MarketCommentEvent) event.getObject());
                    break;

                case MARKET_COMMENT_RESTORE:
                    bot.onMarketCommentRestore((MarketCommentEvent) event.getObject());
                    break;

                case MARKET_COMMENT_DELETE:
                    bot.onMarketCommentDelete((MarketCommentDeleteEvent) event.getObject());
                    break;

                case MARKET_ORDER_NEW:
                    bot.onMarketOrderNew((MarketOrder) event.getObject());
                    break;

                case MARKET_ORDER_EDIT:
                    bot.onMarketOrderEdit((MarketOrder) event.getObject());
                    break;

                case GROUP_LEAVE:
                    bot.onGroupLeave((GroupLeaveEvent) event.getObject());
                    break;

                case GROUP_JOIN:
                    bot.onGroupJoin((GroupJoinEvent) event.getObject());
                    break;

                case USER_BLOCK:
                    bot.onUserBlock((UserBlockEvent) event.getObject());
                    break;

                case USER_UNBLOCK:
                    bot.onUserUnblock((UserUnblockEvent) event.getObject());
                    break;

                case GROUP_CHANGE_SETTINGS:
                    bot.onGroupChangeSettings((GroupChangeSettingsEvent) event.getObject());
                    break;

                case GROUP_CHANGE_PHOTO:
                    bot.onGroupChangePhoto((GroupChangePhotoEvent) event.getObject());
                    break;

                case VKPAY_TRANSACTION:
                    bot.onVkpayTransaction((VkpayTransaction) event.getObject());
                    break;

                case APP_PAYLOAD:
                    bot.onAppPayload((AppPayload) event.getObject());
                    break;

                case MESSAGE_TYPING_STATE:
                    bot.onMessageTypingState((MessageTypingStateEvent) event.getObject());
                    break;

                case MESSAGE_ALLOW:
                    bot.onMessageAllow((MessageAllowEvent) event.getObject());
                    break;

                case MESSAGE_DENY:
                    bot.onMessageDeny((MessageDenyEvent) event.getObject());
                    break;

                default:
                    log.warn("No event handler found event type: {}", eventType);
                    break;
            }
        }
    }
}
