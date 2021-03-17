package api.longpoll.bots.converters.media;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.JsonToPojoConverterFactory;
import api.longpoll.bots.converters.basic.AttachmentHolderConverter;
import api.longpoll.bots.model.objects.basic.WallComment;
import api.longpoll.bots.model.objects.basic.WallPost;
import api.longpoll.bots.model.objects.media.*;
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
        CONVERTERS.put(AttachmentType.AUDIO, JsonToPojoConverterFactory.get(Audio.class));
        CONVERTERS.put(AttachmentType.AUDIO_MESSAGE, JsonToPojoConverterFactory.get(AudioMessage.class));
        CONVERTERS.put(AttachmentType.DOCUMENT, new DocConverter());
        CONVERTERS.put(AttachmentType.GRAFFITI, JsonToPojoConverterFactory.get(Graffiti.class));
        CONVERTERS.put(AttachmentType.LINK, JsonToPojoConverterFactory.get(AttachedLink.class));
        CONVERTERS.put(AttachmentType.MARKET, JsonToPojoConverterFactory.get(MarketItem.class));
        CONVERTERS.put(AttachmentType.MARKET_ALBUM, JsonToPojoConverterFactory.get(MarketCollection.class));
        CONVERTERS.put(AttachmentType.PHOTO, JsonToPojoConverterFactory.get(Photo.class));
        CONVERTERS.put(AttachmentType.STICKER, JsonToPojoConverterFactory.get(Sticker.class));
        CONVERTERS.put(AttachmentType.VIDEO, JsonToPojoConverterFactory.get(Video.class));
        CONVERTERS.put(AttachmentType.WALL_POST, AttachmentHolderConverter.of(WallPost.class));
        CONVERTERS.put(AttachmentType.WALL_REPLY, AttachmentHolderConverter.of(WallComment.class));
    }
}
