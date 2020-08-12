package bots.longpoll.sdk.validators;

import com.google.gson.JsonObject;

public interface Validator {
	boolean isValid(JsonObject jsonObject);
}
