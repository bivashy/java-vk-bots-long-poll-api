package api.longpoll.bots.converters.updates;

import api.longpoll.bots.constants.UpdateTypes;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.messages.MessageConverterImpl;
import api.longpoll.bots.converters.messages.MessageUpdateConverterImpl;
import api.longpoll.bots.converters.photo.PhotoCommentUpdateConverterImpl;
import api.longpoll.bots.converters.video.VideoCommentUpdateConverterImpl;
import api.longpoll.bots.converters.wall.post.WallPostConverterImpl;
import api.longpoll.bots.model.audio.Audio;
import api.longpoll.bots.model.board.BoardPostDeleteEvent;
import api.longpoll.bots.model.board.BoardPostEvent;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.events.UnimplementedEventObject;
import api.longpoll.bots.model.likes.LikeEvent;
import api.longpoll.bots.model.market.item.MarketCommentDeleteEvent;
import api.longpoll.bots.model.market.item.MarketCommentEvent;
import api.longpoll.bots.model.market.order.MarketOrder;
import api.longpoll.bots.model.other.AppPayload;
import api.longpoll.bots.model.other.GroupChangePhotoEvent;
import api.longpoll.bots.model.other.GroupChangeSettingsEvent;
import api.longpoll.bots.model.other.VkpayTransaction;
import api.longpoll.bots.model.photos.Photo;
import api.longpoll.bots.model.photos.PhotoCommentDeleteEvent;
import api.longpoll.bots.model.users.GroupJoinEvent;
import api.longpoll.bots.model.users.GroupLeaveEvent;
import api.longpoll.bots.model.users.UserBlockEvent;
import api.longpoll.bots.model.users.UserUnblockEvent;
import api.longpoll.bots.model.video.Video;
import api.longpoll.bots.model.video.VideoCommentDeleteEvent;
import api.longpoll.bots.model.wall.reply.WallReplyDeleteEvent;
import api.longpoll.bots.model.wall.reply.WallReplyEvent;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonObject;

public class UpdateConverterImpl extends JsonToPojoConverter<Event> {
	private static final String TYPE_FIELD = "type";
	private static final String OBJECT_FIELD = "object";
	private static final String GROUP_ID_FIELD = "group_id";
	private static final String EVENT_ID_FIELD = "event_id";

