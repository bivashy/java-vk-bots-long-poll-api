package api.longpoll.bots.adapters.deserializers;

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
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Deserializes JSON objects to {@link VkEvent}.
 */
public class EventDeserializer implements JsonDeserializer<VkEvent> {
    @Override
    public final VkEvent deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonEvent = jsonElement.getAsJsonObject();

        VkEvent event = new VkEvent();
        event.setType(jsonDeserializationContext.deserialize(
                jsonEvent.get("type"),
                EventType.class
        ));
        event.setGroupId(jsonEvent.get("group_id").getAsInt());
        event.setEventId(jsonEvent.get("event_id").getAsString());
        event.setObject(jsonDeserializationContext.deserialize(
                jsonEvent.get("object"),
                getType(event.getType())
        ));
        return event;
    }

    private Type getType(EventType type) {
        switch (type) {
            case APP_PAYLOAD:
                return AppPayload.class;

            case AUDIO_NEW:
                return Audio.class;

            case BOARD_POST_DELETE:
                return BoardPostDeleteEvent.class;

            case BOARD_POST_EDIT:
            case BOARD_POST_NEW:
            case BOARD_POST_RESTORE:
                return BoardPostEvent.class;

            case GROUP_CHANGE_PHOTO:
                return GroupChangePhotoEvent.class;

            case GROUP_CHANGE_SETTINGS:
                return GroupChangeSettingsEvent.class;

            case GROUP_JOIN:
                return GroupJoinEvent.class;

            case GROUP_LEAVE:
                return GroupLeaveEvent.class;

            case MARKET_COMMENT_DELETE:
                return MarketCommentDeleteEvent.class;

            case MARKET_COMMENT_EDIT:
            case MARKET_COMMENT_NEW:
            case MARKET_COMMENT_RESTORE:
                return MarketCommentEvent.class;

            case MARKET_ORDER_EDIT:
            case MARKET_ORDER_NEW:
                return MarketOrder.class;

            case MESSAGE_EDIT:
                return Message.class;

            case MESSAGE_EVENT:
                return MessageEvent.class;

            case MESSAGE_NEW:
                return MessageNewEvent.class;

            case MESSAGE_REPLY:
                return Message.class;

            case MESSAGE_ALLOW:
                return MessageAllowEvent.class;

            case MESSAGE_DENY:
                return MessageDenyEvent.class;

            case MESSAGE_TYPING_STATE:
                return MessageTypingStateEvent.class;

            case LIKE_ADD:
            case LIKE_REMOVE:
                return LikeEvent.class;

            case PHOTO_COMMENT_DELETE:
                return PhotoCommentDeleteEvent.class;

            case PHOTO_COMMENT_EDIT:
            case PHOTO_COMMENT_NEW:
            case PHOTO_COMMENT_RESTORE:
                return PhotoCommentEvent.class;

            case PHOTO_NEW:
                return Photo.class;

            case USER_BLOCK:
                return UserBlockEvent.class;

            case USER_UNBLOCK:
                return UserUnblockEvent.class;

            case VIDEO_COMMENT_DELETE:
                return VideoCommentDeleteEvent.class;

            case VIDEO_COMMENT_EDIT:
            case VIDEO_COMMENT_NEW:
            case VIDEO_COMMENT_RESTORE:
                return VideoCommentEvent.class;

            case VIDEO_NEW:
                return Video.class;

            case WALL_POST_NEW:
                return WallPost.class;

            case WALL_REPLY_DELETE:
                return WallReplyDeleteEvent.class;

            case WALL_REPLY_EDIT:
            case WALL_REPLY_NEW:
            case WALL_REPLY_RESTORE:
                return WallReplyEvent.class;

            case WALL_REPOST:
                return WallPost.class;

            case VKPAY_TRANSACTION:
            default:
                return VkpayTransaction.class;
        }
    }
}
