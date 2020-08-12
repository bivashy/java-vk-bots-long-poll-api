package api.longpoll.bots.converters;

import com.google.gson.JsonObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericConverter<Target> extends JsonToPojoConverter<Target> {
	@Override
	public Target convert(JsonObject jsonObject) {
		Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		return gson.fromJson(jsonObject, type);
	}
}
