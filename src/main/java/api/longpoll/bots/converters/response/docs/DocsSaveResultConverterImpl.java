package api.longpoll.bots.converters.response.docs;

import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.media.DocConverterImpl;
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

public class DocsSaveResultConverterImpl extends JsonToPojoConverter<GenericResult<DocsSaveResponse>> {
    private static final String RESPONSE_FIELD = "response";
    private static final String DOC_FIELD = "doc";
    private static final String GRAFFITI_FIELD = "graffiti";
    private static final String AUDIO_MESSAGE_FIELD = "audio_message";

    private static final Map<String, JsonToPojoConverter<? extends Attachable>> CONVERTERS = new HashMap<>();

    static {
        CONVERTERS.put(AUDIO_MESSAGE_FIELD, GenericConverterFactory.get(AudioMessage.class));
        CONVERTERS.put(DOC_FIELD, new DocConverterImpl());
        CONVERTERS.put(GRAFFITI_FIELD, GenericConverterFactory.get(Graffiti.class));
    }

    @Override
    public GenericResult<DocsSaveResponse> convert(JsonObject jsonObject) {
        GenericResult<DocsSaveResponse> docsSaveResponse = gson.fromJson(jsonObject, new TypeToken<GenericResult<DocsSaveResponse>>() {}.getType());

        DocsSaveResponse response = docsSaveResponse.getResponse();
        String type = response.getType();
        JsonObject jsonResponse = jsonObject.getAsJsonObject(RESPONSE_FIELD);
        Attachable attachable = CONVERTERS.get(type).convert(jsonResponse.getAsJsonObject(type));

        response.setAttachable(attachable);
        return docsSaveResponse;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return Attachable.class.equals(fieldAttributes.getDeclaredClass());
    }
}
