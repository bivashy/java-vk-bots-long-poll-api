package api.longpoll.bots.converters;

import com.google.gson.JsonObject;

public class StringToJsonConverter extends AbstractConverter<String, JsonObject> {
    @Override
    public JsonObject convert(String s) {
        return gson.fromJson(s, JsonObject.class);
    }
}
