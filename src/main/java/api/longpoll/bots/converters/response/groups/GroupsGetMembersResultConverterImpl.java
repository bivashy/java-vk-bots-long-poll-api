package api.longpoll.bots.converters.response.groups;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.response.groups.GroupsGetMembersResult;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class GroupsGetMembersResultConverterImpl extends JsonToPojoConverter<GroupsGetMembersResult> {
    private static final String RESPONSE_FIELD = "response";
    private static final String ITEMS_FIELD = "items";

    @Override
    public GroupsGetMembersResult convert(JsonObject jsonObject) {
        GroupsGetMembersResult groupsGetMembers = gson.fromJson(jsonObject, GroupsGetMembersResult.class);

        VkList<Object> response = groupsGetMembers.getResponse();
        JsonArray jsonArray = jsonObject.getAsJsonObject(RESPONSE_FIELD).getAsJsonArray(ITEMS_FIELD);
        response.setItems(
                jsonArray.size() > 0 && jsonArray.get(0).isJsonObject()
                        ? gson.fromJson(jsonArray, new TypeToken<List<GroupsGetMembersResult.Item>>() {}.getType())
                        : gson.fromJson(jsonArray, new TypeToken<List<Integer>>() {}.getType())
        );

        return groupsGetMembers;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return List.class.equals(fieldAttributes.getDeclaredClass());
    }
}
