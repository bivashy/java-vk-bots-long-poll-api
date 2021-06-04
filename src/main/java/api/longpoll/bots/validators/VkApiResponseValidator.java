package api.longpoll.bots.validators;

import com.google.gson.JsonObject;

/**
 * VK response validator.
 */
public class VkApiResponseValidator implements Validator<JsonObject> {
    @Override
    public boolean isValid(JsonObject jsonObject) {
        return !jsonObject.has("error") && !jsonObject.has("failed");
    }
}
