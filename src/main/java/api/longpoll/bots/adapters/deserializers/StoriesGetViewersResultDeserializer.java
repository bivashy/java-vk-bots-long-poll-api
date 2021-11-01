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
 * Deserializes JSON object to {@link GetViewers.Response}.
 */
public class StoriesGetViewersResultDeserializer implements JsonDeserializer<GetViewers.Response> {
    private static final Type ITEM_LIST = new TypeToken<List<GetViewers.Response.ResponseObject>>() {
    }.getType();
    private static final Type USER_LIST = new TypeToken<List<User>>() {
    }.getType();

    @Override
    public GetViewers.Response deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonResponse = jsonElement.getAsJsonObject().get("response").getAsJsonObject();
        JsonArray jsonItems = jsonResponse.getAsJsonArray("items");

        VkList<Object> responseObject = new VkList<>();
        responseObject.setCount(jsonResponse.get("count").getAsInt());
        responseObject.setItems(jsonDeserializationContext.deserialize(
                jsonItems,
                getType(jsonItems)
        ));

        GetViewers.Response response = new GetViewers.Response();
        response.setResponseObject(responseObject);
        return response;
    }

    private Type getType(JsonArray jsonItems) {
        return jsonItems.size() == 0 || jsonItems.get(0).getAsJsonObject().has("user_id")
                ? ITEM_LIST
                : USER_LIST;
    }
}
