package api.longpoll.bots.adapters.deserializers;

import api.longpoll.bots.methods.impl.groups.IsMember;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Deserializes JSON object to {@link IsMember.Response}.
 */
public class GroupsIsMemberResponseDeserializer implements JsonDeserializer<IsMember.Response> {
    private static final Type LIST_TYPE = new TypeToken<List<IsMember.Response.ResponseObject>>() {
    }.getType();

    @Override
    public IsMember.Response deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonElement jsonResponse = jsonElement.getAsJsonObject().get("response");

        IsMember.Response response = new IsMember.Response();
        response.setResponseObject(deserializeResponse(jsonResponse, jsonDeserializationContext));
        return response;
    }

    private Object deserializeResponse(JsonElement jsonResponse, JsonDeserializationContext jsonDeserializationContext) {
        if (jsonResponse.isJsonPrimitive()) {
            return jsonResponse.getAsInt() == 1;
        } else if (jsonResponse.isJsonObject()) {
            return jsonDeserializationContext.deserialize(jsonResponse, IsMember.Response.ResponseObject.class);
        } else {
            return jsonDeserializationContext.deserialize(jsonResponse, LIST_TYPE);
        }
    }
}
