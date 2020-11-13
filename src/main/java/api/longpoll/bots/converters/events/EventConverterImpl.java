package api.longpoll.bots.converters.events;

import api.longpoll.bots.constants.EventTypes;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.basic.MessageConverterImpl;
import api.longpoll.bots.converters.basic.WallPostConverterImpl;
import api.longpoll.bots.converters.events.messages.MessageEventConverterImpl;
import api.longpoll.bots.converters.events.photos.PhotoCommentEventConverterImpl;
import api.longpoll.bots.converters.events.video.VideoCommentEventConverterImpl;
import api.longpoll.bots.converters.events.wall.WallReplyEventConverterImpl;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
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
import api.longpoll.bots.model.events.users.GroupJoinEvent;
import api.longpoll.bots.model.events.users.GroupLeaveEvent;
import api.longpoll.bots.model.events.users.UserBlockEvent;
import api.longpoll.bots.model.events.users.UserUnblockEvent;
import api.longpoll.bots.model.events.video.VideoCommentDeleteEvent;
import api.longpoll.bots.model.events.wall.comments.WallReplyDeleteEvent;
import api.longpoll.bots.model.objects.basic.MarketOrder;
import api.longpoll.bots.model.objects.media.Audio;
import api.longpoll.bots.model.objects.media.Photo;
import api.longpoll.bots.model.objects.media.Video;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class EventConverterImpl extends JsonToPojoConverter<Event> {
    private static final Logger log = LoggerFactory.getLogger(EventConverterImpl.class);
    private static final String OBJECT_FIELD = "object";

    private static final Map<String, JsonToPojoConverter<? extends EventObject>> CONVERTERS = new HashMap<>();

    static {
        CONVERTERS.put(EventTypes.APP_PAYLOAD, GenericConverterFactory.get(AppPayload.class));

        CONVERTERS.put(EventTypes.AUDIO_NEW, GenericConverterFactory.get(Audio.class));

        CONVERTERS.put(EventTypes.BOARD_POST_DELETE, GenericConverterFactory.get(BoardPostDeleteEvent.class));
        CONVERTERS.put(EventTypes.BOARD_POST_EDIT, GenericConverterFactory.get(BoardPostEvent.class));
        CONVERTERS.put(EventTypes.BOARD_POST_NEW, GenericConverterFactory.get(BoardPostEvent.class));
        CONVERTERS.put(EventTypes.BOARD_POST_RESTORE, GenericConverterFactory.get(BoardPostEvent.class));

        CONVERTERS.put(EventTypes.GROUP_CHANGE_PHOTO, GenericConverterFactory.get(GroupChangePhotoEvent.class));
        CONVERTERS.put(EventTypes.GROUP_CHANGE_SETTINGS, GenericConverterFactory.get(GroupChangeSettingsEvent.class));
        CONVERTERS.put(EventTypes.GROUP_JOIN, GenericConverterFactory.get(GroupJoinEvent.class));
        CONVERTERS.put(EventTypes.GROUP_LEAVE, GenericConverterFactory.get(GroupLeaveEvent.class));

        CONVERTERS.put(EventTypes.MARKET_COMMENT_DELETE, GenericConverterFactory.get(MarketCommentDeleteEvent.class));
        CONVERTERS.put(EventTypes.MARKET_COMMENT_EDIT, GenericConverterFactory.get(MarketCommentEvent.class));
        CONVERTERS.put(EventTypes.MARKET_COMMENT_NEW, GenericConverterFactory.get(MarketCommentEvent.class));
        CONVERTERS.put(EventTypes.MARKET_COMMENT_RESTORE, GenericConverterFactory.get(MarketCommentEvent.class));
        CONVERTERS.put(EventTypes.MARKET_ORDER_EDIT, GenericConverterFactory.get(MarketOrder.class));
        CONVERTERS.put(EventTypes.MARKET_ORDER_NEW, GenericConverterFactory.get(MarketOrder.class));

        CONVERTERS.put(EventTypes.MESSAGE_EDIT, new MessageConverterImpl());
        CONVERTERS.put(EventTypes.MESSAGE_EVENT, GenericConverterFactory.get(MessageEvent.class));
        CONVERTERS.put(EventTypes.MESSAGE_NEW, new MessageEventConverterImpl());
        CONVERTERS.put(EventTypes.MESSAGE_REPLY, new MessageConverterImpl());
        CONVERTERS.put(EventTypes.MESSAGE_ALLOW, GenericConverterFactory.get(MessageAllowEvent.class));
        CONVERTERS.put(EventTypes.MESSAGE_DENY, GenericConverterFactory.get(MessageDenyEvent.class));
        CONVERTERS.put(EventTypes.MESSAGE_TYPING_STATE, GenericConverterFactory.get(MessageTypingStateEvent.class));

        CONVERTERS.put(EventTypes.LIKE_ADD, GenericConverterFactory.get(LikeEvent.class));
        CONVERTERS.put(EventTypes.LIKE_REMOVE, GenericConverterFactory.get(LikeEvent.class));

        CONVERTERS.put(EventTypes.PHOTO_COMMENT_DELETE, GenericConverterFactory.get(PhotoCommentDeleteEvent.class));
        CONVERTERS.put(EventTypes.PHOTO_COMMENT_EDIT, new PhotoCommentEventConverterImpl());
        CONVERTERS.put(EventTypes.PHOTO_COMMENT_NEW, new PhotoCommentEventConverterImpl());
        CONVERTERS.put(EventTypes.PHOTO_COMMENT_RESTORE, new PhotoCommentEventConverterImpl());
        CONVERTERS.put(EventTypes.PHOTO_NEW, GenericConverterFactory.get(Photo.class));

        CONVERTERS.put(EventTypes.USER_BLOCK, GenericConverterFactory.get(UserBlockEvent.class));
        CONVERTERS.put(EventTypes.USER_UNBLOCK, GenericConverterFactory.get(UserUnblockEvent.class));

        CONVERTERS.put(EventTypes.VIDEO_COMMENT_DELETE, GenericConverterFactory.get(VideoCommentDeleteEvent.class));
        CONVERTERS.put(EventTypes.VIDEO_COMMENT_EDIT, new VideoCommentEventConverterImpl());
        CONVERTERS.put(EventTypes.VIDEO_COMMENT_NEW, new VideoCommentEventConverterImpl());
        CONVERTERS.put(EventTypes.VIDEO_COMMENT_RESTORE, new VideoCommentEventConverterImpl());
        CONVERTERS.put(EventTypes.VIDEO_NEW, GenericConverterFactory.get(Video.class));

        CONVERTERS.put(EventTypes.WALL_POST_NEW, new WallPostConverterImpl());
        CONVERTERS.put(EventTypes.WALL_REPLY_DELETE, GenericConverterFactory.get(WallReplyDeleteEvent.class));
        CONVERTERS.put(EventTypes.WALL_REPLY_EDIT, new WallReplyEventConverterImpl());
        CONVERTERS.put(EventTypes.WALL_REPLY_NEW, new WallReplyEventConverterImpl());
        CONVERTERS.put(EventTypes.WALL_REPLY_RESTORE, new WallReplyEventConverterImpl());
        CONVERTERS.put(EventTypes.WALL_REPOST, new WallPostConverterImpl());

        CONVERTERS.put(EventTypes.VKPAY_TRANSACTION, GenericConverterFactory.get(VkpayTransaction.class));
    }

    @Override
    public Event convert(JsonObject jsonObject) {
        Event event = gson.fromJson(jsonObject, Event.class);

        JsonObject jsonUpdateObject = jsonObject.getAsJsonObject(OBJECT_FIELD);
        String type = event.getType();

        if (CONVERTERS.containsKey(type)) {
            event.setObject(CONVERTERS.get(type).convert(jsonUpdateObject));
        } else {
            log.warn("There is no converter for event type: {}", type);
        }

        return event;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return Event.class.equals(fieldAttributes.getDeclaringClass())
                && EventObject.class.equals(fieldAttributes.getDeclaredClass())
                && OBJECT_FIELD.equals(fieldAttributes.getName());
    }
}
