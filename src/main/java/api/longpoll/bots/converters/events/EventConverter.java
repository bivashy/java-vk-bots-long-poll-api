package api.longpoll.bots.converters.events;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.JsonToPojoConverterFactory;
import api.longpoll.bots.converters.basic.AttachmentHolderConverter;
import api.longpoll.bots.converters.basic.MessageConverter;
import api.longpoll.bots.converters.events.messages.MessageNewEventConverter;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.EventType;
import api.longpoll.bots.model.events.boards.BoardPostDeleteEvent;
import api.longpoll.bots.model.events.boards.BoardPostEvent;
import api.longpoll.bots.model.events.likes.LikeEvent;
import api.longpoll.bots.model.events.market.MarketCommentDeleteEvent;
import api.longpoll.bots.model.events.market.MarketCommentEvent;
import api.longpoll.bots.model.events.messages.MessageAllowEvent;
import api.longpoll.bots.model.events.messages.MessageDenyEvent;
import api.longpoll.bots.model.events.messages.MessageEvent;
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
import api.longpoll.bots.model.objects.basic.WallPost;
import api.longpoll.bots.model.objects.media.Audio;
import api.longpoll.bots.model.objects.media.Photo;
import api.longpoll.bots.model.objects.media.Video;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class EventConverter extends JsonToPojoConverter<Event> {
    private static final Logger log = LoggerFactory.getLogger(EventConverter.class);
    private static final Map<EventType, JsonToPojoConverter<? extends EventObject>> CONVERTERS = new HashMap<>();

    @Override
    public Event convert(JsonObject jsonObject) {
        Event event = gson.fromJson(jsonObject, Event.class);
        if (CONVERTERS.containsKey(event.getType())) {
            JsonObject jsonUpdateObject = jsonObject.getAsJsonObject("object");
            event.setObject(CONVERTERS.get(event.getType()).convert(jsonUpdateObject));
        } else {
            log.warn("There is no converter for event type: {}", event.getType());
        }
        return event;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return Event.class.equals(fieldAttributes.getDeclaringClass())
                && EventObject.class.equals(fieldAttributes.getDeclaredClass())
                && "object".equals(fieldAttributes.getName());
    }

    static {
        CONVERTERS.put(EventType.APP_PAYLOAD, JsonToPojoConverterFactory.get(AppPayload.class));

        CONVERTERS.put(EventType.AUDIO_NEW, JsonToPojoConverterFactory.get(Audio.class));

        CONVERTERS.put(EventType.BOARD_POST_DELETE, JsonToPojoConverterFactory.get(BoardPostDeleteEvent.class));
        CONVERTERS.put(EventType.BOARD_POST_EDIT, JsonToPojoConverterFactory.get(BoardPostEvent.class));
        CONVERTERS.put(EventType.BOARD_POST_NEW, JsonToPojoConverterFactory.get(BoardPostEvent.class));
        CONVERTERS.put(EventType.BOARD_POST_RESTORE, JsonToPojoConverterFactory.get(BoardPostEvent.class));

        CONVERTERS.put(EventType.GROUP_CHANGE_PHOTO, JsonToPojoConverterFactory.get(GroupChangePhotoEvent.class));
        CONVERTERS.put(EventType.GROUP_CHANGE_SETTINGS, JsonToPojoConverterFactory.get(GroupChangeSettingsEvent.class));
        CONVERTERS.put(EventType.GROUP_JOIN, JsonToPojoConverterFactory.get(GroupJoinEvent.class));
        CONVERTERS.put(EventType.GROUP_LEAVE, JsonToPojoConverterFactory.get(GroupLeaveEvent.class));

        CONVERTERS.put(EventType.MARKET_COMMENT_DELETE, JsonToPojoConverterFactory.get(MarketCommentDeleteEvent.class));
        CONVERTERS.put(EventType.MARKET_COMMENT_EDIT, JsonToPojoConverterFactory.get(MarketCommentEvent.class));
        CONVERTERS.put(EventType.MARKET_COMMENT_NEW, JsonToPojoConverterFactory.get(MarketCommentEvent.class));
        CONVERTERS.put(EventType.MARKET_COMMENT_RESTORE, JsonToPojoConverterFactory.get(MarketCommentEvent.class));
        CONVERTERS.put(EventType.MARKET_ORDER_EDIT, JsonToPojoConverterFactory.get(MarketOrder.class));
        CONVERTERS.put(EventType.MARKET_ORDER_NEW, JsonToPojoConverterFactory.get(MarketOrder.class));

        CONVERTERS.put(EventType.MESSAGE_EDIT, new MessageConverter());
        CONVERTERS.put(EventType.MESSAGE_EVENT, JsonToPojoConverterFactory.get(MessageEvent.class));
        CONVERTERS.put(EventType.MESSAGE_NEW, new MessageNewEventConverter());
        CONVERTERS.put(EventType.MESSAGE_REPLY, new MessageConverter());
        CONVERTERS.put(EventType.MESSAGE_ALLOW, JsonToPojoConverterFactory.get(MessageAllowEvent.class));
        CONVERTERS.put(EventType.MESSAGE_DENY, JsonToPojoConverterFactory.get(MessageDenyEvent.class));
        CONVERTERS.put(EventType.MESSAGE_TYPING_STATE, JsonToPojoConverterFactory.get(MessageTypingStateEvent.class));

        CONVERTERS.put(EventType.LIKE_ADD, JsonToPojoConverterFactory.get(LikeEvent.class));
        CONVERTERS.put(EventType.LIKE_REMOVE, JsonToPojoConverterFactory.get(LikeEvent.class));

        CONVERTERS.put(EventType.PHOTO_COMMENT_DELETE, JsonToPojoConverterFactory.get(PhotoCommentDeleteEvent.class));
        CONVERTERS.put(EventType.PHOTO_COMMENT_EDIT, AttachmentHolderConverter.of(PhotoCommentEvent.class));
        CONVERTERS.put(EventType.PHOTO_COMMENT_NEW, AttachmentHolderConverter.of(PhotoCommentEvent.class));
        CONVERTERS.put(EventType.PHOTO_COMMENT_RESTORE, AttachmentHolderConverter.of(PhotoCommentEvent.class));
        CONVERTERS.put(EventType.PHOTO_NEW, JsonToPojoConverterFactory.get(Photo.class));

        CONVERTERS.put(EventType.USER_BLOCK, JsonToPojoConverterFactory.get(UserBlockEvent.class));
        CONVERTERS.put(EventType.USER_UNBLOCK, JsonToPojoConverterFactory.get(UserUnblockEvent.class));

        CONVERTERS.put(EventType.VIDEO_COMMENT_DELETE, JsonToPojoConverterFactory.get(VideoCommentDeleteEvent.class));
        CONVERTERS.put(EventType.VIDEO_COMMENT_EDIT, AttachmentHolderConverter.of(VideoCommentEvent.class));
        CONVERTERS.put(EventType.VIDEO_COMMENT_NEW, AttachmentHolderConverter.of(VideoCommentEvent.class));
        CONVERTERS.put(EventType.VIDEO_COMMENT_RESTORE, AttachmentHolderConverter.of(VideoCommentEvent.class));
        CONVERTERS.put(EventType.VIDEO_NEW, JsonToPojoConverterFactory.get(Video.class));

        CONVERTERS.put(EventType.WALL_POST_NEW, AttachmentHolderConverter.of(WallPost.class));
        CONVERTERS.put(EventType.WALL_REPLY_DELETE, JsonToPojoConverterFactory.get(WallReplyDeleteEvent.class));
        CONVERTERS.put(EventType.WALL_REPLY_EDIT, AttachmentHolderConverter.of(WallReplyEvent.class));
        CONVERTERS.put(EventType.WALL_REPLY_NEW, AttachmentHolderConverter.of(WallReplyEvent.class));
        CONVERTERS.put(EventType.WALL_REPLY_RESTORE, AttachmentHolderConverter.of(WallReplyEvent.class));
        CONVERTERS.put(EventType.WALL_REPOST, AttachmentHolderConverter.of(WallPost.class));

        CONVERTERS.put(EventType.VKPAY_TRANSACTION, JsonToPojoConverterFactory.get(VkpayTransaction.class));
    }
}
