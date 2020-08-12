package api.longpoll.bots.validators;

import com.google.gson.JsonObject;

public interface Validator {
	boolean isValid(JsonObject jsonObject);
}
