package bots.longpoll.sdk.converters.updates;

import bots.longpoll.sdk.constants.UpdateTypes;
import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.converters.audio.AudioConverterImpl;
import bots.longpoll.sdk.converters.board.BoardPostDeleteUpdateConverterImpl;
import bots.longpoll.sdk.converters.board.BoardPostUpdateConverterImpl;
import bots.longpoll.sdk.converters.likes.LikeUpdateConverterImpl;
import bots.longpoll.sdk.converters.market.MarketCommentDeleteUpdateConverterImpl;
import bots.longpoll.sdk.converters.market.MarketCommentUpdateConverterImpl;
import bots.longpoll.sdk.converters.market.MarketOrderConverterImpl;
import bots.longpoll.sdk.converters.messages.MessageConverterImpl;
import bots.longpoll.sdk.converters.messages.MessageUpdateConverterImpl;
import bots.longpoll.sdk.converters.other.AppPayloadConverterImpl;
import bots.longpoll.sdk.converters.other.GroupChangePhotoUpdateConverterImpl;
import bots.longpoll.sdk.converters.other.GroupChangeSettingsUpdateConverterImpl;
import bots.longpoll.sdk.converters.other.VkpayTransactionConverterImpl;
import bots.longpoll.sdk.converters.photo.PhotoCommentDeleteUpdateConverterImpl;
import bots.longpoll.sdk.converters.photo.PhotoCommentUpdateConverterImpl;
import bots.longpoll.sdk.converters.photo.PhotoConverterImpl;
import bots.longpoll.sdk.converters.users.GroupJoinUpdateConverterImpl;
import bots.longpoll.sdk.converters.users.GroupLeaveUpdateConverterImpl;
import bots.longpoll.sdk.converters.users.UserBlockUpdateConverterImpl;
import bots.longpoll.sdk.converters.users.UserUnblockUpdateConverterImpl;
import bots.longpoll.sdk.converters.video.VideoCommentDeleteUpdateConverterImpl;
import bots.longpoll.sdk.converters.video.VideoCommentUpdateConverterImpl;
import bots.longpoll.sdk.converters.video.VideoConverterImpl;
import bots.longpoll.sdk.converters.wall.post.WallPostConverterImpl;
import bots.longpoll.sdk.converters.wall.reply.WallReplyDeleteUpdateConverterImpl;
import bots.longpoll.sdk.converters.wall.reply.WallReplyUpdateConverterImpl;
import bots.longpoll.sdk.model.audio.Audio;
import bots.longpoll.sdk.model.update.UnimplementedUpdateObject;
import bots.longpoll.sdk.model.update.Update;
import bots.longpoll.sdk.model.update.UpdateObject;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonObject;

public class UpdateConverterImpl extends JsonToPojoConverter<Update> {
	private static final String TYPE_FIELD = "type";
	private static final String OBJECT_FIELD = "object";
	private static final String GROUP_ID_FIELD = "group_id";
	private static final String EVENT_ID_FIELD = "event_id";

	@Override
	public Update convert(JsonObject jsonObject) {
		Update update = gson.fromJson(jsonObject, Update.class);

		JsonObject jsonUpdateObject = jsonObject.getAsJsonObject(OBJECT_FIELD);

		switch (update.getType()) {
			case UpdateTypes.MESSAGE_NEW:
				return update.setObject(new MessageUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.MESSAGE_REPLY:
			case UpdateTypes.MESSAGE_EDIT:
				return update.setObject(new MessageConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.PHOTO_NEW:
				return update.setObject(new PhotoConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.PHOTO_COMMENT_NEW:
			case UpdateTypes.PHOTO_COMMENT_EDIT:
			case UpdateTypes.PHOTO_COMMENT_RESTORE:
				return update.setObject(new PhotoCommentUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.PHOTO_COMMENT_DELETE:
				return update.setObject(new PhotoCommentDeleteUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.AUDIO_NEW:
				return update.setObject(new AudioConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.VIDEO_NEW:
				return update.setObject(new VideoConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.VIDEO_COMMENT_NEW:
			case UpdateTypes.VIDEO_COMMENT_EDIT:
			case UpdateTypes.VIDEO_COMMENT_RESTORE:
				return update.setObject(new VideoCommentUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.VIDEO_COMMENT_DELETE:
				return update.setObject(new VideoCommentDeleteUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.WALL_POST_NEW:
			case UpdateTypes.WALL_REPOST:
				return update.setObject(new WallPostConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.LIKE_ADD:
			case UpdateTypes.LIKE_REMOVE:
				return update.setObject(new LikeUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.WALL_REPLY_NEW:
			case UpdateTypes.WALL_REPLY_EDIT:
			case UpdateTypes.WALL_REPLY_RESTORE:
				return update.setObject(new WallReplyUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.WALL_REPLY_DELETE:
				return update.setObject(new WallReplyDeleteUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.BOARD_POST_NEW:
			case UpdateTypes.BOARD_POST_EDIT:
			case UpdateTypes.BOARD_POST_RESTORE:
				return update.setObject(new BoardPostUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.BOARD_POST_DELETE:
				return update.setObject(new BoardPostDeleteUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.MARKET_COMMENT_NEW:
			case UpdateTypes.MARKET_COMMENT_EDIT:
			case UpdateTypes.MARKET_COMMENT_RESTORE:
				return update.setObject(new MarketCommentUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.MARKET_COMMENT_DELETE:
				return update.setObject(new MarketCommentDeleteUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.MARKET_ORDER_NEW:
			case UpdateTypes.MARKET_ORDER_EDIT:
				return update.setObject(new MarketOrderConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.GROUP_LEAVE:
				return update.setObject(new GroupLeaveUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.GROUP_JOIN:
				return update.setObject(new GroupJoinUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.USER_BLOCK:
				return update.setObject(new UserBlockUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.USER_UNBLOCK:
				return update.setObject(new UserUnblockUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.GROUP_CHANGE_SETTINGS:
				return update.setObject(new GroupChangeSettingsUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.GROUP_CHANGE_PHOTO:
				return update.setObject(new GroupChangePhotoUpdateConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.VKPAY_TRANSACTION:
				return update.setObject(new VkpayTransactionConverterImpl().convert(jsonUpdateObject));

			case UpdateTypes.APP_PAYLOAD:
				return update.setObject(new AppPayloadConverterImpl().convert(jsonUpdateObject));

			default:
				return update.setObject(new UnimplementedUpdateObject().setJsonObject(jsonUpdateObject));
		}
	}

	@Override
	protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
		return Update.class.equals(fieldAttributes.getDeclaringClass())
				&& UpdateObject.class.equals(fieldAttributes.getDeclaredClass())
				&& OBJECT_FIELD.equals(fieldAttributes.getName());
	}
}
