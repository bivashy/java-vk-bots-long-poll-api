package api.longpoll.bots.adapters.deserializers;

import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.User;
import api.longpoll.bots.model.response.stories.StoriesGetViewersResult;
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
 * Deserializes JSON object to {@link StoriesGetViewersResult}.
 */
public class StoriesGetViewersResultDeserializer implements JsonDeserializer<StoriesGetViewersResult> {
    private static final Type ITEM_LIST = new TypeToken<List<StoriesGetViewersResult.Response>>() {}.getType();
    private static final Type USER_LIST = new TypeToken<List<User>>() {}.getType();

    @Override
    public StoriesGetViewersResult deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonResponse = jsonElement.getAsJsonObject().get("response").getAsJsonObject();
        JsonArray jsonItems = jsonResponse.getAsJsonArray("items");

        VkList<Object> response = new VkList<>();
        response.setCount(jsonResponse.get("count").getAsInt());
        response.setItems(jsonDeserializationContext.deserialize(
                jsonItems,
                getType(jsonItems)
        ));

        StoriesGetViewersResult storiesGetViewersResult = new StoriesGetViewersResult();
        storiesGetViewersResult.setResponse(response);
        return storiesGetViewersResult;
    }

    private Type getType(JsonArray jsonItems) {
        return jsonItems.size() == 0 || jsonItems.get(0).getAsJsonObject().has("user_id")
                ? ITEM_LIST
                : USER_LIST;
    }
}
