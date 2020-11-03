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

import java.util.HashMap;
import java.util.Map;

public class AttachmentConverterImpl extends JsonToPojoConverter<Attachment> {
    private static final Map<String, JsonToPojoConverter<? extends Attachable>> CONVERTERS = new HashMap<>();

    static {
        CONVERTERS.put(AttachmentTypes.AUDIO, GenericConverterFactory.get(Audio.class));
        CONVERTERS.put(AttachmentTypes.AUDIO_MESSAGE, GenericConverterFactory.get(AudioMessage.class));
        CONVERTERS.put(AttachmentTypes.DOCUMENT, new DocConverterImpl());
        CONVERTERS.put(AttachmentTypes.GRAFFITI, GenericConverterFactory.get(Graffiti.class));
        CONVERTERS.put(AttachmentTypes.LINK, GenericConverterFactory.get(AttachedLink.class));
        CONVERTERS.put(AttachmentTypes.MARKET, GenericConverterFactory.get(MarketItem.class));
        CONVERTERS.put(AttachmentTypes.MARKET_ALBUM, GenericConverterFactory.get(MarketCollection.class));
        CONVERTERS.put(AttachmentTypes.PHOTO, GenericConverterFactory.get(Photo.class));
        CONVERTERS.put(AttachmentTypes.STICKER, GenericConverterFactory.get(Sticker.class));
        CONVERTERS.put(AttachmentTypes.VIDEO, GenericConverterFactory.get(Video.class));
        CONVERTERS.put(AttachmentTypes.WALL_POST, new WallPostConverterImpl());
        CONVERTERS.put(AttachmentTypes.WALL_REPLY, new WallCommentConverterImpl());
    }

    @Override
    public Attachment convert(JsonObject source) {
        Attachment attachment = gson.fromJson(source, Attachment.class);
        String type = attachment.getType();
        attachment.setAttachable(CONVERTERS.get(type).convert(source.getAsJsonObject(type)));
        return attachment;
    }

    @Override
    protected boolean shouldSkipClass(Class<?> aClass) {
        return Attachable.class.equals(aClass);
    }
}
