package api.longpoll.bots.converters.response.groups;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.response.groups.GroupsIsMemberResult;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class GroupsIsMemberResultConverterImpl extends JsonToPojoConverter<GroupsIsMemberResult> {
    private static final String RESPONSE_FIELD = "response";

    @Override
    public GroupsIsMemberResult convert(JsonObject jsonObject) {
        JsonElement jsonElement = jsonObject.get(RESPONSE_FIELD);
        Object response;
        if (jsonElement.isJsonPrimitive()) {
            response = gson.fromJson(jsonElement, Integer.class) == 1;
        } else if (jsonElement.isJsonObject()) {
            response = gson.fromJson(jsonElement, GroupsIsMemberResult.Response.class);
        } else {
            response = gson.fromJson(jsonElement, new TypeToken<List<GroupsIsMemberResult.Response>>() {}.getType());
        }
        return new GroupsIsMemberResult().setResponse(response);
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return Object.class.equals(fieldAttributes.getDeclaredClass());
    }
}
