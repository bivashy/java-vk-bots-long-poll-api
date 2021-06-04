package api.longpoll.bots.exceptions;

import com.google.gson.JsonObject;

/**
 * A checked exception occurs in <b>Java VK Bots Long Poll API</b> library when VK server returns error JSON.
 *
 * @see <a href="https://vk.com/dev/errors">List of possible errors.</a>
 */
public class BotsLongPollAPIException extends BotsLongPollException {
    /**
     * VK API error response.
     */
    private JsonObject jsonError;

    public BotsLongPollAPIException(JsonObject jsonError) {
        super(jsonError.toString());
        this.jsonError = jsonError;
    }

    @Override
    public String getMessage() {
        return jsonError.toString();
    }

    public JsonObject getJsonError() {
        return jsonError;
    }
}
