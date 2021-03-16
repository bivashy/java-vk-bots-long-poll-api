package api.longpoll.bots.converters.events;

import api.longpoll.bots.converters.CachedConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
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
import api.longpoll.bots.model.objects.basic.Message;
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
        CONVERTERS.put(EventType.APP_PAYLOAD, CachedConverterFactory.getConverter(AppPayload.class));

        CONVERTERS.put(EventType.AUDIO_NEW, CachedConverterFactory.getConverter(Audio.class));

        CONVERTERS.put(EventType.BOARD_POST_DELETE, CachedConverterFactory.getConverter(BoardPostDeleteEvent.class));
        CONVERTERS.put(EventType.BOARD_POST_EDIT, CachedConverterFactory.getConverter(BoardPostEvent.class));
        CONVERTERS.put(EventType.BOARD_POST_NEW, CachedConverterFactory.getConverter(BoardPostEvent.class));
        CONVERTERS.put(EventType.BOARD_POST_RESTORE, CachedConverterFactory.getConverter(BoardPostEvent.class));

        CONVERTERS.put(EventType.GROUP_CHANGE_PHOTO, CachedConverterFactory.getConverter(GroupChangePhotoEvent.class));
        CONVERTERS.put(EventType.GROUP_CHANGE_SETTINGS, CachedConverterFactory.getConverter(GroupChangeSettingsEvent.class));
        CONVERTERS.put(EventType.GROUP_JOIN, CachedConverterFactory.getConverter(GroupJoinEvent.class));
        CONVERTERS.put(EventType.GROUP_LEAVE, CachedConverterFactory.getConverter(GroupLeaveEvent.class));

        CONVERTERS.put(EventType.MARKET_COMMENT_DELETE, CachedConverterFactory.getConverter(MarketCommentDeleteEvent.class));
        CONVERTERS.put(EventType.MARKET_COMMENT_EDIT, CachedConverterFactory.getConverter(MarketCommentEvent.class));
        CONVERTERS.put(EventType.MARKET_COMMENT_NEW, CachedConverterFactory.getConverter(MarketCommentEvent.class));
        CONVERTERS.put(EventType.MARKET_COMMENT_RESTORE, CachedConverterFactory.getConverter(MarketCommentEvent.class));
        CONVERTERS.put(EventType.MARKET_ORDER_EDIT, CachedConverterFactory.getConverter(MarketOrder.class));
        CONVERTERS.put(EventType.MARKET_ORDER_NEW, CachedConverterFactory.getConverter(MarketOrder.class));

        JsonToPojoConverter<Message> messageConverter = new MessageConverter();
        CONVERTERS.put(EventType.MESSAGE_EDIT, messageConverter);
        CONVERTERS.put(EventType.MESSAGE_EVENT, CachedConverterFactory.getConverter(MessageEvent.class));
        CONVERTERS.put(EventType.MESSAGE_NEW, new MessageNewEventConverter());
        CONVERTERS.put(EventType.MESSAGE_REPLY, messageConverter);
        CONVERTERS.put(EventType.MESSAGE_ALLOW, CachedConverterFactory.getConverter(MessageAllowEvent.class));
        CONVERTERS.put(EventType.MESSAGE_DENY, CachedConverterFactory.getConverter(MessageDenyEvent.class));
        CONVERTERS.put(EventType.MESSAGE_TYPING_STATE, CachedConverterFactory.getConverter(MessageTypingStateEvent.class));

        CONVERTERS.put(EventType.LIKE_ADD, CachedConverterFactory.getConverter(LikeEvent.class));
        CONVERTERS.put(EventType.LIKE_REMOVE, CachedConverterFactory.getConverter(LikeEvent.class));

        JsonToPojoConverter<PhotoCommentEvent> photoCommentEventConverter = AttachmentHolderConverter.of(PhotoCommentEvent.class);
        CONVERTERS.put(EventType.PHOTO_COMMENT_DELETE, CachedConverterFactory.getConverter(PhotoCommentDeleteEvent.class));
        CONVERTERS.put(EventType.PHOTO_COMMENT_EDIT, photoCommentEventConverter);
        CONVERTERS.put(EventType.PHOTO_COMMENT_NEW, photoCommentEventConverter);
        CONVERTERS.put(EventType.PHOTO_COMMENT_RESTORE, photoCommentEventConverter);
        CONVERTERS.put(EventType.PHOTO_NEW, CachedConverterFactory.getConverter(Photo.class));

        CONVERTERS.put(EventType.USER_BLOCK, CachedConverterFactory.getConverter(UserBlockEvent.class));
        CONVERTERS.put(EventType.USER_UNBLOCK, CachedConverterFactory.getConverter(UserUnblockEvent.class));

        JsonToPojoConverter<VideoCommentEvent> videoCommentEventConverter = AttachmentHolderConverter.of(VideoCommentEvent.class);
        CONVERTERS.put(EventType.VIDEO_COMMENT_DELETE, CachedConverterFactory.getConverter(VideoCommentDeleteEvent.class));
        CONVERTERS.put(EventType.VIDEO_COMMENT_EDIT, videoCommentEventConverter);
        CONVERTERS.put(EventType.VIDEO_COMMENT_NEW, videoCommentEventConverter);
        CONVERTERS.put(EventType.VIDEO_COMMENT_RESTORE, videoCommentEventConverter);
        CONVERTERS.put(EventType.VIDEO_NEW, CachedConverterFactory.getConverter(Video.class));

        JsonToPojoConverter<WallPost> wallPostConverter = AttachmentHolderConverter.of(WallPost.class);
        JsonToPojoConverter<WallReplyEvent> wallReplyEventConverter = AttachmentHolderConverter.of(WallReplyEvent.class);
        CONVERTERS.put(EventType.WALL_POST_NEW, wallPostConverter);
        CONVERTERS.put(EventType.WALL_REPLY_DELETE, CachedConverterFactory.getConverter(WallReplyDeleteEvent.class));
        CONVERTERS.put(EventType.WALL_REPLY_EDIT, wallReplyEventConverter);
        CONVERTERS.put(EventType.WALL_REPLY_NEW, wallReplyEventConverter);
        CONVERTERS.put(EventType.WALL_REPLY_RESTORE, wallReplyEventConverter);
        CONVERTERS.put(EventType.WALL_REPOST, wallPostConverter);

        CONVERTERS.put(EventType.VKPAY_TRANSACTION, CachedConverterFactory.getConverter(VkpayTransaction.class));
    }
}
