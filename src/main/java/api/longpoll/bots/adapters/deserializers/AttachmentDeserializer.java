package api.longpoll.bots.adapters.deserializers;

import api.longpoll.bots.model.objects.basic.Poll;
import api.longpoll.bots.model.objects.basic.WallComment;
import api.longpoll.bots.model.objects.basic.WallPost;
import api.longpoll.bots.model.objects.media.AttachedLink;
import api.longpoll.bots.model.objects.media.Attachment;
import api.longpoll.bots.model.objects.media.AttachmentType;
import api.longpoll.bots.model.objects.media.Audio;
import api.longpoll.bots.model.objects.media.AudioMessage;
import api.longpoll.bots.model.objects.media.Doc;
import api.longpoll.bots.model.objects.media.Graffiti;
import api.longpoll.bots.model.objects.media.MarketCollection;
import api.longpoll.bots.model.objects.media.MarketItem;
import api.longpoll.bots.model.objects.media.Photo;
import api.longpoll.bots.model.objects.media.Sticker;
import api.longpoll.bots.model.objects.media.Video;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Deserializes JSON object to {@link Attachment}.
 */
public class AttachmentDeserializer implements JsonDeserializer<Attachment> {
    @Override
    public final Attachment deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonAttachment = jsonElement.getAsJsonObject();
        JsonElement jsonAttachmentType = jsonAttachment.get("type");

        AttachmentType attachmentType = jsonDeserializationContext.deserialize(
                jsonAttachmentType,
                AttachmentType.class
        );

        Attachment attachment = new Attachment();
        attachment.setType(attachmentType);
        attachment.setAttachable(jsonDeserializationContext.deserialize(
                jsonAttachment.get(jsonAttachmentType.getAsString()),
                getType(attachmentType)
        ));

        return attachment;
    }

    private Type getType(AttachmentType attachmentType) {
        switch (attachmentType) {
            case AUDIO:
                return Audio.class;

            case AUDIO_MESSAGE:
                return AudioMessage.class;

            case DOCUMENT:
                return Doc.class;

            case GRAFFITI:
                return Graffiti.class;

            case LINK:
                return AttachedLink.class;

            case MARKET:
                return MarketItem.class;

            case MARKET_ALBUM:
                return MarketCollection.class;

            case PHOTO:
                return Photo.class;

            case POLL:
                return Poll.class;

            case STICKER:
                return Sticker.class;

            case VIDEO:
                return Video.class;

            case WALL_POST:
                return WallPost.class;

            case WALL_REPLY:
            default:
                return WallComment.class;
        }
    }
}
