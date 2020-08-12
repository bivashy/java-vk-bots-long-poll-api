package bots.longpoll.sdk.validators.impl;

import bots.longpoll.sdk.validators.Validator;
import com.google.gson.JsonObject;

public class ResponseValidator implements Validator {
	private static final String ERROR_FIELD = "error";
	private static final String FAILED_FIELD = "failed";

	@Override
	public boolean isValid(JsonObject jsonObject) {
		return !jsonObject.has(ERROR_FIELD) && !jsonObject.has(FAILED_FIELD);
	}
}
