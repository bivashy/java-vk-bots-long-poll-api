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
 * Deserializes JSON object to {@link GetMembers.Response}.
 */
public class GroupsGetMemberResponseDeserializer implements JsonDeserializer<GetMembers.Response> {
    private static final Type INTEGER_LIST = new TypeToken<List<Integer>>() {}.getType();
    private static final Type ITEM_LIST = new TypeToken<List<GetMembers.Response.Item>>() {}.getType();

    @Override
    public GetMembers.Response deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonResponse = jsonElement.getAsJsonObject().getAsJsonObject("response");
        JsonArray jsonItems = jsonResponse.getAsJsonArray("items");

        VkList<Object> vkList = new VkList<>();
        vkList.setCount(jsonResponse.get("count").getAsInt());
        vkList.setItems(jsonDeserializationContext.deserialize(
                jsonItems,
                jsonItems.size() == 0 || jsonItems.get(0).isJsonPrimitive()
                        ? INTEGER_LIST
                        : ITEM_LIST
        ));

        GetMembers.Response response = new GetMembers.Response();
        response.setResponseObject(vkList);
        return response;
    }
}
