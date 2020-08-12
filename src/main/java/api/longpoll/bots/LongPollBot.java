package api.longpoll.bots;

import api.longpoll.bots.model.likes.LikeEvent;
import api.longpoll.bots.model.audio.Audio;
import api.longpoll.bots.model.board.BoardPostDeleteEvent;
import api.longpoll.bots.model.board.BoardPostEvent;
import api.longpoll.bots.model.market.item.MarketCommentDeleteEvent;
import api.longpoll.bots.model.market.item.MarketCommentEvent;
import api.longpoll.bots.model.market.order.MarketOrder;
import api.longpoll.bots.model.other.AppPayload;
import api.longpoll.bots.model.other.GroupChangePhotoEvent;
import api.longpoll.bots.model.other.GroupChangeSettingsEvent;
import api.longpoll.bots.model.other.VkpayTransaction;
import api.longpoll.bots.model.photos.Photo;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.photos.PhotoCommentDeleteEvent;
import api.longpoll.bots.model.photos.PhotoCommentEvent;
import api.longpoll.bots.model.events.UnimplementedEventObject;
import api.longpoll.bots.model.events.messages.MessageEvent;
import api.longpoll.bots.model.users.GroupJoinEvent;
import api.longpoll.bots.model.users.GroupLeaveEvent;
import api.longpoll.bots.model.users.UserBlockEvent;
import api.longpoll.bots.model.users.UserUnblockEvent;
import api.longpoll.bots.model.video.Video;
import api.longpoll.bots.model.video.VideoCommentDeleteEvent;
import api.longpoll.bots.model.video.VideoCommentEvent;
import api.longpoll.bots.model.wall.post.WallPost;
import api.longpoll.bots.model.wall.reply.WallReplyDeleteEvent;
import api.longpoll.bots.model.wall.reply.WallReplyEvent;

public abstract class LongPollBot {
	public abstract String getAccessToken();

	public abstract String getApiVersion();

	public abstract int getGroupId();

	public void onUnimplementedUpdate(UnimplementedEventObject updateObject) {
	}

	public void onMessageNew(MessageEvent messageUpdate) {
	}

	public void onMessageReply(Message message) {
	}

	public void onMessageEdit(Message message) {
	}

	public void onPhotoNew(Photo photo) {
	}

	public void onPhotoCommentNew(PhotoCommentEvent photoCommentUpdate) {
	}

	public void onPhotoCommentEdit(PhotoCommentEvent photoCommentUpdate) {
	}

	public void onPhotoCommentDelete(PhotoCommentDeleteEvent photoCommentDeleteUpdate) {
	}

	public void onPhotoCommentRestore(PhotoCommentEvent photoCommentUpdate) {
	}

	public void onVideoNew(Video video) {
	}

	public void onAudioNew(Audio audio) {
	}

	public void onVideoCommentNew(VideoCommentEvent videoCommentUpdate) {
	}

	public void onVideoCommentEdit(VideoCommentEvent videoCommentUpdate) {
	}

	public void onVideoCommentDelete(VideoCommentDeleteEvent videoCommentDeleteUpdate) {
	}

	public void onVideoCommentRestore(VideoCommentEvent videoCommentUpdate) {
	}

	public void onWallPostNew(WallPost wallPost) {
	}

	public void onWallRepost(WallPost wallPost) {
	}

	public void onLikeAdd(LikeEvent likeUpdate) {
	}

	public void onLikeRemove(LikeEvent likeUpdate) {
	}

	public void onWallReplyNew(WallReplyEvent wallReplyUpdate) {
	}

	public void onWallReplyEdit(WallReplyEvent wallReplyUpdate) {
	}

	public void onWallReplyDelete(WallReplyDeleteEvent wallReplyDeleteUpdate) {
	}

	public void onWallReplyRestore(WallReplyEvent wallReplyUpdate) {
	}

	public void onBoardPostNew(BoardPostEvent boardPostUpdate) {
	}

	public void onBoardPostEdit(BoardPostEvent boardPostUpdate) {
	}

	public void onBoardPostDelete(BoardPostDeleteEvent boardPostDeleteUpdate) {
	}

	public void onBoardPostRestore(BoardPostEvent boardPostUpdate) {
	}

	public void onMarketCommentNew(MarketCommentEvent marketCommentUpdate) {
	}

	public void onMarketCommentEdit(MarketCommentEvent marketCommentUpdate) {
	}

	public void onMarketCommentRestore(MarketCommentEvent marketCommentUpdate) {
	}

	public void onMarketCommentDelete(MarketCommentDeleteEvent marketCommentDeleteUpdate) {
	}

	public void onMarketOrderNew(MarketOrder marketOrder) {
	}

	public void onMarketOrderEdit(MarketOrder marketOrder) {
	}

	public void onGroupLeave(GroupLeaveEvent groupLeaveUpdate) {
	}

	public void onGroupJoin(GroupJoinEvent groupJoinUpdate) {
	}

	public void onUserBlock(UserBlockEvent userBlockUpdate) {
	}

	public void onUserUnblock(UserUnblockEvent userUnblockUpdate) {
	}

	public void onGroupChangeSettings(GroupChangeSettingsEvent groupChangeSettingsUpdate) {
	}

	public void onGroupChangePhoto(GroupChangePhotoEvent groupChangePhotoUpdate) {
	}

	public void onVkpayTransaction(VkpayTransaction vkpayTransaction) {
	}

	public void onAppPayload(AppPayload appPayload) {
	}
}
