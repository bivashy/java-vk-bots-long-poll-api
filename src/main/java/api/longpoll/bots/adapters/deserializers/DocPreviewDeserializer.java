package api.longpoll.bots.adapters.deserializers;

import api.longpoll.bots.model.objects.media.Doc;
import api.longpoll.bots.model.objects.media.DocPreviewType;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Deserializes JSON objects to {@link Doc} preview.
 */
public class DocPreviewDeserializer implements JsonDeserializer<Map<DocPreviewType, Doc.Preview>> {
    @Override
    public final Map<DocPreviewType, Doc.Preview> deserialize(JsonElement jsonPreview, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Map<DocPreviewType, Doc.Preview> docPreview = new HashMap<>();
        for (Map.Entry<String, JsonElement> entry : jsonPreview.getAsJsonObject().entrySet()) {
            DocPreviewType docPreviewType = jsonDeserializationContext.deserialize(
                    new JsonPrimitive(entry.getKey()),
                    DocPreviewType.class
            );
            docPreview.put(
                    docPreviewType,
                    jsonDeserializationContext.deserialize(
                            entry.getValue(),
                            getType(docPreviewType)
                    )
            );
        }
        return docPreview;
    }

    private Type getType(DocPreviewType docPreviewType) {
        switch (docPreviewType) {
            case AUDIO_MSG:
                return Doc.AudioMessage.class;

            case GRAFFITI:
                return Doc.Graffiti.class;

            case PHOTO:
                return Doc.Photo.class;

            case VIDEO:
            default:
                return Doc.Video.class;
        }
    }
}
