package api.longpoll.bots.adapters.deserializers;

import api.longpoll.bots.methods.impl.groups.GetMembers;
import api.longpoll.bots.model.objects.additional.VkList;
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
 * Deserializes JSON object to {@link GetMembers.ResponseBody}.
 */
public class GetMemberResponseBodyDeserializer implements JsonDeserializer<GetMembers.ResponseBody> {
    @Override
    public GetMembers.ResponseBody deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonResponse = jsonElement.getAsJsonObject().getAsJsonObject("response");
        JsonArray jsonItems = jsonResponse.getAsJsonArray("items");

        VkList<Object> vkList = new VkList<>();
        vkList.setCount(jsonResponse.get("count").getAsInt());
        vkList.setItems(context.deserialize(jsonItems, guessItemsType(jsonItems)));

        GetMembers.ResponseBody responseBody = new GetMembers.ResponseBody();
        responseBody.setResponse(vkList);
        return responseBody;
    }

    private Type guessItemsType(JsonArray jsonItems) {
        return jsonItems.isEmpty() || jsonItems.get(0).isJsonPrimitive()
                ? TypeToken.getParameterized(List.class, Integer.class).getType()
                : TypeToken.getParameterized(List.class, GetMembers.ResponseBody.Item.class).getType();
    }
}
