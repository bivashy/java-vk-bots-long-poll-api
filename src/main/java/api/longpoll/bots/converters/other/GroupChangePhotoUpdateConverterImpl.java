package api.longpoll.bots.converters.other;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.other.GroupChangePhotoEvent;
import com.google.gson.JsonObject;

public class GroupChangePhotoUpdateConverterImpl extends JsonToPojoConverter<GroupChangePhotoEvent> {
	@Override
	public GroupChangePhotoEvent convert(JsonObject jsonObject) {
		return gson.fromJson(jsonObject, GroupChangePhotoEvent.class);
	}
}
