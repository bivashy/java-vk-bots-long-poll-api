package api.longpoll.bots.adapters.deserializers;

import api.longpoll.bots.model.events.Update;
import api.longpoll.bots.model.events.boards.BoardPost;
import api.longpoll.bots.model.events.boards.BoardPostDelete;
import api.longpoll.bots.model.events.likes.Like;
import api.longpoll.bots.model.events.market.MarketComment;
import api.longpoll.bots.model.events.market.MarketCommentDelete;
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
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Deserializes JSON objects to {@link Update}.
 */
public class UpdateDeserializer implements JsonDeserializer<Update> {
    @Override
    public final Update deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonEvent = jsonElement.getAsJsonObject();

        Update update = new Update();
        update.setType(jsonDeserializationContext.deserialize(
                jsonEvent.get("type"),
                Update.Type.class
        ));
        update.setGroupId(jsonEvent.get("group_id").getAsInt());
        update.setEventId(jsonEvent.get("event_id").getAsString());
        update.setObject(jsonDeserializationContext.deserialize(
                jsonEvent.get("object"),
                getObjectClass(update.getType())
        ));
        return update;
    }

    private Class<? extends Update.Object> getObjectClass(Update.Type type) {
        switch (type) {
            case APP_PAYLOAD:
                return AppPayload.class;

            case AUDIO_NEW:
                return Audio.class;

            case BOARD_POST_DELETE:
                return BoardPostDelete.class;

            case BOARD_POST_EDIT:
            case BOARD_POST_NEW:
            case BOARD_POST_RESTORE:
                return BoardPost.class;

            case GROUP_CHANGE_PHOTO:
                return GroupChangePhoto.class;

            case GROUP_CHANGE_SETTINGS:
                return GroupChangeSettings.class;

            case GROUP_JOIN:
                return GroupJoin.class;

            case GROUP_LEAVE:
                return GroupLeave.class;

            case MARKET_COMMENT_DELETE:
                return MarketCommentDelete.class;

            case MARKET_COMMENT_EDIT:
            case MARKET_COMMENT_NEW:
            case MARKET_COMMENT_RESTORE:
                return MarketComment.class;

            case MARKET_ORDER_EDIT:
            case MARKET_ORDER_NEW:
                return MarketOrder.class;

            case MESSAGE_EDIT:
                return Message.class;

            case MESSAGE_EVENT:
                return MessageEvent.class;

            case MESSAGE_NEW:
                return MessageNew.class;

            case MESSAGE_REPLY:
                return Message.class;

            case MESSAGE_ALLOW:
                return MessageAllow.class;

            case MESSAGE_DENY:
                return MessageDeny.class;

            case MESSAGE_TYPING_STATE:
                return MessageTypingState.class;

            case LIKE_ADD:
            case LIKE_REMOVE:
                return Like.class;

            case PHOTO_COMMENT_DELETE:
                return PhotoCommentDelete.class;

            case PHOTO_COMMENT_EDIT:
            case PHOTO_COMMENT_NEW:
            case PHOTO_COMMENT_RESTORE:
                return PhotoComment.class;

            case PHOTO_NEW:
                return Photo.class;

            case USER_BLOCK:
                return UserBlock.class;

            case USER_UNBLOCK:
                return UserUnblock.class;

            case VIDEO_COMMENT_DELETE:
                return VideoCommentDelete.class;

            case VIDEO_COMMENT_EDIT:
            case VIDEO_COMMENT_NEW:
            case VIDEO_COMMENT_RESTORE:
                return VideoComment.class;

            case VIDEO_NEW:
                return Video.class;

            case WALL_POST_NEW:
                return WallPost.class;

            case WALL_REPLY_DELETE:
                return WallReplyDelete.class;

            case WALL_REPLY_EDIT:
            case WALL_REPLY_NEW:
            case WALL_REPLY_RESTORE:
                return WallReply.class;

            case WALL_REPOST:
                return WallPost.class;

            case VKPAY_TRANSACTION:
                return VkpayTransaction.class;

            default:
                throw new RuntimeException("Update type '" + type + "' is not handled.");
        }
    }
}
