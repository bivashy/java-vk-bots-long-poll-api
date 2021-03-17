package api.longpoll.bots.utils.converters;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.utils.json.GsonUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.List;
import java.util.stream.Collectors;

public class BulkConverterUtil {
    public static <T> List<T> convert(JsonArray jsonArray, JsonToPojoConverter<T> converter) {
        return GsonUtil.stream(jsonArray)
                .map(JsonElement::getAsJsonObject)
                .map(converter::convert)
                .collect(Collectors.toList());
    }
}
