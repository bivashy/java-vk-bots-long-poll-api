package api.longpoll.bots.converter;

import com.google.gson.Gson;

/**
 * Default JSON converter implementation.
 */
public class GsonConverter implements JsonConverter {
    /**
     * Gson object.
     */
    private Gson gson;

    public GsonConverter() {
        this(new Gson());
    }

    public GsonConverter(Gson gson) {
        this.gson = gson;
    }

    @Override
    public <T> T convert(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }
}
