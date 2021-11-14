package api.longpoll.bots.converter.impl;

import api.longpoll.bots.config.VkBotsConfig;
import api.longpoll.bots.converter.Converter;
import api.longpoll.bots.model.objects.additional.Forward;
import com.google.gson.Gson;

/**
 * Converts {@link Forward} object to JSON string.
 */
public class ForwardConverter implements Converter<Forward, String> {
    /**
     * {@link Gson} object.
     */
    private final Gson gson = VkBotsConfig.getInstance().getGson();

    @Override
    public String convert(Forward forward) {
        return gson.toJson(forward);
    }
}
