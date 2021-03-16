package api.longpoll.bots.converters.media;

import api.longpoll.bots.converters.CachedConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.objects.media.Doc;
import api.longpoll.bots.model.objects.media.DocPreviewType;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DocConverter extends JsonToPojoConverter<Doc> {
    private static final Map<DocPreviewType, JsonToPojoConverter<? extends Doc.Preview>> CONVERTERS = new HashMap<>();

    @Override
    public Doc convert(JsonObject jsonObject) {
        Doc doc = gson.fromJson(jsonObject, Doc.class);
        // TODO: 15.03.2021 make it beautiful
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

    private DocPreviewType convertKeyToDocType(Map.Entry<String, JsonElement> entry) {
        return gson.fromJson(entry.getKey(), DocPreviewType.class);
    }

    private Doc.Preview convertValueToDocPreview(Map.Entry<String, JsonElement> entry) {
        return CONVERTERS.get(convertKeyToDocType(entry)).convert(entry.getValue().getAsJsonObject());
    }

    static {
        CONVERTERS.put(DocPreviewType.AUDIO_MSG, CachedConverterFactory.getConverter(Doc.AudioMessage.class));
        CONVERTERS.put(DocPreviewType.GRAFFITI, CachedConverterFactory.getConverter(Doc.Graffiti.class));
        CONVERTERS.put(DocPreviewType.PHOTO, CachedConverterFactory.getConverter(Doc.Photo.class));
        CONVERTERS.put(DocPreviewType.VIDEO, CachedConverterFactory.getConverter(Doc.Video.class));
    }
}
