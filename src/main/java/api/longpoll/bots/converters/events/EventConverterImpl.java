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

public class EventConverterImpl extends JsonToPojoConverter<Event> {
	private static final String OBJECT_FIELD = "object";

	@Override
	public Event convert(JsonObject jsonObject) {
		Event event = gson.fromJson(jsonObject, Event.class);

		JsonObject jsonUpdateObject = jsonObject.getAsJsonObject(OBJECT_FIELD);

		switch (event.getType()) {
			case EventTypes.MESSAGE_NEW:
				return event.setObject(new MessageEventConverterImpl().convert(jsonUpdateObject));

			case EventTypes.MESSAGE_REPLY:
			case EventTypes.MESSAGE_EDIT:
				return event.setObject(new MessageConverterImpl().convert(jsonUpdateObject));

			case EventTypes.PHOTO_NEW:
				return event.setObject(GenericConverterFactory.get(Photo.class).convert(jsonUpdateObject));

			case EventTypes.PHOTO_COMMENT_NEW:
			case EventTypes.PHOTO_COMMENT_EDIT:
			case EventTypes.PHOTO_COMMENT_RESTORE:
				return event.setObject(new PhotoCommentEventConverterImpl().convert(jsonUpdateObject));

			case EventTypes.PHOTO_COMMENT_DELETE:
				return event.setObject(GenericConverterFactory.get(PhotoCommentDeleteEvent.class).convert(jsonUpdateObject));

			case EventTypes.AUDIO_NEW:
				return event.setObject(GenericConverterFactory.get(Audio.class).convert(jsonUpdateObject));

			case EventTypes.VIDEO_NEW:
				return event.setObject(GenericConverterFactory.get(Video.class).convert(jsonUpdateObject));

			case EventTypes.VIDEO_COMMENT_NEW:
			case EventTypes.VIDEO_COMMENT_EDIT:
			case EventTypes.VIDEO_COMMENT_RESTORE:
				return event.setObject(new VideoCommentEventConverterImpl().convert(jsonUpdateObject));

			case EventTypes.VIDEO_COMMENT_DELETE:
				return event.setObject(GenericConverterFactory.get(VideoCommentDeleteEvent.class).convert(jsonUpdateObject));

			case EventTypes.WALL_POST_NEW:
			case EventTypes.WALL_REPOST:
				return event.setObject(new WallPostConverterImpl().convert(jsonUpdateObject));

			case EventTypes.LIKE_ADD:
			case EventTypes.LIKE_REMOVE:
				return event.setObject(GenericConverterFactory.get(LikeEvent.class).convert(jsonUpdateObject));

			case EventTypes.WALL_REPLY_NEW:
			case EventTypes.WALL_REPLY_EDIT:
			case EventTypes.WALL_REPLY_RESTORE:
				return event.setObject(new WallReplyEventConverterImpl().convert(jsonUpdateObject));

			case EventTypes.WALL_REPLY_DELETE:
				return event.setObject(GenericConverterFactory.get(WallReplyDeleteEvent.class).convert(jsonUpdateObject));

			case EventTypes.BOARD_POST_NEW:
			case EventTypes.BOARD_POST_EDIT:
			case EventTypes.BOARD_POST_RESTORE:
				return event.setObject(GenericConverterFactory.get(BoardPostEvent.class).convert(jsonUpdateObject));

			case EventTypes.BOARD_POST_DELETE:
				return event.setObject(GenericConverterFactory.get(BoardPostDeleteEvent.class).convert(jsonUpdateObject));

			case EventTypes.MARKET_COMMENT_NEW:
			case EventTypes.MARKET_COMMENT_EDIT:
			case EventTypes.MARKET_COMMENT_RESTORE:
				return event.setObject(GenericConverterFactory.get(MarketCommentEvent.class).convert(jsonUpdateObject));

			case EventTypes.MARKET_COMMENT_DELETE:
				return event.setObject(GenericConverterFactory.get(MarketCommentDeleteEvent.class).convert(jsonUpdateObject));

			case EventTypes.MARKET_ORDER_NEW:
			case EventTypes.MARKET_ORDER_EDIT:
				return event.setObject(GenericConverterFactory.get(MarketOrder.class).convert(jsonUpdateObject));

			case EventTypes.GROUP_LEAVE:
				return event.setObject(GenericConverterFactory.get(GroupLeaveEvent.class).convert(jsonUpdateObject));

			case EventTypes.GROUP_JOIN:
				return event.setObject(GenericConverterFactory.get(GroupJoinEvent.class).convert(jsonUpdateObject));

			case EventTypes.USER_BLOCK:
				return event.setObject(GenericConverterFactory.get(UserBlockEvent.class).convert(jsonUpdateObject));

			case EventTypes.USER_UNBLOCK:
				return event.setObject(GenericConverterFactory.get(UserUnblockEvent.class).convert(jsonUpdateObject));

			case EventTypes.GROUP_CHANGE_SETTINGS:
				return event.setObject(GenericConverterFactory.get(GroupChangeSettingsEvent.class).convert(jsonUpdateObject));

			case EventTypes.GROUP_CHANGE_PHOTO:
				return event.setObject(GenericConverterFactory.get(GroupChangePhotoEvent.class).convert(jsonUpdateObject));

			case EventTypes.VKPAY_TRANSACTION:
				return event.setObject(GenericConverterFactory.get(VkpayTransaction.class).convert(jsonUpdateObject));

			case EventTypes.APP_PAYLOAD:
				return event.setObject(GenericConverterFactory.get(AppPayload.class).convert(jsonUpdateObject));

			default:
				return null;
		}
	}

	@Override
	protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
		return Event.class.equals(fieldAttributes.getDeclaringClass())
				&& EventObject.class.equals(fieldAttributes.getDeclaredClass())
				&& OBJECT_FIELD.equals(fieldAttributes.getName());
	}
}
