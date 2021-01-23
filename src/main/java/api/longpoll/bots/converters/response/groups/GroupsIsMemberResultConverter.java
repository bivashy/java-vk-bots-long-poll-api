package api.longpoll.bots.converters.response.groups;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.groups.GroupsIsMemberResponse;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class GroupsIsMemberResultConverter extends JsonToPojoConverter<GenericResult<Object>> {
    @Override
    public GenericResult<Object> convert(JsonObject jsonObject) {
        JsonElement jsonElement = jsonObject.get("response");
        Object response;
        if (jsonElement.isJsonPrimitive()) {
            response = gson.fromJson(jsonElement, Integer.class) == 1;
        } else if (jsonElement.isJsonObject()) {
            response = gson.fromJson(jsonElement, GroupsIsMemberResponse.class);
        } else {
            response = gson.fromJson(jsonElement, new TypeToken<List<GroupsIsMemberResponse>>() {}.getType());
        }
        GenericResult<Object> result = new GenericResult<>();
        result.setResponse(response);
        return result;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return Object.class.equals(fieldAttributes.getDeclaredClass());
    }
}
