package api.longpoll.bots.adapters.deserializers;

import api.longpoll.bots.methods.impl.stories.GetViewers;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.User;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Deserializes JSON object to {@link GetViewers.ResponseBody}.
 */
public class StoriesGetViewersResultDeserializer implements JsonDeserializer<GetViewers.ResponseBody> {
    private static final Type ITEM_LIST = new TypeToken<List<GetViewers.ResponseBody.Response>>() {}.getType();
    private static final Type USER_LIST = new TypeToken<List<User>>() {}.getType();

    @Override
    public GetViewers.ResponseBody deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonResponse = jsonElement.getAsJsonObject().get("response").getAsJsonObject();
        JsonArray jsonItems = jsonResponse.getAsJsonArray("items");

        VkList<Object> response = new VkList<>();
        response.setCount(jsonResponse.get("count").getAsInt());
        response.setItems(jsonDeserializationContext.deserialize(
                jsonItems,
                getType(jsonItems)
        ));

        GetViewers.ResponseBody vkResponse = new GetViewers.ResponseBody();
        vkResponse.setResponse(response);
        return vkResponse;
    }

    private Type getType(JsonArray jsonItems) {
        return jsonItems.size() == 0 || jsonItems.get(0).getAsJsonObject().has("user_id")
                ? ITEM_LIST
                : USER_LIST;
    }
}
