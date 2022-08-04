package api.longpoll.bots.validator;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.function.Predicate;

/**
 * Default implementation of VK API response validator.
 */
public class VkResponseBodyValidator implements Predicate<String> {
    /**
     * {@link Gson} object.
     */
    private final Gson gson = new Gson();

    @Override
    public boolean test(String responseBody) {
        JsonElement jsonElement = gson.fromJson(responseBody, JsonElement.class);
        return !jsonElement.isJsonObject()
                || !jsonElement.getAsJsonObject().has("error")
                && !jsonElement.getAsJsonObject().has("failed");
    }
}
