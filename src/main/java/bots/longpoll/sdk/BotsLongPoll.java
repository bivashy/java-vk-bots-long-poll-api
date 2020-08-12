package bots.longpoll.sdk;

import bots.longpoll.sdk.constants.UpdateTypes;
import bots.longpoll.sdk.exceptions.ApiHttpException;
import bots.longpoll.sdk.exceptions.handlers.ApiHttpExceptionHandler;
import bots.longpoll.sdk.model.likes.LikeUpdate;
import bots.longpoll.sdk.model.audio.Audio;
import bots.longpoll.sdk.model.board.BoardPostDeleteUpdate;
import bots.longpoll.sdk.model.board.BoardPostUpdate;
import bots.longpoll.sdk.model.market.item.MarketCommentDeleteUpdate;
import bots.longpoll.sdk.model.market.item.MarketCommentUpdate;
import bots.longpoll.sdk.model.market.order.MarketOrder;
import bots.longpoll.sdk.model.other.AppPayload;
import bots.longpoll.sdk.model.other.GroupChangePhotoUpdate;
import bots.longpoll.sdk.model.other.GroupChangeSettingsUpdate;
import bots.longpoll.sdk.model.other.VkpayTransaction;
import bots.longpoll.sdk.model.photos.Photo;
import bots.longpoll.sdk.model.messages.Message;
import bots.longpoll.sdk.model.messages.MessageUpdate;
import bots.longpoll.sdk.model.photos.PhotoCommentDeleteUpdate;
import bots.longpoll.sdk.model.photos.PhotoCommentUpdate;
import bots.longpoll.sdk.model.update.UnimplementedUpdateObject;
import bots.longpoll.sdk.model.update.Update;
import bots.longpoll.sdk.model.users.GroupJoinUpdate;
import bots.longpoll.sdk.model.users.GroupLeaveUpdate;
import bots.longpoll.sdk.model.users.UserBlockUpdate;
import bots.longpoll.sdk.model.users.UserUnblockUpdate;
import bots.longpoll.sdk.model.video.Video;
import bots.longpoll.sdk.model.video.VideoCommentDeleteUpdate;
import bots.longpoll.sdk.model.video.VideoCommentUpdate;
import bots.longpoll.sdk.model.wall.post.WallPost;
import bots.longpoll.sdk.model.wall.reply.WallReplyDeleteUpdate;
import bots.longpoll.sdk.model.wall.reply.WallReplyUpdate;
import bots.longpoll.sdk.server.Server;
import bots.longpoll.sdk.server.impl.LongPollServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
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

	private void processUpdates(List<Update> updates) {
		updates.forEach(update -> {
			switch (update.getType()) {
				case UpdateTypes.MESSAGE_NEW:
					bot.onMessageNew((MessageUpdate) update.getObject());
					break;

				case UpdateTypes.MESSAGE_REPLY:
					bot.onMessageReply((Message) update.getObject());
					break;

				case UpdateTypes.MESSAGE_EDIT:
					bot.onMessageEdit((Message) update.getObject());
					break;

				case UpdateTypes.PHOTO_NEW:
					bot.onPhotoNew((Photo) update.getObject());
					break;

				case UpdateTypes.PHOTO_COMMENT_NEW:
					bot.onPhotoCommentNew((PhotoCommentUpdate) update.getObject());
					break;

				case UpdateTypes.PHOTO_COMMENT_EDIT:
					bot.onPhotoCommentEdit((PhotoCommentUpdate) update.getObject());
					break;

				case UpdateTypes.PHOTO_COMMENT_DELETE:
					bot.onPhotoCommentDelete((PhotoCommentDeleteUpdate) update.getObject());
					break;

				case UpdateTypes.PHOTO_COMMENT_RESTORE:
					bot.onPhotoCommentRestore((PhotoCommentUpdate) update.getObject());
					break;

				case UpdateTypes.AUDIO_NEW:
					bot.onAudioNew((Audio) update.getObject());
					break;

				case UpdateTypes.VIDEO_NEW:
					bot.onVideoNew((Video) update.getObject());
					break;

				case UpdateTypes.VIDEO_COMMENT_NEW:
					bot.onVideoCommentNew((VideoCommentUpdate) update.getObject());
					break;

				case UpdateTypes.VIDEO_COMMENT_EDIT:
					bot.onVideoCommentEdit((VideoCommentUpdate) update.getObject());
					break;

				case UpdateTypes.VIDEO_COMMENT_DELETE:
					bot.onVideoCommentDelete((VideoCommentDeleteUpdate) update.getObject());
					break;

				case UpdateTypes.VIDEO_COMMENT_RESTORE:
					bot.onVideoCommentRestore((VideoCommentUpdate) update.getObject());
					break;

				case UpdateTypes.WALL_POST_NEW:
					bot.onWallPostNew((WallPost) update.getObject());
					break;

				case UpdateTypes.WALL_REPOST:
					bot.onWallRepost((WallPost) update.getObject());
					break;

				case UpdateTypes.LIKE_ADD:
					bot.onLikeAdd((LikeUpdate) update.getObject());
					break;

				case UpdateTypes.LIKE_REMOVE:
					bot.onLikeRemove((LikeUpdate) update.getObject());
					break;

				case UpdateTypes.WALL_REPLY_NEW:
					bot.onWallReplyNew((WallReplyUpdate) update.getObject());
					break;

				case UpdateTypes.WALL_REPLY_EDIT:
					bot.onWallReplyEdit((WallReplyUpdate) update.getObject());
					break;

				case UpdateTypes.WALL_REPLY_DELETE:
					bot.onWallReplyDelete((WallReplyDeleteUpdate) update.getObject());
					break;

				case UpdateTypes.WALL_REPLY_RESTORE:
					bot.onWallReplyRestore((WallReplyUpdate) update.getObject());
					break;

				case UpdateTypes.BOARD_POST_NEW:
					bot.onBoardPostNew((BoardPostUpdate) update.getObject());
					break;

				case UpdateTypes.BOARD_POST_EDIT:
					bot.onBoardPostEdit((BoardPostUpdate) update.getObject());
					break;

				case UpdateTypes.BOARD_POST_DELETE:
					bot.onBoardPostDelete((BoardPostDeleteUpdate) update.getObject());
					break;

				case UpdateTypes.BOARD_POST_RESTORE:
					bot.onBoardPostRestore((BoardPostUpdate) update.getObject());
					break;

				case UpdateTypes.MARKET_COMMENT_NEW:
					bot.onMarketCommentNew((MarketCommentUpdate) update.getObject());
					break;

				case UpdateTypes.MARKET_COMMENT_EDIT:
					bot.onMarketCommentEdit((MarketCommentUpdate) update.getObject());
					break;

				case UpdateTypes.MARKET_COMMENT_RESTORE:
					bot.onMarketCommentRestore((MarketCommentUpdate) update.getObject());
					break;

				case UpdateTypes.MARKET_COMMENT_DELETE:
					bot.onMarketCommentDelete((MarketCommentDeleteUpdate) update.getObject());
					break;

				case UpdateTypes.MARKET_ORDER_NEW:
					bot.onMarketOrderNew((MarketOrder) update.getObject());
					break;

				case UpdateTypes.MARKET_ORDER_EDIT:
					bot.onMarketOrderEdit((MarketOrder) update.getObject());
					break;

				case UpdateTypes.GROUP_LEAVE:
					bot.onGroupLeave((GroupLeaveUpdate) update.getObject());
					break;

				case UpdateTypes.GROUP_JOIN:
					bot.onGroupJoin((GroupJoinUpdate) update.getObject());
					break;

				case UpdateTypes.USER_BLOCK:
					bot.onUserBlock((UserBlockUpdate) update.getObject());
					break;

				case UpdateTypes.USER_UNBLOCK:
					bot.onUserUnblock((UserUnblockUpdate) update.getObject());
					break;

				case UpdateTypes.GROUP_CHANGE_SETTINGS:
					bot.onGroupChangeSettings((GroupChangeSettingsUpdate) update.getObject());
					break;

				case UpdateTypes.GROUP_CHANGE_PHOTO:
					bot.onGroupChangePhoto((GroupChangePhotoUpdate) update.getObject());
					break;

				case UpdateTypes.VKPAY_TRANSACTION:
					bot.onVkpayTransaction((VkpayTransaction) update.getObject());
					break;

				case UpdateTypes.APP_PAYLOAD:
					bot.onAppPayload((AppPayload) update.getObject());
					break;

				default:
					bot.onUnimplementedUpdate((UnimplementedUpdateObject) update.getObject());
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
