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
    public IsMember.ResponseBody deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonElement jsonResponse = jsonElement.getAsJsonObject().get("response");

        IsMember.ResponseBody responseBody = new IsMember.ResponseBody();
        responseBody.setResponse(deserializeResponse(jsonResponse, context));
        return responseBody;
    }

    private Object deserializeResponse(JsonElement jsonResponse, JsonDeserializationContext context) {
        if (jsonResponse.isJsonPrimitive()) {
            return jsonResponse.getAsInt() == 1;
        }

        if (jsonResponse.isJsonObject()) {
            return context.deserialize(jsonResponse, IsMember.ResponseBody.Response.class);
        }

        return context.deserialize(jsonResponse, TypeToken.getParameterized(List.class, IsMember.ResponseBody.Response.class).getType());
    }
}
