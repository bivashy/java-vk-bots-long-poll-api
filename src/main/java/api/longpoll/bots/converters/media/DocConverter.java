package api.longpoll.bots.converters.media;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.JsonToPojoConverterFactory;
import api.longpoll.bots.model.objects.media.Doc;
import api.longpoll.bots.model.objects.media.DocPreviewType;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class DocConverter extends JsonToPojoConverter<Doc> {
    private static final Map<DocPreviewType, JsonToPojoConverter<? extends Doc.Preview>> CONVERTERS = new HashMap<>();

    @Override
    public Doc convert(JsonObject jsonObject) {
        Doc doc = gson.fromJson(jsonObject, Doc.class);

        if (jsonObject.has("preview")) {
            Map<DocPreviewType, Doc.Preview> previewMap = new HashMap<>();
            for (Map.Entry<String, JsonElement> entry : jsonObject.getAsJsonObject("preview").entrySet()) {
                DocPreviewType docPreviewType = gson.fromJson(entry.getKey(), DocPreviewType.class);
                Doc.Preview preview = CONVERTERS.get(docPreviewType).convert(entry.getValue().getAsJsonObject());
                previewMap.put(docPreviewType, preview);
            }
            doc.setPreview(previewMap);
        }
        
        return doc;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return Map.class.equals(fieldAttributes.getDeclaredClass());
    }

    static {
        CONVERTERS.put(DocPreviewType.AUDIO_MSG, JsonToPojoConverterFactory.get(Doc.AudioMessage.class));
        CONVERTERS.put(DocPreviewType.GRAFFITI, JsonToPojoConverterFactory.get(Doc.Graffiti.class));
        CONVERTERS.put(DocPreviewType.PHOTO, JsonToPojoConverterFactory.get(Doc.Photo.class));
        CONVERTERS.put(DocPreviewType.VIDEO, JsonToPojoConverterFactory.get(Doc.Video.class));
    }
}
