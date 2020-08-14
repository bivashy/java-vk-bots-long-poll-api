package api.longpoll.bots.converters.media;

import api.longpoll.bots.constants.AttachmentTypes;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.basic.WallCommentConverterImpl;
import api.longpoll.bots.converters.basic.WallPostConverterImpl;
import api.longpoll.bots.model.objects.media.Attachable;
import api.longpoll.bots.model.objects.media.Attachment;
import api.longpoll.bots.model.audio.Audio;
import api.longpoll.bots.model.audio.message.AudioMessage;
import api.longpoll.bots.model.graffiti.Graffiti;
import api.longpoll.bots.model.photos.Photo;
import api.longpoll.bots.model.sticker.Sticker;
import api.longpoll.bots.model.video.Video;
import com.google.gson.JsonObject;

public class AttachmentConverterImpl extends JsonToPojoConverter<Attachment> {
	private static final String PHOTO_FIELD = "photo";
	private static final String VIDEO_FIELD = "video";
	private static final String AUDIO_FIELD = "audio";
	private static final String DOC_FIELD = "doc";
	private static final String GRAFFITI_FIELD = "graffiti";
	private static final String AUDIO_MESSAGE_FIELD = "audio_message";
	private static final String STICKER_FIELD = "sticker";
	private static final String WALL_FIELD = "wall";
	private static final String WALL_REPLY_FIELD = "wall_reply";

	@Override
	public Attachment convert(JsonObject source) {
		Attachment attachment = gson.fromJson(source, Attachment.class);

		switch (attachment.getType()) {
			case AttachmentTypes.PHOTO:
				return attachment.setAttachable(GenericConverterFactory.get(Photo.class).convert(source.getAsJsonObject(PHOTO_FIELD)));

			case AttachmentTypes.VIDEO:
				return attachment.setAttachable(GenericConverterFactory.get(Video.class).convert(source.getAsJsonObject(VIDEO_FIELD)));

			case AttachmentTypes.AUDIO:
				return attachment.setAttachable(GenericConverterFactory.get(Audio.class).convert(source.getAsJsonObject(AUDIO_FIELD)));

			case AttachmentTypes.DOCUMENT:
				return attachment.setAttachable(new DocConverterImpl().convert(source.getAsJsonObject(DOC_FIELD)));

			case AttachmentTypes.GRAFFITI:
				return attachment.setAttachable(GenericConverterFactory.get(Graffiti.class).convert(source.getAsJsonObject(GRAFFITI_FIELD)));

			case AttachmentTypes.AUDIO_MESSAGE:
				return attachment.setAttachable(GenericConverterFactory.get(AudioMessage.class).convert(source.getAsJsonObject(AUDIO_MESSAGE_FIELD)));

			case AttachmentTypes.STICKER:
				return attachment.setAttachable(GenericConverterFactory.get(Sticker.class).convert(source.getAsJsonObject(STICKER_FIELD)));

			case AttachmentTypes.WALL_POST:
				return attachment.setAttachable(new WallPostConverterImpl().convert(source.getAsJsonObject(WALL_FIELD)));

			case AttachmentTypes.WALL_REPLY:
				return attachment.setAttachable(new WallCommentConverterImpl().convert(source.getAsJsonObject(WALL_REPLY_FIELD)));

			default:
				return null;
		}
	}

	@Override
	protected boolean shouldSkipClass(Class<?> aClass) {
		return Attachable.class.equals(aClass);
	}
}
