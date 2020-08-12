package api.longpoll.bots.converters.updates;

import api.longpoll.bots.constants.UpdateTypes;
import api.longpoll.bots.converters.board.BoardPostDeleteUpdateConverterImpl;
import api.longpoll.bots.converters.board.BoardPostUpdateConverterImpl;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.audio.AudioConverterImpl;
import api.longpoll.bots.converters.likes.LikeUpdateConverterImpl;
import api.longpoll.bots.converters.market.MarketCommentDeleteUpdateConverterImpl;
import api.longpoll.bots.converters.market.MarketCommentUpdateConverterImpl;
import api.longpoll.bots.converters.market.MarketOrderConverterImpl;
import api.longpoll.bots.converters.messages.MessageConverterImpl;
import api.longpoll.bots.converters.messages.MessageUpdateConverterImpl;
import api.longpoll.bots.converters.other.AppPayloadConverterImpl;
import api.longpoll.bots.converters.other.GroupChangePhotoUpdateConverterImpl;
import api.longpoll.bots.converters.other.GroupChangeSettingsUpdateConverterImpl;
import api.longpoll.bots.converters.other.VkpayTransactionConverterImpl;
import api.longpoll.bots.converters.photo.PhotoCommentDeleteUpdateConverterImpl;
import api.longpoll.bots.converters.photo.PhotoCommentUpdateConverterImpl;
import api.longpoll.bots.converters.photo.PhotoConverterImpl;
import api.longpoll.bots.converters.users.GroupJoinUpdateConverterImpl;
import api.longpoll.bots.converters.users.GroupLeaveUpdateConverterImpl;
import api.longpoll.bots.converters.users.UserBlockUpdateConverterImpl;
import api.longpoll.bots.converters.users.UserUnblockUpdateConverterImpl;
import api.longpoll.bots.converters.video.VideoCommentDeleteUpdateConverterImpl;
import api.longpoll.bots.converters.video.VideoCommentUpdateConverterImpl;
import api.longpoll.bots.converters.video.VideoConverterImpl;
import api.longpoll.bots.converters.wall.post.WallPostConverterImpl;
import api.longpoll.bots.converters.wall.reply.WallReplyDeleteUpdateConverterImpl;
import api.longpoll.bots.converters.wall.reply.WallReplyUpdateConverterImpl;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.UnimplementedEventObject;
import api.longpoll.bots.model.events.EventObject;
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
				return event.setObject(new PhotoConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.PHOTO_COMMENT_NEW:
			case UpdateTypes.PHOTO_COMMENT_EDIT:
			case UpdateTypes.PHOTO_COMMENT_RESTORE:
				return event.setObject(new PhotoCommentUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.PHOTO_COMMENT_DELETE:
				return event.setObject(new PhotoCommentDeleteUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.AUDIO_NEW:
				return event.setObject(new AudioConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.VIDEO_NEW:
				return event.setObject(new VideoConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.VIDEO_COMMENT_NEW:
			case UpdateTypes.VIDEO_COMMENT_EDIT:
			case UpdateTypes.VIDEO_COMMENT_RESTORE:
				return event.setObject(new VideoCommentUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.VIDEO_COMMENT_DELETE:
				return event.setObject(new VideoCommentDeleteUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.WALL_POST_NEW:
			case UpdateTypes.WALL_REPOST:
				return event.setObject(new WallPostConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.LIKE_ADD:
			case UpdateTypes.LIKE_REMOVE:
				return event.setObject(new LikeUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.WALL_REPLY_NEW:
			case UpdateTypes.WALL_REPLY_EDIT:
			case UpdateTypes.WALL_REPLY_RESTORE:
				return event.setObject(new WallReplyUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.WALL_REPLY_DELETE:
				return event.setObject(new WallReplyDeleteUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.BOARD_POST_NEW:
			case UpdateTypes.BOARD_POST_EDIT:
			case UpdateTypes.BOARD_POST_RESTORE:
				return event.setObject(new BoardPostUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.BOARD_POST_DELETE:
				return event.setObject(new BoardPostDeleteUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.MARKET_COMMENT_NEW:
			case UpdateTypes.MARKET_COMMENT_EDIT:
			case UpdateTypes.MARKET_COMMENT_RESTORE:
				return event.setObject(new MarketCommentUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.MARKET_COMMENT_DELETE:
				return event.setObject(new MarketCommentDeleteUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.MARKET_ORDER_NEW:
			case UpdateTypes.MARKET_ORDER_EDIT:
				return event.setObject(new MarketOrderConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.GROUP_LEAVE:
				return event.setObject(new GroupLeaveUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.GROUP_JOIN:
				return event.setObject(new GroupJoinUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.USER_BLOCK:
				return event.setObject(new UserBlockUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.USER_UNBLOCK:
				return event.setObject(new UserUnblockUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.GROUP_CHANGE_SETTINGS:
				return event.setObject(new GroupChangeSettingsUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.GROUP_CHANGE_PHOTO:
				return event.setObject(new GroupChangePhotoUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.VKPAY_TRANSACTION:
				return event.setObject(new VkpayTransactionConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.APP_PAYLOAD:
				return event.setObject(new AppPayloadConverterImpl().convert(jsonUpdateObject));

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
