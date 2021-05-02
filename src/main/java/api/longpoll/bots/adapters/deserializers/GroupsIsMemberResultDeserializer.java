package api.longpoll.bots.adapters.deserializers;

import api.longpoll.bots.model.response.groups.GroupsIsMemberResult;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Deserializes JSON object to {@link GroupsIsMemberResult}.
 */
public class GroupsIsMemberResultDeserializer implements JsonDeserializer<GroupsIsMemberResult> {
    private static final Type LIST_TYPE = new TypeToken<List<GroupsIsMemberResult.Response>>() {}.getType();

    @Override
    public GroupsIsMemberResult deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonElement jsonResponse = jsonElement.getAsJsonObject().get("response");

        GroupsIsMemberResult groupsIsMemberResult = new GroupsIsMemberResult();
        groupsIsMemberResult.setResponse(deserializeResponse(jsonResponse, jsonDeserializationContext));
        return groupsIsMemberResult;
    }

    private Object deserializeResponse(JsonElement jsonResponse, JsonDeserializationContext jsonDeserializationContext) {
        if (jsonResponse.isJsonPrimitive()) {
            return jsonResponse.getAsInt() == 1;
        } else if (jsonResponse.isJsonObject()) {
            return jsonDeserializationContext.deserialize(jsonResponse, GroupsIsMemberResult.Response.class);
        } else {
            return jsonDeserializationContext.deserialize(jsonResponse, LIST_TYPE);
        }
    }
}
