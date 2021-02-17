package api.longpoll.bots.converters.response.stories;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.User;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.stories.StoriesGetViewersResponseItem;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class StoriesGetViewersResultConverter extends JsonToPojoConverter<GenericResult<VkList<Object>>> {
    @Override
    public GenericResult<VkList<Object>> convert(JsonObject jsonObject) {
        JsonArray jsonArray = jsonObject.getAsJsonObject("response").getAsJsonArray("items");
        Type type = jsonArray.size() == 0 || jsonArray.get(0).getAsJsonObject().has("user_id")
                ? new TypeToken<GenericResult<VkList<StoriesGetViewersResponseItem>>>() {}.getType()
                : new TypeToken<GenericResult<VkList<User>>>() {}.getType();
        return gson.fromJson(jsonObject, type);
    }
}
