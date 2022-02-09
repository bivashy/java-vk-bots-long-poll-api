package api.longpoll.bots.exceptions;

import com.google.gson.JsonObject;

/**
 * A checked exception occurs in <b>Java VK Bots Long Poll API</b> library when VK server returns error JSON.
 *
 * @see <a href="https://vk.com/dev/errors">List of possible errors.</a>
 */
public class VkApiResponseException extends VkApiException {
    /**
     * Error object.
     */
    private final JsonObject error;

    public VkApiResponseException(String message, JsonObject error) {
        super(message);
        this.error = error;
    }

    public JsonObject getError() {
        return error;
    }
}