	@Override
	public Event convert(JsonObject jsonObject) {
		Event event = gson.fromJson(jsonObject, Event.class);

		JsonObject jsonUpdateObject = jsonObject.getAsJsonObject(OBJECT_FIELD);

		switch (event.getType()) {
			case UpdateTypes.MESSAGE_NEW:
				return event.setObject(new MessageUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.MESSAGE_REPLY:
			case UpdateTypes.MESSAGE_EDIT:
				return event.setObject(new MessageConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.PHOTO_NEW:
				return event.setObject(GenericConverterFactory.get(Photo.class).convert(jsonUpdateObject));

			case UpdateTypes.PHOTO_COMMENT_NEW:
			case UpdateTypes.PHOTO_COMMENT_EDIT:
			case UpdateTypes.PHOTO_COMMENT_RESTORE:
				return event.setObject(new PhotoCommentUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.PHOTO_COMMENT_DELETE:
				return event.setObject(GenericConverterFactory.get(PhotoCommentDeleteEvent.class).convert(jsonUpdateObject));

			case UpdateTypes.AUDIO_NEW:
				return event.setObject(GenericConverterFactory.get(Audio.class).convert(jsonUpdateObject));

			case UpdateTypes.VIDEO_NEW:
				return event.setObject(GenericConverterFactory.get(Video.class).convert(jsonUpdateObject));

			case UpdateTypes.VIDEO_COMMENT_NEW:
			case UpdateTypes.VIDEO_COMMENT_EDIT:
			case UpdateTypes.VIDEO_COMMENT_RESTORE:
				return event.setObject(new VideoCommentUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.VIDEO_COMMENT_DELETE:
				return event.setObject(GenericConverterFactory.get(VideoCommentDeleteEvent.class).convert(jsonUpdateObject));

			case UpdateTypes.WALL_POST_NEW:
			case UpdateTypes.WALL_REPOST:
				return event.setObject(new WallPostConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.LIKE_ADD:
			case UpdateTypes.LIKE_REMOVE:
				return event.setObject(GenericConverterFactory.get(LikeEvent.class).convert(jsonUpdateObject));

			case UpdateTypes.WALL_REPLY_NEW:
			case UpdateTypes.WALL_REPLY_EDIT:
			case UpdateTypes.WALL_REPLY_RESTORE:
				return event.setObject(GenericConverterFactory.get(WallReplyEvent.class).convert(jsonUpdateObject));

			case UpdateTypes.WALL_REPLY_DELETE:
				return event.setObject(GenericConverterFactory.get(WallReplyDeleteEvent.class).convert(jsonUpdateObject));

			case UpdateTypes.BOARD_POST_NEW:
			case UpdateTypes.BOARD_POST_EDIT:
			case UpdateTypes.BOARD_POST_RESTORE:
				return event.setObject(GenericConverterFactory.get(BoardPostEvent.class).convert(jsonUpdateObject));

			case UpdateTypes.BOARD_POST_DELETE:
				return event.setObject(GenericConverterFactory.get(BoardPostDeleteEvent.class).convert(jsonUpdateObject));

			case UpdateTypes.MARKET_COMMENT_NEW:
			case UpdateTypes.MARKET_COMMENT_EDIT:
			case UpdateTypes.MARKET_COMMENT_RESTORE:
				return event.setObject(GenericConverterFactory.get(MarketCommentEvent.class).convert(jsonUpdateObject));

			case UpdateTypes.MARKET_COMMENT_DELETE:
				return event.setObject(GenericConverterFactory.get(MarketCommentDeleteEvent.class).convert(jsonUpdateObject));

			case UpdateTypes.MARKET_ORDER_NEW:
			case UpdateTypes.MARKET_ORDER_EDIT:
				return event.setObject(GenericConverterFactory.get(MarketOrder.class).convert(jsonUpdateObject));

			case UpdateTypes.GROUP_LEAVE:
				return event.setObject(GenericConverterFactory.get(GroupLeaveEvent.class).convert(jsonUpdateObject));

			case UpdateTypes.GROUP_JOIN:
				return event.setObject(GenericConverterFactory.get(GroupJoinEvent.class).convert(jsonUpdateObject));

			case UpdateTypes.USER_BLOCK:
				return event.setObject(GenericConverterFactory.get(UserBlockEvent.class).convert(jsonUpdateObject));

			case UpdateTypes.USER_UNBLOCK:
				return event.setObject(GenericConverterFactory.get(UserUnblockEvent.class).convert(jsonUpdateObject));

			case UpdateTypes.GROUP_CHANGE_SETTINGS:
				return event.setObject(GenericConverterFactory.get(GroupChangeSettingsEvent.class).convert(jsonUpdateObject));

			case UpdateTypes.GROUP_CHANGE_PHOTO:
				return event.setObject(GenericConverterFactory.get(GroupChangePhotoEvent.class).convert(jsonUpdateObject));

			case UpdateTypes.VKPAY_TRANSACTION:
				return event.setObject(GenericConverterFactory.get(VkpayTransaction.class).convert(jsonUpdateObject));

			case UpdateTypes.APP_PAYLOAD:
				return event.setObject(GenericConverterFactory.get(AppPayload.class).convert(jsonUpdateObject));

			default:
				return event.setObject(new UnimplementedEventObject().setJsonObject(jsonUpdateObject));
		}
	}

	@Override
	protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
		return Event.class.equals(fieldAttributes.getDeclaringClass())
				&& EventObject.class.equals(fieldAttributes.getDeclaredClass())
				&& OBJECT_FIELD.equals(fieldAttributes.getName());
	}
}
