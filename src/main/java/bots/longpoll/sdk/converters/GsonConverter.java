package bots.longpoll.sdk.converters;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class GsonConverter {
	protected Gson gson = new GsonBuilder()
			.setPrettyPrinting()
			.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			.addDeserializationExclusionStrategy(getDeserializationExclusionStrategy())
			.create();

	private ExclusionStrategy getDeserializationExclusionStrategy() {
		return new ExclusionStrategy() {
			@Override
			public boolean shouldSkipField(FieldAttributes fieldAttributes) {
				return GsonConverter.this.shouldSkipField(fieldAttributes);
			}

			@Override
			public boolean shouldSkipClass(Class<?> aClass) {
				return GsonConverter.this.shouldSkipClass(aClass);
			}
		};
	}

	protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
		return false;
	}
	protected boolean shouldSkipClass(Class<?> aClass) {
		return false;
	}
}
