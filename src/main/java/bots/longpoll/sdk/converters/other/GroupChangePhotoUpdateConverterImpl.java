package bots.longpoll.sdk.converters.other;

import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.model.other.GroupChangePhotoUpdate;
import com.google.gson.JsonObject;

public class GroupChangePhotoUpdateConverterImpl extends JsonToPojoConverter<GroupChangePhotoUpdate> {
	@Override
	public GroupChangePhotoUpdate convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, GroupChangePhotoUpdate.class);
	}
}
