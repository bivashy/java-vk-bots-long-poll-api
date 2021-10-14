package api.longpoll.bots.validators;

import api.longpoll.bots.converters.json.GsonConverter;
import api.longpoll.bots.converters.json.JsonConverter;
import com.google.gson.JsonObject;

/**
 * Default implementation of VK API response validator.
 */
public class DefaultVkApiResponseValidator implements VkApiResponseValidator {
    /**
     * JSON converter.
     */
    private final JsonConverter jsonConverter;

    public DefaultVkApiResponseValidator() {
        this(new GsonConverter());
    }

    public DefaultVkApiResponseValidator(JsonConverter jsonConverter) {
        this.jsonConverter = jsonConverter;
    }

    @Override
    public boolean isValid(String json) {
        JsonObject jsonObject = jsonConverter.convert(json, JsonObject.class);
        return jsonObject != null && !jsonObject.has("error") && !jsonObject.has("failed");
    }
}
