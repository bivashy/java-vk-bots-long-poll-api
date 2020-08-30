package api.longpoll.bots.converters;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class StringToJsonConverterImpl implements Converter<String, JsonObject> {
    @Override
    public JsonObject convert(String s) {
        return new Gson().fromJson(s, JsonObject.class);
    }
}
