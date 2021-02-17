package api.longpoll.bots.converters.response.docs;

import api.longpoll.bots.converters.CachedConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.media.DocConverter;
import api.longpoll.bots.model.objects.media.Attachable;
import api.longpoll.bots.model.objects.media.AudioMessage;
import api.longpoll.bots.model.objects.media.Graffiti;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.docs.DocsSaveResponse;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

public class DocsSaveResultConverter extends JsonToPojoConverter<GenericResult<DocsSaveResponse>> {
    private static final Map<String, JsonToPojoConverter<? extends Attachable>> CONVERTERS = new HashMap<>();

    @Override
    public GenericResult<DocsSaveResponse> convert(JsonObject jsonObject) {
        GenericResult<DocsSaveResponse> docsSaveResponse = gson.fromJson(jsonObject, new TypeToken<GenericResult<DocsSaveResponse>>() {}.getType());
        DocsSaveResponse response = docsSaveResponse.getResponse();
        String type = response.getType();
        JsonObject jsonResponse = jsonObject.getAsJsonObject("response");
        Attachable attachable = CONVERTERS.get(type).convert(jsonResponse.getAsJsonObject(type));

        response.setAttachable(attachable);
        return docsSaveResponse;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return Attachable.class.equals(fieldAttributes.getDeclaredClass());
    }

    static {
        CONVERTERS.put("audio_message", CachedConverterFactory.getConverter(AudioMessage.class));
        CONVERTERS.put("doc", new DocConverter());
        CONVERTERS.put("graffiti", CachedConverterFactory.getConverter(Graffiti.class));
    }
}
