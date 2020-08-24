package api.longpoll.bots;

import api.longpoll.bots.constants.EventTypes;
import api.longpoll.bots.exceptions.ApiHttpException;
import api.longpoll.bots.exceptions.handlers.ApiHttpExceptionHandler;
import api.longpoll.bots.model.events.likes.LikeEvent;
import api.longpoll.bots.model.objects.media.Audio;
import api.longpoll.bots.model.events.boards.BoardPostDeleteEvent;
import api.longpoll.bots.model.events.boards.BoardPostEvent;
import api.longpoll.bots.model.events.market.MarketCommentDeleteEvent;
import api.longpoll.bots.model.events.market.MarketCommentEvent;
import api.longpoll.bots.model.objects.basic.MarketOrder;
import api.longpoll.bots.model.events.other.AppPayload;
import api.longpoll.bots.model.events.other.GroupChangePhotoEvent;
import api.longpoll.bots.model.events.other.GroupChangeSettingsEvent;
import api.longpoll.bots.model.events.other.VkpayTransaction;
import api.longpoll.bots.model.objects.media.Photo;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.events.messages.MessageEvent;
import api.longpoll.bots.model.events.photos.PhotoCommentDeleteEvent;
import api.longpoll.bots.model.events.photos.PhotoCommentEvent;
import api.longpoll.bots.model.events.UnimplementedEventObject;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.users.GroupJoinEvent;
import api.longpoll.bots.model.events.users.GroupLeaveEvent;
import api.longpoll.bots.model.events.users.UserBlockEvent;
import api.longpoll.bots.model.events.users.UserUnblockEvent;
import api.longpoll.bots.model.objects.media.Video;
import api.longpoll.bots.model.events.video.VideoCommentDeleteEvent;
import api.longpoll.bots.model.events.video.VideoCommentEvent;
import api.longpoll.bots.model.objects.basic.WallPost;
import api.longpoll.bots.model.events.wall.comments.WallReplyDeleteEvent;
import api.longpoll.bots.model.events.wall.comments.WallReplyEvent;
import api.longpoll.bots.server.Server;
import api.longpoll.bots.server.impl.LongPollServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class BotsLongPoll implements Runnable {
	private static final Logger log = LoggerFactory.getLogger(BotsLongPoll.class);
	private LongPollBot bot;
	private AtomicBoolean running = new AtomicBoolean(true);
	private ApiHttpExceptionHandler apiHttpExceptionHandler = e -> log.error("Error while bot running.", e);

	public BotsLongPoll(LongPollBot bot) {
		this.bot = bot;
	}

	@Override
	public void run() {
		try {
			log.debug("Starting bot with group_id = {}.", bot.getGroupId());
			Server server = new LongPollServer(bot);
			while (running.get()) {
				processUpdates(server.getUpdates());
			}
		} catch (ApiHttpException e) {
			apiHttpExceptionHandler.handle(e);
		}
	}

	private void processUpdates(List<Event> events) {
		events.forEach(update -> {
			switch (update.getType()) {
				case EventTypes.MESSAGE_NEW:
					bot.onMessageNew((MessageEvent) update.getObject());
					break;

				case EventTypes.MESSAGE_REPLY:
					bot.onMessageReply((Message) update.getObject());
					break;

				case EventTypes.MESSAGE_EDIT:
					bot.onMessageEdit((Message) update.getObject());
					break;

				case EventTypes.PHOTO_NEW:
					bot.onPhotoNew((Photo) update.getObject());
					break;

				case EventTypes.PHOTO_COMMENT_NEW:
					bot.onPhotoCommentNew((PhotoCommentEvent) update.getObject());
					break;

				case EventTypes.PHOTO_COMMENT_EDIT:
					bot.onPhotoCommentEdit((PhotoCommentEvent) update.getObject());
					break;

				case EventTypes.PHOTO_COMMENT_DELETE:
					bot.onPhotoCommentDelete((PhotoCommentDeleteEvent) update.getObject());
					break;

				case EventTypes.PHOTO_COMMENT_RESTORE:
					bot.onPhotoCommentRestore((PhotoCommentEvent) update.getObject());
					break;

				case EventTypes.AUDIO_NEW:
					bot.onAudioNew((Audio) update.getObject());
					break;

				case EventTypes.VIDEO_NEW:
					bot.onVideoNew((Video) update.getObject());
					break;

				case EventTypes.VIDEO_COMMENT_NEW:
					bot.onVideoCommentNew((VideoCommentEvent) update.getObject());
					break;

				case EventTypes.VIDEO_COMMENT_EDIT:
					bot.onVideoCommentEdit((VideoCommentEvent) update.getObject());
					break;

				case EventTypes.VIDEO_COMMENT_DELETE:
					bot.onVideoCommentDelete((VideoCommentDeleteEvent) update.getObject());
					break;

				case EventTypes.VIDEO_COMMENT_RESTORE:
					bot.onVideoCommentRestore((VideoCommentEvent) update.getObject());
					break;

				case EventTypes.WALL_POST_NEW:
					bot.onWallPostNew((WallPost) update.getObject());
					break;

				case EventTypes.WALL_REPOST:
					bot.onWallRepost((WallPost) update.getObject());
					break;

				case EventTypes.LIKE_ADD:
					bot.onLikeAdd((LikeEvent) update.getObject());
					break;

				case EventTypes.LIKE_REMOVE:
					bot.onLikeRemove((LikeEvent) update.getObject());
					break;

				case EventTypes.WALL_REPLY_NEW:
					bot.onWallReplyNew((WallReplyEvent) update.getObject());
					break;

				case EventTypes.WALL_REPLY_EDIT:
					bot.onWallReplyEdit((WallReplyEvent) update.getObject());
					break;

				case EventTypes.WALL_REPLY_DELETE:
					bot.onWallReplyDelete((WallReplyDeleteEvent) update.getObject());
					break;

				case EventTypes.WALL_REPLY_RESTORE:
					bot.onWallReplyRestore((WallReplyEvent) update.getObject());
					break;

				case EventTypes.BOARD_POST_NEW:
					bot.onBoardPostNew((BoardPostEvent) update.getObject());
					break;

				case EventTypes.BOARD_POST_EDIT:
					bot.onBoardPostEdit((BoardPostEvent) update.getObject());
					break;

				case EventTypes.BOARD_POST_DELETE:
					bot.onBoardPostDelete((BoardPostDeleteEvent) update.getObject());
					break;

				case EventTypes.BOARD_POST_RESTORE:
					bot.onBoardPostRestore((BoardPostEvent) update.getObject());
					break;

				case EventTypes.MARKET_COMMENT_NEW:
					bot.onMarketCommentNew((MarketCommentEvent) update.getObject());
					break;

				case EventTypes.MARKET_COMMENT_EDIT:
					bot.onMarketCommentEdit((MarketCommentEvent) update.getObject());
					break;

				case EventTypes.MARKET_COMMENT_RESTORE:
					bot.onMarketCommentRestore((MarketCommentEvent) update.getObject());
					break;

				case EventTypes.MARKET_COMMENT_DELETE:
					bot.onMarketCommentDelete((MarketCommentDeleteEvent) update.getObject());
					break;

				case EventTypes.MARKET_ORDER_NEW:
					bot.onMarketOrderNew((MarketOrder) update.getObject());
					break;

				case EventTypes.MARKET_ORDER_EDIT:
					bot.onMarketOrderEdit((MarketOrder) update.getObject());
					break;

				case EventTypes.GROUP_LEAVE:
					bot.onGroupLeave((GroupLeaveEvent) update.getObject());
					break;

				case EventTypes.GROUP_JOIN:
					bot.onGroupJoin((GroupJoinEvent) update.getObject());
					break;

				case EventTypes.USER_BLOCK:
					bot.onUserBlock((UserBlockEvent) update.getObject());
					break;

				case EventTypes.USER_UNBLOCK:
					bot.onUserUnblock((UserUnblockEvent) update.getObject());
					break;

				case EventTypes.GROUP_CHANGE_SETTINGS:
					bot.onGroupChangeSettings((GroupChangeSettingsEvent) update.getObject());
					break;

				case EventTypes.GROUP_CHANGE_PHOTO:
					bot.onGroupChangePhoto((GroupChangePhotoEvent) update.getObject());
					break;

				case EventTypes.VKPAY_TRANSACTION:
					bot.onVkpayTransaction((VkpayTransaction) update.getObject());
					break;

				case EventTypes.APP_PAYLOAD:
					bot.onAppPayload((AppPayload) update.getObject());
					break;

				default:
					bot.onUnimplementedUpdate((UnimplementedEventObject) update.getObject());
					break;
			}
		});
	}

	public boolean isRunning() {
		return running.get();
	}

	public void safeStop() {
		this.running.set(false);
	}

	public BotsLongPoll setApiHttpExceptionHandler(ApiHttpExceptionHandler apiHttpExceptionHandler) {
		this.apiHttpExceptionHandler = apiHttpExceptionHandler;
		return this;
	}
}
