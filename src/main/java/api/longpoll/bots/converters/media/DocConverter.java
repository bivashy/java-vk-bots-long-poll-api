package api.longpoll.bots.converters.media;

import api.longpoll.bots.converters.CachedConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.objects.media.Doc;
import api.longpoll.bots.model.objects.media.DocType;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DocConverter extends JsonToPojoConverter<Doc> {
    private static final Map<DocType, JsonToPojoConverter<? extends Doc.Preview>> CONVERTERS = new HashMap<>();

    @Override
    public Doc convert(JsonObject jsonObject) {
        Doc doc = gson.fromJson(jsonObject, Doc.class);
        if (jsonObject.has("preview")) {
            doc.setPreview(
                    jsonObject.getAsJsonObject("preview")
                            .entrySet()
                            .stream()
                            .collect(Collectors.toMap(this::convertKeyToDocType, this::convertValueToDocPreview))
            );
        }
        return doc;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return Map.class.equals(fieldAttributes.getDeclaredClass());
    }

    private DocType convertKeyToDocType(Map.Entry<String, JsonElement> entry) {
        return gson.fromJson(entry.getKey(), DocType.class);
    }

    private Doc.Preview convertValueToDocPreview(Map.Entry<String, JsonElement> entry) {
        return CONVERTERS.get(convertKeyToDocType(entry)).convert(entry.getValue().getAsJsonObject());
    }

    static {
        CONVERTERS.put(DocType.AUDIO_MSG, CachedConverterFactory.getConverter(Doc.AudioMessage.class));
        CONVERTERS.put(DocType.GRAFFITI, CachedConverterFactory.getConverter(Doc.Graffiti.class));
        CONVERTERS.put(DocType.PHOTO, CachedConverterFactory.getConverter(Doc.Photo.class));
        CONVERTERS.put(DocType.VIDEO, CachedConverterFactory.getConverter(Doc.Video.class));
    }
}
