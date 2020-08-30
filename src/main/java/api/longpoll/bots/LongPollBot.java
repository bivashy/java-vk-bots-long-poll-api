package api.longpoll.bots;

import api.longpoll.bots.model.events.boards.BoardPostDeleteEvent;
import api.longpoll.bots.model.events.boards.BoardPostEvent;
import api.longpoll.bots.model.events.likes.LikeEvent;
import api.longpoll.bots.model.events.market.MarketCommentDeleteEvent;
import api.longpoll.bots.model.events.market.MarketCommentEvent;
import api.longpoll.bots.model.events.messages.MessageEvent;
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

public abstract class LongPollBot {
    public abstract String getAccessToken();

    public abstract int getGroupId();


    public void onMessageNew(MessageEvent messageEvent) {
    }

    public void onMessageReply(Message message) {
    }

    public void onMessageEdit(Message message) {
    }

    public void onPhotoNew(Photo photo) {
    }

    public void onPhotoCommentNew(PhotoCommentEvent photoCommentEvent) {
    }

    public void onPhotoCommentEdit(PhotoCommentEvent photoCommentEvent) {
    }

    public void onPhotoCommentDelete(PhotoCommentDeleteEvent photoCommentDeleteEvent) {
    }

    public void onPhotoCommentRestore(PhotoCommentEvent photoCommentEvent) {
    }

    public void onVideoNew(Video video) {
    }

    public void onAudioNew(Audio audio) {
    }

    public void onVideoCommentNew(VideoCommentEvent videoCommentEvent) {
    }

    public void onVideoCommentEdit(VideoCommentEvent videoCommentEvent) {
    }

    public void onVideoCommentDelete(VideoCommentDeleteEvent videoCommentDeleteEvent) {
    }

    public void onVideoCommentRestore(VideoCommentEvent videoCommentEvent) {
    }

    public void onWallPostNew(WallPost wallPost) {
    }

    public void onWallRepost(WallPost wallPost) {
    }

    public void onLikeAdd(LikeEvent likeEvent) {
    }

    public void onLikeRemove(LikeEvent likeEvent) {
    }

    public void onWallReplyNew(WallReplyEvent wallReplyEvent) {
    }

    public void onWallReplyEdit(WallReplyEvent wallReplyEvent) {
    }

    public void onWallReplyDelete(WallReplyDeleteEvent wallReplyDeleteEvent) {
    }

    public void onWallReplyRestore(WallReplyEvent wallReplyEvent) {
    }

    public void onBoardPostNew(BoardPostEvent boardPostEvent) {
    }

    public void onBoardPostEdit(BoardPostEvent boardPostEvent) {
    }

    public void onBoardPostDelete(BoardPostDeleteEvent boardPostDeleteEvent) {
    }

    public void onBoardPostRestore(BoardPostEvent boardPostEvent) {
    }

    public void onMarketCommentNew(MarketCommentEvent marketCommentEvent) {
    }

    public void onMarketCommentEdit(MarketCommentEvent marketCommentEvent) {
    }

    public void onMarketCommentRestore(MarketCommentEvent marketCommentEvent) {
    }

    public void onMarketCommentDelete(MarketCommentDeleteEvent marketCommentDeleteEvent) {
    }

    public void onMarketOrderNew(MarketOrder marketOrder) {
    }

    public void onMarketOrderEdit(MarketOrder marketOrder) {
    }

    public void onGroupLeave(GroupLeaveEvent groupLeaveEvent) {
    }

    public void onGroupJoin(GroupJoinEvent groupJoinEvent) {
    }

    public void onUserBlock(UserBlockEvent userBlockEvent) {
    }

    public void onUserUnblock(UserUnblockEvent userUnblockEvent) {
    }

    public void onGroupChangeSettings(GroupChangeSettingsEvent groupChangeSettingsEvent) {
    }

    public void onGroupChangePhoto(GroupChangePhotoEvent groupChangePhotoEvent) {
    }

    public void onVkpayTransaction(VkpayTransaction vkpayTransaction) {
    }

    public void onAppPayload(AppPayload appPayload) {
    }
}
