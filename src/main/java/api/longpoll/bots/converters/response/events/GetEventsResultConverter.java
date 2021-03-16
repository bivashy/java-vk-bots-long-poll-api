package api.longpoll.bots.converters.response.events;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.events.EventConverter;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.response.events.GetEventsResult;
import api.longpoll.bots.utils.converters.BulkConverterUtil;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonObject;

import java.util.List;

public class GetEventsResultConverter extends JsonToPojoConverter<GetEventsResult> {
    private static final JsonToPojoConverter<Event> EVENT_CONVERTER = new EventConverter();

    @Override
    public GetEventsResult convert(JsonObject jsonObject) {
        GetEventsResult getEventsResult = gson.fromJson(jsonObject, GetEventsResult.class);

        if (jsonObject.has("updates")) {
            getEventsResult.setEvents(BulkConverterUtil.convert(jsonObject.getAsJsonArray("updates"), EVENT_CONVERTER));
        }

        return getEventsResult;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return GetEventsResult.class.equals(fieldAttributes.getDeclaringClass())
                && List.class.equals(fieldAttributes.getDeclaredClass());
    }
}
