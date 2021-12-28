package api.longpoll.bots.validator;

import com.google.gson.JsonElement;

/**
 * Default implementation of VK API response validator.
 */
public class VkResponseValidator implements Validator<JsonElement> {
    @Override
    public boolean isValid(JsonElement jsonElement) {
        return !jsonElement.isJsonObject()
                || !jsonElement.getAsJsonObject().has("error")
                && !jsonElement.getAsJsonObject().has("failed");
    }
}
