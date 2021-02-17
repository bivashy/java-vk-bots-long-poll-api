package api.longpoll.bots.converters.response.events;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.events.EventConverter;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.response.events.GetEventsResult;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class GetEventsResultConverter extends JsonToPojoConverter<GetEventsResult> {
    private static final JsonToPojoConverter<Event> EVENT_CONVERTER = new EventConverter();

    @Override
    public GetEventsResult convert(JsonObject jsonObject) {
        GetEventsResult getEventsResult = gson.fromJson(jsonObject, GetEventsResult.class);

        if (jsonObject.has("updates")) {
            JsonArray updates = jsonObject.getAsJsonArray("updates");
            List<Event> eventList = new ArrayList<>(updates.size());
            updates.forEach(update -> eventList.add(EVENT_CONVERTER.convert(update.getAsJsonObject())));
            getEventsResult.setEvents(eventList);
        }

        return getEventsResult;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return GetEventsResult.class.equals(fieldAttributes.getDeclaringClass())
                && List.class.equals(fieldAttributes.getDeclaredClass());
    }
}
