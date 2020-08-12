package bots.longpoll.sdk;

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
import bots.longpoll.sdk.model.photos.PhotoCommentDeleteUpdate;
import bots.longpoll.sdk.model.photos.PhotoCommentUpdate;
import bots.longpoll.sdk.model.update.UnimplementedUpdateObject;
import bots.longpoll.sdk.model.messages.MessageUpdate;
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

public abstract class LongPollBot {
	public abstract String getAccessToken();

	public abstract String getApiVersion();

	public abstract int getGroupId();

	public void onUnimplementedUpdate(UnimplementedUpdateObject updateObject) {
	}

	public void onMessageNew(MessageUpdate messageUpdate) {
	}

	public void onMessageReply(Message message) {
	}

	public void onMessageEdit(Message message) {
	}

	public void onPhotoNew(Photo photo) {
	}

	public void onPhotoCommentNew(PhotoCommentUpdate photoCommentUpdate) {
	}

	public void onPhotoCommentEdit(PhotoCommentUpdate photoCommentUpdate) {
	}

	public void onPhotoCommentDelete(PhotoCommentDeleteUpdate photoCommentDeleteUpdate) {
	}

	public void onPhotoCommentRestore(PhotoCommentUpdate photoCommentUpdate) {
	}

	public void onVideoNew(Video video) {
	}

	public void onAudioNew(Audio audio) {
	}

	public void onVideoCommentNew(VideoCommentUpdate videoCommentUpdate) {
	}

	public void onVideoCommentEdit(VideoCommentUpdate videoCommentUpdate) {
	}

	public void onVideoCommentDelete(VideoCommentDeleteUpdate videoCommentDeleteUpdate) {
	}

	public void onVideoCommentRestore(VideoCommentUpdate videoCommentUpdate) {
	}

	public void onWallPostNew(WallPost wallPost) {
	}

	public void onWallRepost(WallPost wallPost) {
	}

	public void onLikeAdd(LikeUpdate likeUpdate) {
	}

	public void onLikeRemove(LikeUpdate likeUpdate) {
	}

	public void onWallReplyNew(WallReplyUpdate wallReplyUpdate) {
	}

	public void onWallReplyEdit(WallReplyUpdate wallReplyUpdate) {
	}

	public void onWallReplyDelete(WallReplyDeleteUpdate wallReplyDeleteUpdate) {
	}

	public void onWallReplyRestore(WallReplyUpdate wallReplyUpdate) {
	}

	public void onBoardPostNew(BoardPostUpdate boardPostUpdate) {
	}

	public void onBoardPostEdit(BoardPostUpdate boardPostUpdate) {
	}

	public void onBoardPostDelete(BoardPostDeleteUpdate boardPostDeleteUpdate) {
	}

	public void onBoardPostRestore(BoardPostUpdate boardPostUpdate) {
	}

	public void onMarketCommentNew(MarketCommentUpdate marketCommentUpdate) {
	}

	public void onMarketCommentEdit(MarketCommentUpdate marketCommentUpdate) {
	}

	public void onMarketCommentRestore(MarketCommentUpdate marketCommentUpdate) {
	}

	public void onMarketCommentDelete(MarketCommentDeleteUpdate marketCommentDeleteUpdate) {
	}

	public void onMarketOrderNew(MarketOrder marketOrder) {
	}

	public void onMarketOrderEdit(MarketOrder marketOrder) {
	}

	public void onGroupLeave(GroupLeaveUpdate groupLeaveUpdate) {
	}

	public void onGroupJoin(GroupJoinUpdate groupJoinUpdate) {
	}

	public void onUserBlock(UserBlockUpdate userBlockUpdate) {
	}

	public void onUserUnblock(UserUnblockUpdate userUnblockUpdate) {
	}

	public void onGroupChangeSettings(GroupChangeSettingsUpdate groupChangeSettingsUpdate) {
	}

	public void onGroupChangePhoto(GroupChangePhotoUpdate groupChangePhotoUpdate) {
	}

	public void onVkpayTransaction(VkpayTransaction vkpayTransaction) {
	}

	public void onAppPayload(AppPayload appPayload) {
	}
}
