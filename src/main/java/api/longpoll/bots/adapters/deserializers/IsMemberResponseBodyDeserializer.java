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
 * Deserializes JSON object to {@link IsMember.ResponseBody}.
 */
public class IsMemberResponseBodyDeserializer implements JsonDeserializer<IsMember.ResponseBody> {
    @Override
    public IsMember.ResponseBody deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonElement jsonResponse = jsonElement.getAsJsonObject().get("response");

        IsMember.ResponseBody response = new IsMember.ResponseBody();
        response.setResponse(deserializeResponse(jsonResponse, jsonDeserializationContext));
        return response;
    }

    private Object deserializeResponse(JsonElement jsonResponse, JsonDeserializationContext jsonDeserializationContext) {
        if (jsonResponse.isJsonPrimitive()) {
            return jsonResponse.getAsInt() == 1;
        } else if (jsonResponse.isJsonObject()) {
            return jsonDeserializationContext.deserialize(jsonResponse, IsMember.ResponseBody.Response.class);
        } else {
            return jsonDeserializationContext.deserialize(
                    jsonResponse,
                    TypeToken.getParameterized(List.class, IsMember.ResponseBody.Response.class).getType()
            );
        }
    }
}
