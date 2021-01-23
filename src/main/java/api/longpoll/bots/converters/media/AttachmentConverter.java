package api.longpoll.bots.converters.media;

import api.longpoll.bots.model.objects.media.AttachmentType;
import api.longpoll.bots.converters.CachedConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.basic.WallCommentConverter;
import api.longpoll.bots.converters.basic.WallPostConverter;
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

import java.util.HashMap;
import java.util.Map;

public class AttachmentConverter extends JsonToPojoConverter<Attachment> {
    private static final Map<AttachmentType, JsonToPojoConverter<? extends Attachable>> CONVERTERS = new HashMap<>();

    @Override
    public Attachment convert(JsonObject source) {
        Attachment attachment = gson.fromJson(source, Attachment.class);
        AttachmentType type = attachment.getType();
        attachment.setAttachable(CONVERTERS.get(type).convert(source.getAsJsonObject(type.getValue())));
        return attachment;
    }

    @Override
    protected boolean shouldSkipClass(Class<?> aClass) {
        return Attachable.class.equals(aClass);
    }

    static {
        CONVERTERS.put(AttachmentType.AUDIO, CachedConverterFactory.getConverter(Audio.class));
        CONVERTERS.put(AttachmentType.AUDIO_MESSAGE, CachedConverterFactory.getConverter(AudioMessage.class));
        CONVERTERS.put(AttachmentType.DOCUMENT, new DocConverter());
        CONVERTERS.put(AttachmentType.GRAFFITI, CachedConverterFactory.getConverter(Graffiti.class));
        CONVERTERS.put(AttachmentType.LINK, CachedConverterFactory.getConverter(AttachedLink.class));
        CONVERTERS.put(AttachmentType.MARKET, CachedConverterFactory.getConverter(MarketItem.class));
        CONVERTERS.put(AttachmentType.MARKET_ALBUM, CachedConverterFactory.getConverter(MarketCollection.class));
        CONVERTERS.put(AttachmentType.PHOTO, CachedConverterFactory.getConverter(Photo.class));
        CONVERTERS.put(AttachmentType.STICKER, CachedConverterFactory.getConverter(Sticker.class));
        CONVERTERS.put(AttachmentType.VIDEO, CachedConverterFactory.getConverter(Video.class));
        CONVERTERS.put(AttachmentType.WALL_POST, new WallPostConverter());
        CONVERTERS.put(AttachmentType.WALL_REPLY, new WallCommentConverter());
    }
}
