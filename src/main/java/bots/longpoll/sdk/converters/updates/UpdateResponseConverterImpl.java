package bots.longpoll.sdk.converters.updates;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.update.Update;
import bots.longpoll.sdk.model.update.UpdateResponse;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class UpdateResponseConverterImpl extends JsonToPojoConverter<UpdateResponse> {
	private static final String TS_FIELD = "ts";
	private static final String UPDATES_FIELD = "updates";
	private UpdateConverterImpl updateConverter = new UpdateConverterImpl();

	@Override
	public UpdateResponse convert(JsonObject jsonObject) {
		UpdateResponse updateResponse = gson.fromJson(jsonObject, UpdateResponse.class);

		if (jsonObject.has(UPDATES_FIELD)) {
			JsonArray updates = jsonObject.getAsJsonArray(UPDATES_FIELD);
			List<Update> updateList = new ArrayList<>(updates.size());
			updates.forEach(update -> updateList.add(updateConverter.convert(update.getAsJsonObject())));
			updateResponse.setUpdates(updateList);
		}

		return updateResponse;
	}

	@Override
	protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
		return UpdateResponse.class.equals(fieldAttributes.getDeclaringClass())
				&& List.class.equals(fieldAttributes.getDeclaredClass())
				&& UPDATES_FIELD.equals(fieldAttributes.getName());
	}
}
