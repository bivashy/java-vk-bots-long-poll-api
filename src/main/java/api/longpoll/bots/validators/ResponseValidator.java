package api.longpoll.bots.validators;

import com.google.gson.JsonObject;

public class ResponseValidator implements Validator {
    @Override
    public boolean isValid(JsonObject jsonObject) {
        return !jsonObject.has("error") && !jsonObject.has("failed");
    }
}
