package api.longpoll.bots.handlers.update;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.events.boards.BoardPostDeleteEvent;
import api.longpoll.bots.model.events.boards.BoardPostEvent;
import api.longpoll.bots.model.events.likes.LikeEvent;
import api.longpoll.bots.model.events.market.MarketCommentDeleteEvent;
import api.longpoll.bots.model.events.market.MarketCommentEvent;
import api.longpoll.bots.model.events.messages.*;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Handles VK updates using Long Poll Bot.
 */
public class LongPollBotUpdateHandler implements UpdateHandler {
    private static final Logger log = LoggerFactory.getLogger(LongPollBotUpdateHandler.class);
    private Map<EventType, Consumer<EventObject>> handlers = new HashMap<>();

    @Override
    public void handleUpdates(List<Event> updates) {
        for (Event update : updates) {
            EventType eventType = update.getType();
            if (handlers.containsKey(eventType)) {
                handlers.get(eventType).accept(update.getObject());
            } else {
                log.warn("No update handler found event type: {}", eventType);
            }
        }
    }

    public LongPollBotUpdateHandler(LongPollBot bot) {
        handlers.put(EventType.MESSAGE_NEW, eventObject -> bot.onMessageNew((MessageNewEvent) eventObject));
        handlers.put(EventType.MESSAGE_REPLY, eventObject -> bot.onMessageReply((Message) eventObject));
        handlers.put(EventType.MESSAGE_EDIT, eventObject -> bot.onMessageEdit((Message) eventObject));
        handlers.put(EventType.MESSAGE_EVENT, eventObject -> bot.onMessageEvent((MessageEvent) eventObject));
        handlers.put(EventType.PHOTO_NEW, eventObject -> bot.onPhotoNew((Photo) eventObject));
        handlers.put(EventType.PHOTO_COMMENT_NEW, eventObject -> bot.onPhotoCommentNew((PhotoCommentEvent) eventObject));
        handlers.put(EventType.PHOTO_COMMENT_EDIT, eventObject -> bot.onPhotoCommentEdit((PhotoCommentEvent) eventObject));
        handlers.put(EventType.PHOTO_COMMENT_DELETE, eventObject -> bot.onPhotoCommentDelete((PhotoCommentDeleteEvent) eventObject));
        handlers.put(EventType.PHOTO_COMMENT_RESTORE, eventObject -> bot.onPhotoCommentRestore((PhotoCommentEvent) eventObject));
        handlers.put(EventType.AUDIO_NEW, eventObject -> bot.onAudioNew((Audio) eventObject));
        handlers.put(EventType.VIDEO_NEW, eventObject -> bot.onVideoNew((Video) eventObject));
        handlers.put(EventType.VIDEO_COMMENT_NEW, eventObject -> bot.onVideoCommentNew((VideoCommentEvent) eventObject));
        handlers.put(EventType.VIDEO_COMMENT_EDIT, eventObject -> bot.onVideoCommentEdit((VideoCommentEvent) eventObject));
        handlers.put(EventType.VIDEO_COMMENT_DELETE, eventObject -> bot.onVideoCommentDelete((VideoCommentDeleteEvent) eventObject));
        handlers.put(EventType.VIDEO_COMMENT_RESTORE, eventObject -> bot.onVideoCommentRestore((VideoCommentEvent) eventObject));
        handlers.put(EventType.WALL_POST_NEW, eventObject -> bot.onWallPostNew((WallPost) eventObject));
        handlers.put(EventType.WALL_REPOST, eventObject -> bot.onWallRepost((WallPost) eventObject));
        handlers.put(EventType.LIKE_ADD, eventObject -> bot.onLikeAdd((LikeEvent) eventObject));
        handlers.put(EventType.LIKE_REMOVE, eventObject -> bot.onLikeRemove((LikeEvent) eventObject));
        handlers.put(EventType.WALL_REPLY_NEW, eventObject -> bot.onWallReplyNew((WallReplyEvent) eventObject));
        handlers.put(EventType.WALL_REPLY_EDIT, eventObject -> bot.onWallReplyEdit((WallReplyEvent) eventObject));
        handlers.put(EventType.WALL_REPLY_DELETE, eventObject -> bot.onWallReplyDelete((WallReplyDeleteEvent) eventObject));
        handlers.put(EventType.WALL_REPLY_RESTORE, eventObject -> bot.onWallReplyRestore((WallReplyEvent) eventObject));
        handlers.put(EventType.BOARD_POST_NEW, eventObject -> bot.onBoardPostNew((BoardPostEvent) eventObject));
        handlers.put(EventType.BOARD_POST_EDIT, eventObject -> bot.onBoardPostEdit((BoardPostEvent) eventObject));
        handlers.put(EventType.BOARD_POST_DELETE, eventObject -> bot.onBoardPostDelete((BoardPostDeleteEvent) eventObject));
        handlers.put(EventType.BOARD_POST_RESTORE, eventObject -> bot.onBoardPostRestore((BoardPostEvent) eventObject));
        handlers.put(EventType.MARKET_COMMENT_NEW, eventObject -> bot.onMarketCommentNew((MarketCommentEvent) eventObject));
        handlers.put(EventType.MARKET_COMMENT_EDIT, eventObject -> bot.onMarketCommentEdit((MarketCommentEvent) eventObject));
        handlers.put(EventType.MARKET_COMMENT_RESTORE, eventObject -> bot.onMarketCommentRestore((MarketCommentEvent) eventObject));
        handlers.put(EventType.MARKET_COMMENT_DELETE, eventObject -> bot.onMarketCommentDelete((MarketCommentDeleteEvent) eventObject));
        handlers.put(EventType.MARKET_ORDER_NEW, eventObject -> bot.onMarketOrderNew((MarketOrder) eventObject));
        handlers.put(EventType.MARKET_ORDER_EDIT, eventObject -> bot.onMarketOrderEdit((MarketOrder) eventObject));
        handlers.put(EventType.GROUP_LEAVE, eventObject -> bot.onGroupLeave((GroupLeaveEvent) eventObject));
        handlers.put(EventType.GROUP_JOIN, eventObject -> bot.onGroupJoin((GroupJoinEvent) eventObject));
        handlers.put(EventType.USER_BLOCK, eventObject -> bot.onUserBlock((UserBlockEvent) eventObject));
        handlers.put(EventType.USER_UNBLOCK, eventObject -> bot.onUserUnblock((UserUnblockEvent) eventObject));
        handlers.put(EventType.GROUP_CHANGE_SETTINGS, eventObject -> bot.onGroupChangeSettings((GroupChangeSettingsEvent) eventObject));
        handlers.put(EventType.GROUP_CHANGE_PHOTO, eventObject -> bot.onGroupChangePhoto((GroupChangePhotoEvent) eventObject));
        handlers.put(EventType.VKPAY_TRANSACTION, eventObject -> bot.onVkpayTransaction((VkpayTransaction) eventObject));
        handlers.put(EventType.APP_PAYLOAD, eventObject -> bot.onAppPayload((AppPayload) eventObject));
        handlers.put(EventType.MESSAGE_TYPING_STATE, eventObject -> bot.onMessageTypingState((MessageTypingStateEvent) eventObject));
        handlers.put(EventType.MESSAGE_ALLOW, eventObject -> bot.onMessageAllow((MessageAllowEvent) eventObject));
        handlers.put(EventType.MESSAGE_DENY, eventObject -> bot.onMessageDeny((MessageDenyEvent) eventObject));
    }
}
