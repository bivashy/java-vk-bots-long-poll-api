package api.longpoll.bots.validators;

import api.longpoll.bots.config.VkBotsConfig;
import api.longpoll.bots.converter.Converter;
import com.google.gson.JsonElement;

/**
 * Default implementation of VK API response validator.
 */
public class DefaultVkResponseValidator implements VkResponseValidator {
    /**
     * JSON converter.
     */
    private final Converter<String, JsonElement> jsonConverter = VkBotsConfig.getInstance().getJsonConverterFactory().get(JsonElement.class);

    @Override
    public boolean isValid(String json) {
        JsonElement jsonElement = jsonConverter.convert(json);
        return !jsonElement.isJsonObject()
                || !jsonElement.getAsJsonObject().has("error")
                && !jsonElement.getAsJsonObject().has("failed");
    }
}
