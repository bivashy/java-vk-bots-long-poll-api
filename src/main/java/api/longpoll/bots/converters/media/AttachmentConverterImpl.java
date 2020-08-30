package api.longpoll.bots.converters.media;

import api.longpoll.bots.constants.AttachmentTypes;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.basic.WallCommentConverterImpl;
import api.longpoll.bots.converters.basic.WallPostConverterImpl;
import api.longpoll.bots.model.objects.media.Attachable;
import api.longpoll.bots.model.objects.media.AttachedLink;
import api.longpoll.bots.model.objects.media.Attachment;
import api.longpoll.bots.model.objects.media.Audio;
import api.longpoll.bots.model.objects.media.AudioMessage;
import api.longpoll.bots.model.objects.media.Graffiti;
import api.longpoll.bots.model.objects.media.MarketCollection;
import api.longpoll.bots.model.objects.media.MarketItem;
import api.longpoll.bots.model.objects.media.Photo;
import api.longpoll.bots.model.objects.media.Sticker;
import api.longpoll.bots.model.objects.media.Video;
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
    private static final String LINK_FIELD = "link";
    private static final String MARKET_ALBUM_FIELD = "market_album";
    private static final String MARKET_FIELD = "market";

    @Override
    public Attachment convert(JsonObject source) {
        Attachment attachment = gson.fromJson(source, Attachment.class);

        switch (attachment.getType()) {
            case AttachmentTypes.PHOTO:
                attachment.setAttachable(GenericConverterFactory.get(Photo.class).convert(source.getAsJsonObject(PHOTO_FIELD)));
                break;

            case AttachmentTypes.VIDEO:
                attachment.setAttachable(GenericConverterFactory.get(Video.class).convert(source.getAsJsonObject(VIDEO_FIELD)));
                break;

            case AttachmentTypes.AUDIO:
                attachment.setAttachable(GenericConverterFactory.get(Audio.class).convert(source.getAsJsonObject(AUDIO_FIELD)));
                break;

            case AttachmentTypes.DOCUMENT:
                attachment.setAttachable(new DocConverterImpl().convert(source.getAsJsonObject(DOC_FIELD)));
                break;

            case AttachmentTypes.GRAFFITI:
                attachment.setAttachable(GenericConverterFactory.get(Graffiti.class).convert(source.getAsJsonObject(GRAFFITI_FIELD)));
                break;

            case AttachmentTypes.AUDIO_MESSAGE:
                attachment.setAttachable(GenericConverterFactory.get(AudioMessage.class).convert(source.getAsJsonObject(AUDIO_MESSAGE_FIELD)));
                break;

            case AttachmentTypes.STICKER:
                attachment.setAttachable(GenericConverterFactory.get(Sticker.class).convert(source.getAsJsonObject(STICKER_FIELD)));
                break;

            case AttachmentTypes.WALL_POST:
                attachment.setAttachable(new WallPostConverterImpl().convert(source.getAsJsonObject(WALL_FIELD)));
                break;

            case AttachmentTypes.WALL_REPLY:
                attachment.setAttachable(new WallCommentConverterImpl().convert(source.getAsJsonObject(WALL_REPLY_FIELD)));
                break;

            case AttachmentTypes.LINK:
                attachment.setAttachable(GenericConverterFactory.get(AttachedLink.class).convert(source.getAsJsonObject(LINK_FIELD)));
                break;

            case AttachmentTypes.MARKET_ALBUM:
                attachment.setAttachable(GenericConverterFactory.get(MarketCollection.class).convert(source.getAsJsonObject(MARKET_ALBUM_FIELD)));
                break;

            case AttachmentTypes.MARKET:
                attachment.setAttachable(GenericConverterFactory.get(MarketItem.class).convert(source.getAsJsonObject(MARKET_FIELD)));
                break;
        }

        return attachment;
    }

    @Override
    protected boolean shouldSkipClass(Class<?> aClass) {
        return Attachable.class.equals(aClass);
    }
}
