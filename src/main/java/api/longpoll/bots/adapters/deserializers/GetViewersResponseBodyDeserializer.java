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
public class GetViewersResponseBodyDeserializer implements JsonDeserializer<GetViewers.ResponseBody> {
    @Override
    public GetViewers.ResponseBody deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonResponse = jsonElement.getAsJsonObject().get("response").getAsJsonObject();
        JsonArray jsonItems = jsonResponse.getAsJsonArray("items");

        VkList<Object> vkList = new VkList<>();
        vkList.setCount(jsonResponse.get("count").getAsInt());
        vkList.setItems(context.deserialize(jsonItems, guessItemsType(jsonItems)));

        GetViewers.ResponseBody responseBody = new GetViewers.ResponseBody();
        responseBody.setResponse(vkList);
        return responseBody;
    }

    private Type guessItemsType(JsonArray jsonItems) {
        return jsonItems.isEmpty() || jsonItems.get(0).getAsJsonObject().has("user_id")
                ? TypeToken.getParameterized(List.class, GetViewers.ResponseBody.Response.class).getType()
                : TypeToken.getParameterized(List.class, User.class).getType();
    }
}
