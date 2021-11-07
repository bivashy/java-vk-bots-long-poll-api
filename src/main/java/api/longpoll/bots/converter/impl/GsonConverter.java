package api.longpoll.bots.converter.impl;

import api.longpoll.bots.config.VkBotsConfig;
import api.longpoll.bots.converter.Converter;
import com.google.gson.Gson;

/**
 * Converts JSON to POJO. Implementation is based on {@link Gson}.
 *
 * @param <T> type of POJO.
 */
public class GsonConverter<T> implements Converter<String, T> {
    /**
     * POJO type.
     */
    private final Class<T> clazz;

    /**
     * {@link Gson} object.
     */
    private final Gson gson = VkBotsConfig.getInstance().getGson();

    public GsonConverter(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T convert(String json) {
        return gson.fromJson(json, clazz);
    }
}
